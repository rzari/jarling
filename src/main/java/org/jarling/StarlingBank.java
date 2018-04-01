package org.jarling;

import org.jarling.api.*;

/**
 * @author Nav Roudsari (nav@rzari.co.uk)
 */
public interface StarlingBank extends AccountResource,
        AddressResource,
        CardResource,
        ContactResource,
        CustomerResource,
        DirectDebitMandateResource,
        MerchantResource,
        PaymentResource,
        SavingsGoalResource,
        TransactionDirectDebitResource,
        TransactionFasterPaymentInResource,
        TransactionFasterPaymentOutResource,
        TransactionMasterCardResource,
        TransactionResource,
        WhoAmIResource {


    AccountResource account();

    AddressResource address();

    CardResource card();

    ContactResource contact();

    CustomerResource customer();

    DirectDebitMandateResource directDebitMandate();

    MerchantResource merchant();

    PaymentResource payment();

    SavingsGoalResource savingsGoal();

    TransactionResource transaction();

    TransactionMasterCardResource transactionMastercard();

    TransactionFasterPaymentOutResource transactionFpsOut();

    TransactionFasterPaymentInResource transactionFpsIn();

    TransactionDirectDebitResource transactionDirectDebit();

    WhoAmIResource whoAmI();
}
