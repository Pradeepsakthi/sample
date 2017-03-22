package com.scb.t24.glue;

import com.scb.t24.pages.DirectDebitPage;
import com.scb.t24.pages.HomePage;
import com.scb.t24.runner.ReadTestData;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;

public class DirectDebitStepDefinition extends ReadTestData {

	@Then("^Navigate to Direct Debit submenu$")
	public void navigate_to_Direct_Debit_submenu() throws Throwable {
	    new DirectDebitPage().navigateToDirectDebit();
	    
	}

	@Then("^enter the mandatory DirectDebit fields$")
	public void enter_the_mandatory_DirectDebit_fields() throws Throwable {
	    new DirectDebitPage().enterDDMandatoryFields();
	    
	}

	@Then("^commit deal and authorise deal$")
	public void commit_deal_and_authorise_deal() throws Throwable {
	    new DirectDebitPage().commitDirectDebitDeal();
	    new DirectDebitPage().getTransactionId();
	    new HomePage().signOff();
	   
	}


}
