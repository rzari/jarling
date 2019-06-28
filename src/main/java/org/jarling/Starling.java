package org.jarling;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.jarling.exceptions.StarlingBankRequestException;
import org.jarling.http.HttpParameter;
import org.jarling.http.HttpResponse;
import org.jarling.api.AccountResource;
import org.jarling.api.AddressResource;
import org.jarling.api.CardResource;
import org.jarling.api.ContactResource;
import org.jarling.api.CustomerResource;
import org.jarling.api.DirectDebitMandateResource;
import org.jarling.api.MerchantResource;
import org.jarling.api.PaymentResource;
import org.jarling.api.SavingsGoalResource;
import org.jarling.api.TransactionDirectDebitResource;
import org.jarling.api.TransactionFasterPaymentInResource;
import org.jarling.api.TransactionFasterPaymentOutResource;
import org.jarling.api.TransactionMasterCardResource;
import org.jarling.api.TransactionResource;
import org.jarling.api.WhoAmIResource;
import org.jarling.models.accounts.Account;
import org.jarling.models.accounts.AccountBalance;
import org.jarling.models.budgeting.SavingsGoal;
import org.jarling.models.cards.Card;
import org.jarling.models.common.*;
import org.jarling.models.contacts.Contact;
import org.jarling.models.contacts.ContactAccount;
import org.jarling.models.contacts.ContactAccountType;
import org.jarling.models.customers.Customer;
import org.jarling.models.customers.WhoAmI;
import org.jarling.models.directDebits.DirectDebitMandate;
import org.jarling.models.directDebits.DirectDebitTransaction;
import org.jarling.models.merchants.Merchant;
import org.jarling.models.merchants.MerchantLocation;
import org.jarling.models.payments.Payment;
import org.jarling.models.transactions.FasterPaymentsInTransaction;
import org.jarling.models.transactions.FasterPaymentsOutTransaction;
import org.jarling.models.transactions.MasterCardTransaction;
import org.jarling.models.transactions.Transaction;
import org.jarling.services.ApiService;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 *
 * API class responsible for creating services to access Starling Bank resources
 *
 * @author Nav Roudsari (nav@rzari.co.uk)
 *
 */
public final class Starling extends StarlingBase implements StarlingBank {
    private static ApiService apiService;

    /**
     * @deprecated V1 APIs will be retired in Q4 2019. Use {@link org.jarling.v2.Starling(StarlingBankEnvironment, String)} ()}
     */
    @Deprecated
    public Starling(StarlingBankEnvironment environment, String accessToken) {
        if (accessToken == null || accessToken.equals("")) {
            throw new IllegalArgumentException("access token cannot be null or blank");
        } else {
            apiService = new ApiService(StarlingBankApiVersion.V1, environment, accessToken);
        }
    }

    @Override
    public Account getAccount() throws StarlingBankRequestException {
        return gson.fromJson(apiService.get("/accounts").asString(), Account.class);
    }

    @Override
    public AccountBalance getAccountBalance() throws StarlingBankRequestException {
        return gson.fromJson(apiService.get("/accounts/balance").asString(), AccountBalance.class);
    }

    @Override
    public Addresses getAddresses() throws StarlingBankRequestException {
        return gson.fromJson(apiService.get("/addresses").asString(), Addresses.class);
    }

    public Card getCard() throws StarlingBankRequestException {
        return gson.fromJson(apiService.get("/cards").asString(), Card.class);
    }

    @Override
    public Contact getContact(String id) throws StarlingBankRequestException {
        return gson.fromJson(apiService.get("/contacts/" + id).asString(), Contact.class);
    }

    @Override
    public List<Contact> listContacts() throws StarlingBankRequestException {
        return fromJsonList(Contact[].class, apiService.get("/contacts").asString(), "contacts");
    }

    @Override
    public Contact createContact(String name, String sortCode, String accountNumber) throws StarlingBankRequestException {
        ContactAccount contactAccount = new ContactAccount(name, sortCode, accountNumber, ContactAccountType.UK_ACCOUNT_AND_SORT_CODE);
        HttpResponse newContactResponse = apiService.post("/contacts", null, null, gson.toJson(contactAccount));

        String newCustomerUrl = apiService.getLocationHeader(newContactResponse);

        return gson.fromJson(apiService.get(newCustomerUrl).asString(), Contact.class);
    }

