package com.scb.t24.glue;


import com.scb.t24.pages.CustomerCreationPage;
import com.scb.t24.pages.HomePage;
import com.scb.t24.runner.ReadTestData;

import cucumber.api.java.en.Then;

public class CustomerCreationStepDefenitionFile extends ReadTestData {

	@Then("^navigate to Individual Customer$")
	public void navigate_to_Individual_Customer() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		new HomePage().navigateToCustomer();
	}
	
	@Then("^Enter valid values in all the mandatory fields ([0-9]*)$")
	public void enter_valid_values_in_all_the_mandatory_field(int iteration) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		new CustomerCreationPage().enterMandatoryFields(tdCustomerCreation.get(0).get(iteration),
														tdCustomerCreation.get(1).get(iteration),
														tdCustomerCreation.get(2).get(iteration),
														tdCustomerCreation.get(3).get(iteration));
	}

	@Then("^Commit the deal$")
	public void commit_the_deal() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		new CustomerCreationPage().commitCustomer();
	}

	@Then("^Capture the Customer Number generated$")
	public void capture_the_Customer_Number_generated() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		new CustomerCreationPage().captureCustomerIDGenerated();
		sleep(5000);
	}

	@Then("^Log out$")
	public void log_out() throws Throwable {
	   new HomePage().signOff();
	   driver.close();
	}


}