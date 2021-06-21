package com.qa.stepdef;

import org.junit.Assert;

import com.qa.pages.LoginPage;
import com.qa.pages.ProductsPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class LogInStepDef {

	@When("^I enter username \"([^\"]*)\"$")
	public void iEnterUsername(String userName) throws InterruptedException {
	    new LoginPage().enterUserName(userName);
	  
	}

	@When("^Enter \"([^\"]*)\"$")
	public void enter(String passWord) {
	   new LoginPage().enterPassword(passWord);
	  
	}

	@When("^Tap on the Login button$")
	public void tapOnTheLoginButton() {
	    new LoginPage().pressLoginBtn();
	    
	}

	@Then("^the \"([^\"]*)\" message should be displayed$")
	public void theMessageShouldBeDisplayed(String error) {
	    Assert.assertEquals(new LoginPage().getErrTxt(), error);
	    
	}

	@Then("^the product page with \"([^\"]*)\" should be displayed$")
	public void theProductPageWithShouldBeDisplayed(String string) {
	    Assert.assertEquals(new ProductsPage().getTitle(), string);
	   
	}
	
}
