package org.jarling.v2.models.transactionfeed;

import lombok.Getter;

@Getter
public enum SpendingCategory {
    BILLS_AND_SERVICES("BILLS_AND_SERVICES"),
    CHARITY("CHARITY"),
    EATING_OUT("EATING_OUT"),
    ENTERTAINMENT("ENTERTAINMENT"),
    EXPENSES("EXPENSES"),
    FAMILY("FAMILY"),
    GENERAL("GENERAL"),
    GIFTS("GIFTS"),
    GROCERIES("GROCERIES"),
    HOME("HOME"),
    INCOME("INCOME"),
    SAVING("SAVING"),
    SHOPPING("SHOPPING"),
    HOLIDAYS("HOLIDAYS"),
    PAYMENTS("PAYMENTS"),
    PETS("PETS"),
    TRANSPORT("TRANSPORT"),
    LIFESTYLE("LIFESTYLE"),
    NONE("NONE");

    private final String value;

    SpendingCategory(String value) {
        this.value = value;
    }
}
