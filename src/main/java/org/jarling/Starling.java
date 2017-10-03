package org.jarling;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.jarling.api.*;
import org.jarling.exceptions.StarlingBankRequestException;
import org.jarling.http.HttpParameter;
import org.jarling.http.HttpResponse;
import org.jarling.models.*;
import org.jarling.services.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 *
 * API class responsible for creating services to access Starling Bank resources
 *
 * @author Nav Roudsari (nav@rzari.co.uk)
 *
 */
public final class Starling extends StarlingBase implements StarlingBank{

    private static ApiService apiService;

    public Starling(StarlingBankEnvironment environment, String accessToken){
        if (accessToken == null || accessToken.equals("")){
            throw new IllegalArgumentException("access token cannot be null or blank");
        }
        else {
            apiService = new ApiService(environment, accessToken);
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
