package com.scb.t24.glue;

/*import com.scb.t24.pages.CurrentAccountPage;
import com.scb.t24.pages.HomePage;
import com.scb.t24.pages.LoginPage;*/
import com.scb.t24.pages.AccountPage;
import com.scb.t24.pages.ClickAccountNewDeal;
import com.scb.t24.pages.HomePage;
import com.scb.t24.pages.LoginPage;
import com.scb.t24.runner.ReadTestData;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class AccountStepDefenitionFile extends ReadTestData {

	

	@Then("^click on open current account menu$")
	public void click_on_open_current_account_menu() throws Throwable {
		new HomePage().openCurrentAccontLink();
	}

	@Then("^click on new deal icon in the account menu$")
	public void click_on_new_deal_icon_in_the_current_account_menu() throws Throwable {
		new AccountPage().openNewDeal();
	}

	@Then("^fill all the mandatory details for the newly created customer ([0-9]*)$")
	public void fill_all_the_mandatory_details_for_the_newly_created_customer(int iteration) throws Throwable {
		new ClickAccountNewDeal().enterCurrentAccountDetails(tdCreateCustomer.get(0).get(iteration),
				tdCreateCustomer.get(1).get(iteration), tdCreateCustomer.get(2).get(iteration),
				tdCreateCustomer.get(3).get(iteration));
	}

	@Then("^validate and commit the deal$")
	public void validate_and_commit_the_deal() throws Throwable {
		new ClickAccountNewDeal().clickCommit();
	}

	@Then("^click on open savings account menu$")
	public void click_on_open_savings_account_menu() throws Throwable {
		new HomePage().openSavingsAccontLink();

	}

	@Then("^for the same customer fill all the mandatory details ([0-9]*)$")
	public void for_the_same_customer_fill_all_the_mandatory_details(int iteration) throws Throwable {
		new ClickAccountNewDeal().enterSavingsAccountDetails(tdSavingsAccount.get(0).get(iteration),
				tdSavingsAccount.get(1).get(iteration), tdSavingsAccount.get(2).get(iteration),
				tdSavingsAccount.get(3).get(iteration));
	}

	@Then("^for the same customer fill all the mandatory details as FCY ([0-9]*)$")
	public void for_the_same_customer_fill_all_the_mandatory_details_as_FCY(int iteration) throws Throwable {
		new ClickAccountNewDeal().enterFCYAccountDetails(tdFCY.get(0).get(iteration), tdFCY.get(1).get(iteration),
				tdFCY.get(2).get(iteration), tdFCY.get(3).get(iteration));

	}

	@Then("^authorise the deal ([0-9]*)$")
	public void authorise_the_deal(int iteration) throws Throwable {
		
			new HomePage().signOff();
			driver.quit();
			/*driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			if (driver.findElement(By.xpath("//a[text()='Continue to this website (not recommended).']"))
					.isDisplayed()) {
				acceptSSLError();
			}
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		} catch (Exception e) {
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}*/
		/*
		 * KillIEDriver(); launchIeBrowser(); //launchChromeBrowser();
		 * loadURL("https://144.36.210.62/t24trngR14/servlet/BrowserServlet");
		 * acceptSSLError();
		 */
		launchIeBrowser();
		loadURL("http://144.36.210.62/t24trngR14/");	
		acceptSSLError();
		new LoginPage().loginToApplicationWithSecondUser(tdLogin.get(0).get(iteration), tdLogin.get(1).get(iteration));
		new HomePage().authorizeDeleteAccount().
		doAccountSearch().filterAccount();

	}

}
