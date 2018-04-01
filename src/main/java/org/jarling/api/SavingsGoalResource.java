package org.jarling.api;

import org.jarling.exceptions.StarlingBankRequestException;
import org.jarling.models.common.*;
import org.jarling.models.budgeting.SavingsGoal;

import java.io.File;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * Interface representing resource to manage customer saving goals.
 *
 * @author Nav Roudsari (nav@rzari.co.uk)
 *
 */
public interface SavingsGoalResource {

    /**
     * <p>Get savings goal</p>
     * Returns the customer's savings goal information.
     * @return SavingsGoal
     * @param savingsGoalUid Unique identifier of the savings goal
     * @throws StarlingBankRequestException when there was an issue accessing the resource
     * @see <a href="https://developer.starlingbank.com/docs">Savings Goal API - Starling Bank Developer Docs</a>
     */
    SavingsGoal getSavingsGoal(String savingsGoalUid) throws StarlingBankRequestException;

    /**
     * <p>List payment orders</p>
     * Returns all the savings goals on the customer account.
     * @return a list of all savings goals on the customer account
     * @throws StarlingBankRequestException when there was an issue accessing the resource
     * @see <a href="https://developer.starlingbank.com/docs">Savings Goal API - Starling Bank Developer Docs</a>
     */
    List<SavingsGoal> listSavingsGoals() throws StarlingBankRequestException;

    /**
     * <p>Delete savings goal</p>
     * Deletes the savings goal with the specified identifier.
     * @param savingsGoalUid Unique identifier of the savings goal to be deleted
     * @throws StarlingBankRequestException when there was an issue accessing the resource
     * @see <a href="https://developer.starlingbank.com/docs">Savings Goal API - Starling Bank Developer Docs</a>
     */
    void deleteSavingsGoal(String savingsGoalUid) throws StarlingBankRequestException;

    /**
     * <p>Get photo of savings goal</p>
     * Returns the customer's savings goal photo.
     * @return Photo
     * @param savingsGoalUid Unique identifier of the savings goal
     * @throws StarlingBankRequestException when there was an issue accessing the resource
     * @see <a href="https://developer.starlingbank.com/docs">Savings Goal API - Starling Bank Developer Docs</a>
     */
    Photo getSavingsGoalPhoto(String savingsGoalUid) throws StarlingBankRequestException;

    /**
     * <p>Create a new savings goal</p>
     * Creates a new savings goal for a customer.
     * @param name Name of the savings goal
     * @param currency The currency of the savings goal
     * @param targetAmount The savings goal target the customer would like to reach
     * @return id
     * @throws StarlingBankRequestException when there was an issue accessing the resource
     * @see <a href="https://developer.starlingbank.com/docs">Savings Goal API - Starling Bank Developer Docs</a>
     */
    String createSavingsGoal(String name, String currency, BigDecimal targetAmount) throws StarlingBankRequestException;

    /**
     * <p>Create a new savings goal</p>
     * Creates a new savings goal for a customer.
     * @param name Name of the savings goal
     * @param currency The currency of the savings goal
     * @param targetAmount The savings goal target the customer would like to reach
     * @param photo A text (base 64) encoded picture to associate with the savings goal
     * @return id
     * @throws StarlingBankRequestException when there was an issue accessing the resource
     * @see <a href="https://developer.starlingbank.com/docs">Savings Goal API - Starling Bank Developer Docs</a>
     */
    String createSavingsGoal(String name, String currency, BigDecimal targetAmount, String photo) throws StarlingBankRequestException;

    /**
     * <p>Get recurring transfer information of a savings goal</p>
     * Returns the customer's recurring transfer information of a savings goal.
     * @return RecurringTransfer
     * @param savingsGoalUid Unique identifier of the savings goal
     * @throws StarlingBankRequestException when there was an issue accessing the resource
     * @see <a href="https://developer.starlingbank.com/docs">Savings Goal API - Starling Bank Developer Docs</a>
     */
    RecurringTransfer getSavingsGoalRecurringTransfer(String savingsGoalUid) throws StarlingBankRequestException;

    /**
     * <p>Create a new savings goal</p>
     * Applies a new recurrence rule to the customers savings goal.
     * @param savingsGoalUid Unique identifier of the savings goal
     * @param recurrenceRule Recurrence rule to schedule recurring transfers
     * @param currencyAndAmount The savings goal target the customer would like to reach
     * @return transferId String
     * @throws StarlingBankRequestException when there was an issue accessing the resource
     * @see <a href="https://developer.starlingbank.com/docs">Savings Goal API - Starling Bank Developer Docs</a>
     */
    String createSavingsGoalRecurringTransfer(String savingsGoalUid, RecurrenceRule recurrenceRule, CurrencyAndAmount currencyAndAmount) throws StarlingBankRequestException;

    /**
     * <p>Deletes a recurrence rule</p>
     * Deletes a recurrence rule from the specified savings goal.
     * @param savingsGoalUid Unique identifier of the savings goal
     * @throws StarlingBankRequestException when there was an issue accessing the resource
     * @see <a href="https://developer.starlingbank.com/docs">Savings Goal API - Starling Bank Developer Docs</a>
     */
    void deleteSavingsGoalRecurringTransfer(String savingsGoalUid) throws StarlingBankRequestException;


    /**
     * <p>Withdraw money from savings goal</p>
     * Specifies the amount to withdraw from the customers savings goal to their main account.
     * @param savingsGoalUid Unique identifier of the savings goal
     * @param amount Amount to withdraw
     * @return transferId String
     * @throws StarlingBankRequestException when there was an issue accessing the resource
     * @see <a href="https://developer.starlingbank.com/docs">Savings Goal API - Starling Bank Developer Docs</a>
     */
    String withdrawMoneyFromSavingsGoal(String savingsGoalUid, Amount amount) throws StarlingBankRequestException;

    /**
     * <p>Adds money to a savings goal</p>
     * Specifies the amount to transfer from the customers main account to their savings goal.
     * @param savingsGoalUid Unique identifier of the savings goal
     * @param amount Amount to add
     * @return transferId String
     * @throws StarlingBankRequestException when there was an issue accessing the resource
     * @see <a href="https://developer.starlingbank.com/docs">Savings Goal API - Starling Bank Developer Docs</a>
     */
    String addMoneyToSavingsGoal(String savingsGoalUid, Amount amount) throws StarlingBankRequestException;

}
