package com.scb.t24.glue;

import com.scb.t24.pages.DeleteUnauthorisePage;
import com.scb.t24.runner.ReadTestData;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;

public class DeleteUnauthoriseStepDefinition extends ReadTestData 

{
	@Then("^Navigate to Unauthorized Customer$")
	public void navigate_to_Unauthorized_Customer() throws Throwable {
	   new DeleteUnauthorisePage().navigateToDeleteUnauthCust();
	   new DeleteUnauthorisePage().searchID();
	}

	@Then("^Click on Delete button$")
	public void click_on_Delete_button() throws Throwable {
		new DeleteUnauthorisePage().deleteCustomer();
	}

}
