import org.jarling.Starling;
import org.jarling.StarlingBankEnvironment;
import org.jarling.exceptions.StarlingBankRequestException;
import org.jarling.models.*;
import org.junit.Before;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Properties;

import static org.junit.Assert.*;

/**
 *
 * @author Nav Roudsari (nav@rzari.co.uk)
 *
 */
public class SimpleStarlingAPITests {

    private Starling starling = null;
    private static final DateFormat transactionDateFormat = new SimpleDateFormat("yyyy-mm-dd");

    //Regex for matching dynamic data
    final String regexUUID          = "[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}";
    final String regexSortCode      = "[0-9]{6}";
    final String regexAccountNumber = "[0-9]{8}";
    final String regexBIC           = "([a-zA-Z]{4}[a-zA-Z]{2}[a-zA-Z0-9]{2}([a-zA-Z0-9]{3})?)";
    final String regexIBAN          = "[a-zA-Z]{2}[0-9]{2}[a-zA-Z0-9]{4}[0-9]{7}([a-zA-Z0-9]?){0,16}";
    final String regexPostCode      = "([Gg][Ii][Rr] 0[Aa]{2})|((([A-Za-z][0-9]{1,2})|(([A-Za-z][A-Ha-hJ-Yj-y][0-9]{1,2})|(([A-Za-z][0-9][A-Za-z])|([A-Za-z][A-Ha-hJ-Yj-y][0-9]?[A-Za-z]))))\\s?[0-9][A-Za-z]{2})";
    final String regexEmail         = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)])";


    @Before
    public void setUp() throws Exception{
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("./cfg/sandbox.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.starling = new Starling(StarlingBankEnvironment.SANDBOX, properties.getProperty("starling.access.token"));
    }

    @Test
    public void testGetAccount() throws Exception{
        Account account = starling.getAccount();

        assertTrue(account.getName().matches(regexUUID + " GBP"));
        assertTrue(account.getSortCode().matches(regexSortCode));
        assertTrue(account.getNumber().matches(regexAccountNumber));
        assertEquals("GBP", account.getCurrency());
        assertTrue(account.getBic().matches(regexBIC));
        assertTrue(account.getIban().matches(regexIBAN));
        assertTrue(account.getId().matches(regexUUID));
    }

    @Test
    public void testGetAccountBalance() throws Exception{
        AccountBalance accountBalance = starling.getAccountBalance();

        assertTrue(accountBalance.getAmount().compareTo(BigDecimal.ZERO) == 1);
    }

    @Test
    public void testGetAddresses() throws Exception{
        Addresses addresses = starling.getAddresses();

        Address currentAddress = addresses.getCurrent();
        Address previousAddress = addresses.getPrevious();
        assertNotEquals("", currentAddress.getCity());
        assertNotEquals("", currentAddress.getCountry());
        assertTrue(currentAddress.getPostcode().matches(regexPostCode));
        assertNotEquals("", currentAddress.getStreetAddress());

        assertEquals(null, previousAddress.getCity());
        assertEquals(null, previousAddress.getCountry());
        assertEquals(null, previousAddress.getPostcode());
        assertEquals(null, previousAddress.getStreetAddress());
    }

    @Test
    public void testGetContacts() throws Exception{
        Contact contact = starling.listContacts().get(0);

        assertNotEquals("", contact.getName());
        assertTrue(contact.getId().matches(regexUUID));
    }

    @Test
    public void testWhoAmI() throws Exception{
        WhoAmI whoAmI = starling.getWhoAmI();
        assertTrue(whoAmI.getCustomerUid().matches(regexUUID));
    }

    @Test
    public void testCardResource() throws Exception{
        Card card = starling.getCard();

        assertNotNull(card.getActivated());
        assertNotNull(card.getActivationRequested());
        assertNotNull(card.getDispatchDate());
        assertTrue(card.getId().matches(regexUUID));
        assertNotEquals("", card.getNameOnCard());
        assertEquals(CardType.NONE.getValue(), card.getType());
    }

    @Test
    public void testContactAccountResource() throws Exception{
        Contact contact = starling.listContacts().get(0);
        ContactAccount contactAccount = starling.listContactAccounts(contact.getId()).get(0);

        assertTrue(contactAccount.getId().matches(regexUUID));
        assertNotNull(contactAccount.getType());
        assertNotEquals("", contactAccount.getName());
        assertTrue(contactAccount.getSortCode().matches(regexSortCode));
        assertTrue(contactAccount.getAccountNumber().matches(regexAccountNumber));
    }

    @Test
    public void testCustomerResource() throws Exception{
        Customer customer = starling.getCustomer();

        assertTrue(customer.getCustomerUid().matches(regexUUID));
        assertNotNull(customer.getDateOfBirth());
        assertTrue(customer.getEmail().matches(regexEmail));
        assertNotEquals("",customer.getFirstName());
        assertNotEquals("",customer.getLastName());
        assertNotEquals("", customer.getPhone());
    }

    @Test
    public void testDirectDebitMandateResource() throws Exception{
        DirectDebitMandate directDebitMandate = starling.listDirectDebitMandates().get(0);

        assertNotEquals("", directDebitMandate.getOriginatorName());
        assertEquals(null, directDebitMandate.getCancelled());
        assertNotNull(directDebitMandate.getCreated());
        assertTrue(directDebitMandate.getOriginatorUid().matches(regexUUID));
        assertNotEquals("", directDebitMandate.getReference());
        assertTrue(directDebitMandate.getUid().matches(regexUUID));
        assertNotNull(directDebitMandate.getSource());
        assertNotNull(directDebitMandate.getStatus());

    }

    @Test
    public void testDirectDebitTransactionResource() throws Exception{
        DirectDebitTransaction directDebitTransaction = starling.listDirectDebitTransactions().get(0);

        assertNotNull(directDebitTransaction.getCreated());
        assertNotNull(directDebitTransaction.getSource());
        assertTrue(directDebitTransaction.getId().matches(regexUUID));
        assertNotEquals("", directDebitTransaction.getCurrency());
        assertNotNull(directDebitTransaction.getDirection());
        assertTrue(directDebitTransaction.getMandateId().matches(regexUUID));
        assertNotEquals("", directDebitTransaction.getNarrative());
        assertNotEquals("", directDebitTransaction.getTitle());
        assertTrue(directDebitTransaction.getAmount().compareTo(BigDecimal.ZERO) == -1);
        assertNull(directDebitTransaction.getBalance());
        assertNotNull(directDebitTransaction.getType());
    }

    @Test
    public void testFasterPaymentsInTransactionResource() throws Exception{
        FasterPaymentsInTransaction fasterPaymentsInTransaction = starling.listFasterPaymentsInTransactions().get(0);

        assertNotNull(fasterPaymentsInTransaction.getCreated().toString());
        assertNotNull(fasterPaymentsInTransaction.getSource());
        assertTrue(fasterPaymentsInTransaction.getId().matches(regexUUID));
        assertNotEquals("", fasterPaymentsInTransaction.getCurrency());
        assertNotNull(fasterPaymentsInTransaction.getDirection());
        assertNotEquals("", fasterPaymentsInTransaction.getNarrative());
        assertTrue(fasterPaymentsInTransaction.getAmount().compareTo(BigDecimal.ZERO) == 1);
        assertNull(fasterPaymentsInTransaction.getSendingContactAccountId());
        assertNull(fasterPaymentsInTransaction.getSendingContactId());
    }

    @Test
    public void testFasterPaymentsOutTransactionResource() throws Exception{

        FasterPaymentsOutTransaction fasterPaymentsOutTransaction = starling.listFasterPaymentsOutTransactions()
                .stream()
                .filter(payment -> payment.getId().equals("ab3b1fff-bd0e-4f85-8570-8a16f334c083"))
                .findFirst()
                .orElse(null);

        assertNotNull(fasterPaymentsOutTransaction.getCreated());
        assertNotNull(fasterPaymentsOutTransaction.getSource());
        assertTrue(fasterPaymentsOutTransaction.getId().matches(regexUUID));
        assertNotEquals("",fasterPaymentsOutTransaction.getCurrency());
        assertNotNull(fasterPaymentsOutTransaction.getDirection());
        assertNotEquals("",fasterPaymentsOutTransaction.getNarrative());
        assertTrue(fasterPaymentsOutTransaction.getAmount().compareTo(BigDecimal.ZERO) == -1);
        assertTrue(fasterPaymentsOutTransaction.getReceivingContactAccountId().matches(regexUUID));
        assertTrue(fasterPaymentsOutTransaction.getReceivingContactId().matches(regexUUID));
    }

    @Test
    public void testMasterCardTransactionResource() throws Exception{
        MasterCardTransaction masterCardTransaction = starling.listMasterCardTransactions().get(0);

        assertNotNull(masterCardTransaction.getCreated());
        assertNotNull(masterCardTransaction.getSource());
        assertTrue(masterCardTransaction.getSourceAmount().compareTo(BigDecimal.ZERO) == 1);
        assertNotEquals("", masterCardTransaction.getSourceCurrency());
        assertTrue(masterCardTransaction.getId().matches(regexUUID));
        assertNotEquals("", masterCardTransaction.getCurrency());
        assertNotNull(masterCardTransaction.getDirection());
        assertNotEquals("", masterCardTransaction.getNarrative());
        assertTrue(masterCardTransaction.getAmount().compareTo(BigDecimal.ZERO) == -1);
        assertNotNull(masterCardTransaction.getMastercardTransactionMethod());
        assertTrue(masterCardTransaction.getMerchantId().matches(regexUUID));
        assertTrue(masterCardTransaction.getMerchantLocationId().matches(regexUUID));
        assertNotNull(masterCardTransaction.getStatus());
    }

    @Test
    public void testMerchantLocationResource() throws Exception{
        MerchantLocation merchantLocation = starling.getMerchantLocation("c052f76f-e919-427d-85fc-f46a75a3ff26", "b7b9f347-99ab-4a83-9317-ec9895f47755");

        assertEquals(null, merchantLocation.getAddress());
        assertEquals("ChIJx-5kJMbRw0cRVyNA7LqMoDM", merchantLocation.getGooglePlaceId());
        assertEquals("Mastercard Europe", merchantLocation.getLocationName());
        assertEquals("b7b9f347-99ab-4a83-9317-ec9895f47755", merchantLocation.getMerchantLocationUid());
        assertEquals("Mastercard", merchantLocation.getMerchantName());
        assertEquals("c052f76f-e919-427d-85fc-f46a75a3ff26", merchantLocation.getMerchantUid());
        assertEquals(null, merchantLocation.getPhoneNumber());
        assertEquals(new Integer(3431), merchantLocation.getMastercardMerchantCategoryCode());
    }

    @Test
    public void testMerchantResource() throws Exception{
        Merchant merchant = starling.getMerchant("c052f76f-e919-427d-85fc-f46a75a3ff26");

        assertEquals(null, merchant.getPhoneNumber());
        assertEquals("c052f76f-e919-427d-85fc-f46a75a3ff26", merchant.getMerchantUid());
        assertEquals("Mastercard", merchant.getName());
        assertEquals("@mastercardbizuk", merchant.getTwitterUsername());
        assertEquals("http://mastercard.co.uk", merchant.getWebsite());
    }

    @Test
    public void testPaymentResource() throws Exception {
        Payment payment = starling.listPayments().get(0);

        assertNotNull(payment.getStartDate());
        assertNotNull(payment.getNextDate());
        assertNull(payment.getLastDate());
        assertNotNull(payment.getEndDate());
        assertNull(payment.getCancelledAt());
        assertNull(payment.getRecurrenceRule());
        assertTrue(payment.getPaymentOrderId().matches(regexUUID));
        assertTrue(payment.getReceivingContactAccountId().matches(regexUUID));
        assertNull(payment.getMandateId());
        assertNotNull(payment.getPaymentType());
        assertNotEquals("", payment.getRecipientName());
        assertNotEquals("", payment.getReference());
        assertTrue(payment.getAmount().compareTo(BigDecimal.ZERO) == 1);
        assertNotEquals("", payment.getCurrency());
        assertNotNull(payment.getImmediate());
    }

    @Test
    public void testMakePayment() throws Exception {
        Payment newPayment;
        Contact contact = starling.createContact("starlingMan", "608371", "84829206");
        AccountBalance accountBalance           = starling.getAccountBalance();
        BigDecimal previousAccountBalanceAmount = accountBalance.getAmount();

        try {
            newPayment = starling.makeLocalPayment(contact.getId(), "TEST_PAYMENT", new BigDecimal(1.00));
            BigDecimal newAccountBalanceAmount = starling.getAccountBalance().getAmount();
            assertEquals(previousAccountBalanceAmount.subtract(new BigDecimal(1.0)), newAccountBalanceAmount);
            assertEquals("TEST_PAYMENT", newPayment.getReference());
        } catch (StarlingBankRequestException se) {
            System.out.println("REASON: " + se.getReason());
        }
    }

    @Test
    public void testMakeScheduledPayment() throws Exception {

        Contact contact = starling.createContact("starlingMan", "608371", "84829206");

        try {
            RecurrenceRule recurrenceRule = new RecurrenceRule(transactionDateFormat.parse("2080-02-02"), Frequency.MONTHLY, 1, 1, transactionDateFormat.parse("2020-02-02"), DayOfWeek.MONDAY, null, 3, 1);
            recurrenceRule.add(DayOfWeek.MONDAY);

            Payment newPayment = starling.makeScheduledPayment(contact.getId(), "TEST_RECURRING_PAYMENT", new BigDecimal(1.00), recurrenceRule);
            assertEquals(new BigDecimal(1.00).setScale(2, BigDecimal.ROUND_HALF_EVEN), newPayment.getAmount());
            assertEquals("TEST_RECURRING_PAYMENT", newPayment.getReference());
        }catch(StarlingBankRequestException se){
            System.out.println("REASON: " + se.getReason());
        }
    }

    @Test
    public void testTransactionResource() throws Exception{
        Transaction transaction = starling.listTransactions().get(0);

        assertNotEquals("", transaction.getNarrative());
        assertNotEquals("", transaction.getCurrency());
        assertTrue(transaction.getAmount().compareTo(BigDecimal.ZERO) == -1);
        assertTrue(transaction.getBalance().compareTo(BigDecimal.ZERO) == 1);
        assertNotNull(transaction.getCreated());
        assertNotNull(transaction.getDirection());
        assertTrue(transaction.getId().matches(regexUUID));
        assertNotNull(transaction.getSource());

        for (Transaction tx : starling.listTransactions(transactionDateFormat.parse("2017-09-01"), transactionDateFormat.parse("2017-09-01"))){
            assertTrue(tx.getAmount().compareTo(BigDecimal.ZERO) == 1);
            assertNotNull(tx.getCreated());
        }
    }

    @Test
    public void testCreateAndDeleteContact() throws StarlingBankRequestException{

        Contact newContact = starling.createContact("starlingMan", "608371", "84829206");
        assertEquals("starlingMan", newContact.getName());

        //Delete contact
        starling.deleteContact(newContact.getId());

        //Check contact no longer exists
        Contact deletedContact = starling.listContacts().stream().filter(contact -> contact.getId().equals("starlingMan")).findFirst().orElse(null);
        assertNull(deletedContact.getName());
    }
}
