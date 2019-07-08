package org.jarling.v2;

import org.assertj.core.api.Assertions;
import org.jarling.models.transactions.FeedItemAttachmentData;
import org.jarling.v2.accountholder.AccountHolderAssert;
import org.jarling.v2.accounts.AccountAssert;
import org.jarling.v2.accounts.AccountIdentifiersAssert;
import org.jarling.v2.accounts.BalanceAssert;
import org.jarling.v2.accounts.ConfirmationOfFundsAssert;
import org.jarling.v2.addresses.AddressAssert;
import org.jarling.v2.apiuseridentity.IdentityAssert;
import org.jarling.v2.businesses.BusinessAssert;
import org.jarling.v2.common.CurrencyAndAmountAssert;
import org.jarling.v2.common.StringAssert;
import org.jarling.v2.individuals.IndividualAssert;
import org.jarling.v2.jointaccounts.JointAccountAssert;
import org.jarling.v2.kyc.KycResultAssert;
import org.jarling.v2.models.accountholder.AccountHolder;
import org.jarling.v2.models.accounts.Account;
import org.jarling.v2.models.accounts.AccountIdentifiers;
import org.jarling.v2.models.accounts.Balance;
import org.jarling.v2.models.accounts.ConfirmationOfFunds;
import org.jarling.v2.models.addresses.Address;
import org.jarling.v2.models.apiuseridentity.Identity;
import org.jarling.v2.models.businesses.Business;
import org.jarling.v2.models.common.CurrencyAndAmount;
import org.jarling.v2.models.individuals.Individual;
import org.jarling.v2.models.jointaccounts.JointAccount;
import org.jarling.v2.models.kyc.KycResult;
import org.jarling.v2.models.payees.Payee;
import org.jarling.v2.models.payees.PayeeAccount;
import org.jarling.v2.models.payments.Payment;
import org.jarling.v2.models.payments.PaymentOrder;
import org.jarling.v2.models.payments.StandingOrder;
import org.jarling.v2.models.transactionfeed.FeedItem;
import org.jarling.v2.models.transactionfeed.FeedItemAttachment;
import org.jarling.v2.payees.PayeeAccountAssert;
import org.jarling.v2.payees.PayeeAssert;
import org.jarling.v2.payments.PaymentAssert;
import org.jarling.v2.payments.PaymentOrderAssert;
import org.jarling.v2.payments.StandingOrderAssert;
import org.jarling.v2.transactionfeed.FeedItemAssert;
import org.jarling.v2.transactionfeed.FeedItemAttachmentAssert;
import org.jarling.v2.transactionfeed.FeedItemAttachmentDataAssert;

public class JarlingAssertions extends Assertions {
    public static AccountHolderAssert assertThat(AccountHolder actual) {
        return new AccountHolderAssert(actual);
    }

    public static CurrencyAndAmountAssert assertThat(CurrencyAndAmount actual) {
        return new CurrencyAndAmountAssert(actual);
    }

    public static AccountAssert assertThat(Account actual) {
        return new AccountAssert(actual);
    }

    public static StringAssert assertThat(String actual) {
        return new StringAssert(actual);
    }

    public static AccountIdentifiersAssert assertThat(AccountIdentifiers actual) {
        return new AccountIdentifiersAssert(actual);
    }

    public static BalanceAssert assertThat(Balance actual) {
        return new BalanceAssert(actual);
    }

    public static AddressAssert assertThat(Address actual) {
        return new AddressAssert(actual);
    }

    public static IndividualAssert assertThat(Individual actual) {
        return new IndividualAssert(actual);
    }

    public static IdentityAssert assertThat(Identity actual) {
        return new IdentityAssert(actual);
    }

    public static BusinessAssert assertThat(Business actual) {
        return new BusinessAssert(actual);
    }

    public static JointAccountAssert assertThat(JointAccount actual) {
        return new JointAccountAssert(actual);
    }

    public static KycResultAssert assertThat(KycResult actual) {
        return new KycResultAssert(actual);
    }

    public static PayeeAssert assertThat(Payee actual) {
        return new PayeeAssert(actual);
    }

    public static PayeeAccountAssert assertThat(PayeeAccount actual) {
        return new PayeeAccountAssert(actual);
    }

    public static PaymentOrderAssert assertThat(PaymentOrder actual) {
        return new PaymentOrderAssert(actual);
    }

    public static StandingOrderAssert assertThat(StandingOrder actual) {
        return new StandingOrderAssert(actual);
    }
    public static PaymentAssert assertThat(Payment actual) {
        return new PaymentAssert(actual);
    }

    public static FeedItemAssert assertThat(FeedItem actual) {
        return new FeedItemAssert(actual);
    }

    public static FeedItemAttachmentAssert assertThat(FeedItemAttachment actual) {
        return new FeedItemAttachmentAssert(actual);
    }

    public static FeedItemAttachmentDataAssert assertThat(FeedItemAttachmentData actual) {
        return new FeedItemAttachmentDataAssert(actual);
    }

    public static ConfirmationOfFundsAssert assertThat(ConfirmationOfFunds actual) {
        return new ConfirmationOfFundsAssert(actual);
    }
}