    @Override
    public void deleteContact(String id) throws StarlingBankRequestException {
        apiService.delete("/contacts/" + id);
    }

    @Override
    public ContactAccount getContactAccount(String contactId, String contactAccountId) throws StarlingBankRequestException {
        return gson.fromJson(apiService.get("/contacts/" + contactId + "/accounts/" + contactAccountId)
                .asString(), ContactAccount.class);
    }

    @Override
    public List<ContactAccount> listContactAccounts(String contactId) throws StarlingBankRequestException {
        return fromJsonList(ContactAccount[].class, apiService.get("/contacts/" + contactId + "/accounts").asString(), "contactAccounts");
    }

    @Override
    public Customer getCustomer() throws StarlingBankRequestException {
        return gson.fromJson(apiService.get("/customers").asString(), Customer.class);
    }

    @Override
    public DirectDebitMandate getDirectDebitMandate(String id) throws StarlingBankRequestException {
        return gson.fromJson(apiService.get("/direct-debit/mandates/" + id).asString(), DirectDebitMandate.class);
    }

    @Override
    public List<DirectDebitMandate> listDirectDebitMandates() throws StarlingBankRequestException {
        return fromJsonList(DirectDebitMandate[].class, apiService.get("/direct-debit/mandates").asString(), "mandates");
    }

    @Override
    public void cancelDirectDebitMandate(String id) throws StarlingBankRequestException {
        apiService.delete("/direct-debit/mandates/" + id);
    }

    @Override
    public DirectDebitTransaction getDirectDebitTransaction(String id) throws StarlingBankRequestException {
        return gson.fromJson(apiService.get("/transactions/direct-debit" + id).asString(), DirectDebitTransaction.class);
    }

    @Override
    public List<DirectDebitTransaction> listDirectDebitTransactions() throws StarlingBankRequestException {
        return fromJsonList(DirectDebitTransaction[].class, apiService.get("/transactions/direct-debit").asString(), "transactions");
    }

    @Override
    public List<DirectDebitTransaction> listDirectDebitTransactions(Date from, Date to) throws StarlingBankRequestException {
        HttpParameter[] httpParameters = new HttpParameter[2];
        httpParameters[0] = new HttpParameter("from", transactionDateFormat.format(from));
        httpParameters[1] = new HttpParameter("to",  transactionDateFormat.format(to));

        String result = apiService.get("/transactions/direct-debit", httpParameters, null).asString();
        return fromJsonList(DirectDebitTransaction[].class, result, "transactions");
    }

    @Override
    public FasterPaymentsInTransaction getFasterPaymentsInTransaction(String id) throws StarlingBankRequestException {
        return gson.fromJson(apiService.get("/transactions/fps/in/" + id).asString(), FasterPaymentsInTransaction.class);
    }

    @Override
    public List<FasterPaymentsInTransaction> listFasterPaymentsInTransactions() throws StarlingBankRequestException {
        return fromJsonList(FasterPaymentsInTransaction[].class, apiService.get("/transactions/fps/in/").asString(), "transactions");
    }

    @Override
    public List<FasterPaymentsInTransaction> listFasterPaymentsInTransactions(Date from, Date to) throws StarlingBankRequestException {
        HttpParameter[] httpParameters = new HttpParameter[2];
        httpParameters[0] = new HttpParameter("from", transactionDateFormat.format(from));
        httpParameters[1] = new HttpParameter("to",  transactionDateFormat.format(to));

        String result = apiService.get("/transactions/fps/in", httpParameters, null).asString();
        return fromJsonList(FasterPaymentsInTransaction[].class, result, "transactions");
    }

    @Override
    public FasterPaymentsOutTransaction getFasterPaymentsOutTransaction(String id) throws StarlingBankRequestException {
        return gson.fromJson(apiService.get("/transactions/fps/out/" + id).asString(), FasterPaymentsOutTransaction.class);
    }

