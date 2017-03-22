package com.scb.t24.glue;

import com.scb.t24.pages.AuthoriseCashTransactionsPage;
import com.scb.t24.pages.CashDepositPage;
import com.scb.t24.pages.HomePage;
import com.scb.t24.pages.HomePage_Threasurey;
import com.scb.t24.pages.LoginPage;
import com.scb.t24.runner.ReadTestData;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class CashDepositStepDefinitionFile extends ReadTestData {

	
	@Given("^Login to the application using valid credentials ([0-9]*)$")
	public void login_to_the_application_using_valid_credentials(int iteration) throws Throwable {
		if(tdLogin.get(2).get(iteration).equalsIgnoreCase("IE")){
			launchIeBrowser();
			loadURL("http://10.237.37.99/t24trngR14");
			acceptSSLError();
		}else{
			launchChromeBrowser();
			loadURL("http://10.237.37.99/t24trngR14");
		}
		new LoginPage().loginToApplication(tdLogin.get(0).get(iteration), tdLogin.get(1).get(iteration));

	}

		@Then("^Navigate to Cash Deposit Local$")
		public void navigate_to_Cash_Deposit_Local() throws Throwable {
			new CashDepositPage().navigateToDeposit();
		}

		@Then("^Enter new SB account number and other values in all the mandatory fields including denominations ([0-9]*)$")
		public void enter_new_SB_account_number_and_other_values_in_all_the_mandatory_fields_including_denominations(int iteration) throws Throwable {
			new CashDepositPage().enterMandatoryFields1(tdLocalCashDeposit.get(0).get(iteration),
				                                        tdLocalCashDeposit.get(1).get(iteration),
					                                    tdLocalCashDeposit.get(2).get(iteration));
					
		}

		@Then("^commit the deal$")
		public void commit_the_deal() throws Throwable {
			new CashDepositPage().commitLcyDeal();
		}

		@Then("^capture the FT reference ID$")
		public void capture_the_FT_reference_ID() throws Throwable {
			new CashDepositPage().getTransactionId();
			driver.close();
		}

		@Given("^User logs out$")
		public void user_logs_out() throws Throwable {
			new HomePage().signOff();
			
		}
		

		@Given("^User logs in with authoriser ID ([0-9]*)$")
		public void user_logs_in_with_authoriser_ID(int iteration) throws Throwable {
		new LoginPage().loginToApplicationWithSecondUser(tdLogin.get(0).get(iteration), tdLogin.get(1).get(iteration));	
		}	

		


		

		@Then("^Authorize the deal$")
		public void authorize_the_deal() throws Throwable {
		    new AuthoriseCashTransactionsPage().navigateToAuthCashTransact().searchTransID().getTransactionId();
		    
		    
		}

		@Then("^Check the account balances$")
		public void check_the_account_balances() throws Throwable {
			new HomePage().signOff();
		}



	}


