package com.kodilla.cucumber.wallet;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.*;

public class WalletSteps {
    private Wallet wallet;
    private CashSlot cashSlot;
    private String errorMessage;
    private long checkedBalance;

    private void initIfNeeded() {
        if (wallet == null) {
            wallet = new Wallet();
            cashSlot = new CashSlot();
        }
    }

    @Given("I have deposited ${long} in my wallet")
    public void i_have_deposited_in_my_wallet(long amount) {
        initIfNeeded();
        wallet.deposit(amount);
    }

    @Given("there is ${long} in my wallet")
    public void there_is_in_my_wallet(long amount) {
        initIfNeeded();
        if (amount > 0) {
            wallet.deposit(amount);
        }
    }

    @When("I request ${long}")
    public void i_request(long amount) {
        Cashier cashier = new Cashier(cashSlot);
        cashier.withdraw(wallet, amount);
    }

    @When("I try to withdraw ${long}")
    public void i_try_to_withdraw(long amount) {
        Cashier cashier = new Cashier(cashSlot);
        try {
            cashier.withdraw(wallet, amount);
        } catch (InsufficientFundsException e) {
            this.errorMessage = e.getMessage();
        }
    }

    @When("I check the balance of my wallet")
    public void i_check_the_balance_of_my_wallet() {
        this.checkedBalance = wallet.getBalance();
    }

    @Then("${long} should be dispensed")
    public void should_be_dispensed(long amount) {
        assertEquals(amount, cashSlot.getContents());
    }

    @Then("the balance of my wallet should be ${long}")
    public void the_balance_of_my_wallet_should_be(long expected) {
        assertEquals(expected, wallet.getBalance(),
                "Incorrect wallet balance");
    }

    @Then("nothing should be dispensed")
    public void nothing_should_be_dispensed() {
        assertEquals(0, cashSlot.getContents());
    }

    @Then("I should be told that I don't have enough money in my wallet")
    public void i_should_be_told_insufficient_funds() {
        assertNotNull(errorMessage,
                "Expected an error message but got none");
        assertTrue(errorMessage.contains("Insufficient funds"),
                "Expected 'Insufficient funds' message");
    }

    @Then("I should see that the balance is ${long}")
    public void i_should_see_that_the_balance_is(long expected) {
        assertEquals(expected, checkedBalance);
    }
}
