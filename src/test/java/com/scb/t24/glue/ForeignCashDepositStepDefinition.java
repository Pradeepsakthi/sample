package com.scb.t24.glue;

import com.scb.t24.pages.ForeignCashDepositPage;
import com.scb.t24.runner.ReadTestData;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;

public class ForeignCashDepositStepDefinition extends ReadTestData
{
	
	@Then("^Navigate to Cash Deposit Foreign$")
	public void navigate_to_Cash_Deposit_Foreign() throws Throwable {
		new ForeignCashDepositPage().navigateToFCYDeposit();
	}
	@Then("^Enter new SB account number and other values in all the mandatory fields including denominations in Foreign Cash Deposit([0-9]*)$")
	public void enter_new_SB_account_number_and_other_values_in_all_the_mandatory_fields_including_denominations_in_Foreign_Cash_Deposit(int iteration) throws Throwable {
		new ForeignCashDepositPage().enterFCYFields(tdForeignCashDeposit.get(0).get(iteration),
                tdForeignCashDeposit.get(1).get(iteration),
                tdForeignCashDeposit.get(2).get(iteration),
                tdForeignCashDeposit.get(3).get(iteration));
	    
	}
	@Then("^Check the account balance$")
	public void check_the_account_balance() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
}