    @Override
    public List<FasterPaymentsOutTransaction> listFasterPaymentsOutTransactions() throws StarlingBankRequestException {
        return fromJsonList(FasterPaymentsOutTransaction[].class, apiService.get("/transactions/fps/out").asString(), "transactions");
    }

    @Override
    public List<FasterPaymentsOutTransaction> listFasterPaymentsOutTransactions(Date from, Date to) throws StarlingBankRequestException {
        HttpParameter[] httpParameters = new HttpParameter[2];
        httpParameters[0] = new HttpParameter("from", transactionDateFormat.format(from));
        httpParameters[1] = new HttpParameter("to",  transactionDateFormat.format(to));

        String result = apiService.get("/transactions/fps/out", httpParameters, null).asString();
        return fromJsonList(FasterPaymentsOutTransaction[].class, result, "transactions");
    }

    @Override
    public MasterCardTransaction getMasterCardTransaction(String id) throws StarlingBankRequestException {
        return gson.fromJson(apiService.get("/transactions/mastercard/" + id).asString(), MasterCardTransaction.class);
    }

    @Override
    public List<MasterCardTransaction> listMasterCardTransactions() throws StarlingBankRequestException {
        return fromJsonList(MasterCardTransaction[].class, apiService.get("/transactions/mastercard").asString(), "transactions");
    }

    @Override
    public List<MasterCardTransaction> listMasterCardTransactions(Date from, Date to) throws StarlingBankRequestException {
        HttpParameter[] httpParameters = new HttpParameter[2];
        httpParameters[0] = new HttpParameter("from", transactionDateFormat.format(from));
        httpParameters[1] = new HttpParameter("to",  transactionDateFormat.format(to));

        String result = apiService.get("/transactions/mastercard", httpParameters, null).asString();
        return fromJsonList(MasterCardTransaction[].class, result, "transactions");
    }

    @Override
    public Merchant getMerchant(String id) throws StarlingBankRequestException {
        return gson.fromJson(apiService.get("/merchants/" + id).asString(), Merchant.class);
    }

    @Override
    public MerchantLocation getMerchantLocation(String merchantId, String locationId) throws StarlingBankRequestException {
        return gson.fromJson(apiService.get("/merchants/" + merchantId + "/locations/" + locationId).asString(), MerchantLocation.class);
    }

    @Override
    public List<Payment> listPayments() throws StarlingBankRequestException {
        return fromJsonList(Payment[].class, apiService.get("/payments/scheduled").asString(), "paymentOrders");
    }

    @Override
    public Payment makeLocalPayment(String destinationAccountUid, String reference, BigDecimal amount) throws StarlingBankRequestException {
        JsonObject localPayment = new JsonObject();
        JsonObject paymentDetail = new JsonObject();

        localPayment.addProperty("destinationAccountUid", destinationAccountUid);
        localPayment.addProperty("reference", reference);
        localPayment.add("payment", paymentDetail);

        paymentDetail.addProperty("amount", amount);
        paymentDetail.addProperty("currency", "GBP");

        HttpResponse makePaymentResponse = apiService.post("/payments/local", null, null, localPayment.toString());
        final String paymentId = apiService.getLocationHeader(makePaymentResponse).replace("/payments/local/", "");

        return listPayments().stream().filter(payment -> payment.getPaymentOrderId().equals(paymentId)).findFirst().orElse(null);
    }

