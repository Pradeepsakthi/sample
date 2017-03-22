package com.scb.t24.glue;

import com.scb.t24.pages.CreateAddEditKYCPage;
import com.scb.t24.pages.CustomerCreationPage;
import com.scb.t24.runner.ReadTestData;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;

public class CreateAddEditKYCStepDefinition extends ReadTestData {
	@Then("^Navigate to Create KYC menu option$")
	public void navigate_to_Create_KYC_menu_option() throws Throwable {
		new CreateAddEditKYCPage().navigateToCreateKYC();
	}

	@Then("^Create KYC$")
	public void create_KYC() throws Throwable {
		new CreateAddEditKYCPage().getTransactionId();
		new CreateAddEditKYCPage().navigateToCustKYC();
		new CreateAddEditKYCPage().enterKYCDetails();
	}



	@Then("^Add KYC to the customer$")
	public void add_KYC_to_the_customer(int iteration) throws Throwable {
		new CreateAddEditKYCPage().navigateToCustKYC();
		new CreateAddEditKYCPage().enterKYCDetails();
}
	    
	

	@Then("^Edit KYC to a different customer number$")
	public void edit_KYC_to_a_different_customer_number() throws Throwable {
		new CreateAddEditKYCPage().enterKYCDetails();
	}


}
