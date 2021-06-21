package com.qa.stepdef;

import org.junit.Assert;

import com.qa.pages.LoginPage;
import com.qa.pages.ProductDetailsPage;
import com.qa.pages.ProductsPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductStepDef {

	@Given("^I'm already logged in$")
	public void iMAlreadyLoggedIn() throws InterruptedException {
	new LoginPage().login("standard_user", "secret_sauce");

	}

	@Then("^the product is listed with the \"([^\"]*)\" and \"([^\"]*)\"$")
	public void theProductIsListedWithTheAnd(String title, String price) throws Exception {
	    Boolean ltitle= new ProductsPage().getProductTitle(title).contentEquals(title);
	    System.out.println(new ProductsPage().getProductPrice(title, price));
	    Boolean lprice= new ProductsPage().getProductPrice(title, price).contentEquals(price);
	    System.out.println(new ProductsPage().getProductPrice(title, price));
	   Assert.assertTrue("Title check = "+ltitle+" price check = "+lprice, ltitle&lprice);
	}

	@When("^I tap on product \"([^\"]*)\"$")
	public void iTapOnProduct(String title) throws Exception {
	    new ProductsPage().pressProductTitle(title);
	    
	}

	@Then("^I should be able to see \"([^\"]*)\" price\"([^\"]*)\" and \"([^\"]*)\"")
	public void iShouldBeAbleToSeePriceand(String title, String price, String description) throws Exception {
	    // Write code here that turns the phrase above into concrete actions

		Boolean ltitle= new ProductDetailsPage().getTitle().contentEquals(title);
	    Boolean lprice= new ProductDetailsPage().getPrice().contentEquals(price);
	    Boolean ldesc= new ProductDetailsPage().getPrice().contentEquals(description);
		
	}
	
}