    @Override
    public Payment makeScheduledPayment(String destinationAccountUid, String reference, BigDecimal amount, RecurrenceRule recurrenceRule) throws StarlingBankRequestException {
        JsonObject scheduledPayment = new JsonObject();
        JsonObject paymentDetail = new JsonObject();
        JsonObject recurrenceRuleDetail = new JsonObject();
        JsonArray recurrenceRuleDays = new JsonArray();

        scheduledPayment.addProperty("destinationAccountUid", destinationAccountUid);
        scheduledPayment.addProperty("reference", reference);
        scheduledPayment.add("payment", paymentDetail);

        paymentDetail.addProperty("amount", amount);
        paymentDetail.addProperty("currency", "GBP");

        for (DayOfWeek day : recurrenceRule.getDays()){
            recurrenceRuleDays.add(day.name());
        }
        recurrenceRuleDetail.addProperty("count", recurrenceRule.getCount());
        recurrenceRuleDetail.add("days", recurrenceRuleDays);
        recurrenceRuleDetail.addProperty("frequency", recurrenceRule.getFrequency().getValue());
        recurrenceRuleDetail.addProperty("interval", recurrenceRule.getInterval());
        recurrenceRuleDetail.addProperty("monthDay", recurrenceRule.getMonthDay());
        recurrenceRuleDetail.addProperty("monthWeek", recurrenceRule.getMonthWeek());
        recurrenceRuleDetail.addProperty("startDate", transactionDateFormat.format(recurrenceRule.getStartDate()));
        recurrenceRuleDetail.addProperty("untilDate", transactionDateFormat.format(recurrenceRule.getUntilDate()));
        recurrenceRuleDetail.addProperty("weekStart", recurrenceRule.getWeekStart().name());
        scheduledPayment.add("recurrenceRule", recurrenceRuleDetail);

        HttpResponse makePaymentResponse = apiService.post("/payments/scheduled", null, null, scheduledPayment.toString());
        final String paymentId = apiService.getLocationHeader(makePaymentResponse).replace("/payments/scheduled/", "");

        return listPayments().stream().filter(payment -> payment.getPaymentOrderId().equals(paymentId)).findFirst().orElse(null);
    }

    @Override
    public Transaction getTransaction(String id) throws StarlingBankRequestException {
        return gson.fromJson(apiService.get("/transactions/" + id).asString(), Transaction.class);
    }

    @Override
    public List<Transaction> listTransactions() throws StarlingBankRequestException {
        return fromJsonList(Transaction[].class, apiService.get("/transactions").asString(), "transactions");
    }

    @Override
    public List<Transaction> listTransactions(Date from, Date to) throws StarlingBankRequestException {
        HttpParameter[] httpParameters = new HttpParameter[2];
        httpParameters[0] = new HttpParameter("from", transactionDateFormat.format(from));
        httpParameters[1] = new HttpParameter("to",  transactionDateFormat.format(to));
        String result = apiService.get("/transactions", httpParameters, apiService.getDefaultRequestHeaders()).asString();
        return fromJsonList(Transaction[].class, result, "transactions");
    }

    @Override
    public WhoAmI getWhoAmI() throws StarlingBankRequestException {
        return gson.fromJson(apiService.get("/me").asString(), WhoAmI.class);
    }


    @Override
    public SavingsGoal getSavingsGoal(String savingsGoalUid) throws StarlingBankRequestException {
        return gson.fromJson(apiService.get("/savings-goals/" + savingsGoalUid).asString(), SavingsGoal.class);
    }


    @Override
    public List<SavingsGoal> listSavingsGoals() throws StarlingBankRequestException {
        return fromJsonList(SavingsGoal[].class, apiService.get("/savings-goals").asString(), "savingsGoalList");
    }

    @Override
    public void deleteSavingsGoal(String savingsGoalUid) throws StarlingBankRequestException {
        apiService.delete("/savings-goals/" + savingsGoalUid);
    }

    @Override
    public Photo getSavingsGoalPhoto(String savingsGoalUid) throws StarlingBankRequestException {
        return gson.fromJson(apiService.get("/savings-goals/" + savingsGoalUid + "/photo").asString(), Photo.class);
    }

    @Override
    public String createSavingsGoal(String name, String currency, BigDecimal targetAmount) throws StarlingBankRequestException {
        return createSavingsGoal(name, currency, targetAmount, "");
    }

    @Override
    public String createSavingsGoal(String name, String currency, BigDecimal targetAmount, String photo) throws StarlingBankRequestException {
        JsonObject savingsGoalRequestJson = new JsonObject();
        JsonObject targetJson = new JsonObject();

        savingsGoalRequestJson.addProperty("name", name);
        savingsGoalRequestJson.addProperty("currency", currency);
        savingsGoalRequestJson.addProperty("photo", photo);
        targetJson.addProperty("currency", currency);
        targetJson.addProperty("minorUnits", targetAmount.multiply(BigDecimal.TEN.multiply(BigDecimal.TEN)).longValue());
        savingsGoalRequestJson.add("target", targetJson);

        HttpResponse savingsGoalResponse = apiService.put("/savings-goals/" + UUID.randomUUID().toString(), null, null, savingsGoalRequestJson.toString());

        JsonObject response = savingsGoalResponse.asJsonObject();

        if (response.get("success").getAsBoolean()){
            return response.get("savingsGoalUid").getAsString();
        }
        return null;
    }

    @Override
    public RecurringTransfer getSavingsGoalRecurringTransfer(String savingsGoalUid) throws StarlingBankRequestException {
        return gson.fromJson(apiService.get("/savings-goals/" + savingsGoalUid + "/recurring-transfer").asString(), RecurringTransfer.class);
    }

    @Override
    public String createSavingsGoalRecurringTransfer(String savingsGoalUid, RecurrenceRule recurrenceRule, CurrencyAndAmount currencyAndAmount) throws StarlingBankRequestException {
        RecurringTransfer recurringTransfer = new RecurringTransfer(recurrenceRule, currencyAndAmount);
        String jsonString = gson.toJson(recurringTransfer);
        HttpResponse response = apiService.put("/savings-goals/" + savingsGoalUid + "/recurring-transfer", null, null, jsonString);

        if (200 == response.getStatusCode()){
            JsonObject json = response.asJsonObject();
            if (json.get("success").getAsBoolean()){
                return json.get("transferUid").getAsString();
            }
        }

        return null;
    }

    @Override
    public void deleteSavingsGoalRecurringTransfer(String savingsGoalUid) throws StarlingBankRequestException {
        apiService.delete("/savings-goals/" + savingsGoalUid + "/recurring-transfer");
    }

    @Override
    public String withdrawMoneyFromSavingsGoal(String savingsGoalUid, Amount amount) throws StarlingBankRequestException {
        String jsonString = gson.toJson(amount);
        HttpResponse response = apiService.put("/savings-goals/" + savingsGoalUid + "/withdraw-money/" + UUID.randomUUID().toString(), null, null, jsonString);

        if (200 == response.getStatusCode()){
            JsonObject json = response.asJsonObject();
            if (json.get("success").getAsBoolean()){
                return json.get("transferUid").getAsString();
            }
        }

        return null;
    }

    @Override
    public String addMoneyToSavingsGoal(String savingsGoalUid, Amount amount) throws StarlingBankRequestException {
        String jsonString = gson.toJson(amount);
        HttpResponse response = apiService.put("/savings-goals/" + savingsGoalUid + "/add-money/" + UUID.randomUUID().toString(), null, null, jsonString);

        if (200 == response.getStatusCode()){
            JsonObject json = response.asJsonObject();
            if (json.get("success").getAsBoolean()){
                return json.get("transferUid").getAsString();
            }
        }

        return null;
    }

    @Override
    public AccountResource account() {
        return this;
    }

    @Override
    public AddressResource address() {
        return this;
    }

    @Override
    public CardResource card() {
        return this;
    }

    @Override
    public ContactResource contact() {
        return this;
    }

    @Override
    public CustomerResource customer() {
        return this;
    }

    @Override
    public DirectDebitMandateResource directDebitMandate() {
        return this;
    }

    @Override
    public MerchantResource merchant() {
        return this;
    }

    @Override
    public PaymentResource payment() {
        return this;
    }

    @Override
    public SavingsGoalResource savingsGoal() {
        return this;
    }

    @Override
    public TransactionResource transaction() {
        return this;
    }

    @Override
    public TransactionMasterCardResource transactionMastercard() {
        return this;
    }

    @Override
    public TransactionFasterPaymentOutResource transactionFpsOut() {
        return this;
    }

    @Override
    public TransactionFasterPaymentInResource transactionFpsIn() {
        return this;
    }

    @Override
    public TransactionDirectDebitResource transactionDirectDebit() {
        return this;
    }

    @Override
    public WhoAmIResource whoAmI() {
        return this;
    }

}
