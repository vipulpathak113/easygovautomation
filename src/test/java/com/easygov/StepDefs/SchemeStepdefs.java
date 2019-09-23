package com.easygov.StepDefs;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.easygov.automation.TestSessionInitiator;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SchemeStepdefs {
	TestSessionInitiator test = CucumberHooks.test;

	WebDriver driver;
	
	@Given("^lang '(.*)' exists$")
	public void lang_English_exists(String lang) throws Throwable {
			Assert.assertTrue(lang+ "does not exists",test.scheme.verifyLangExists(lang));
		}
		
	@Then("^User is able to select English language successfully$")
	public void user_is_able_to_select_English_language_successfully() throws Throwable {
		test.scheme.selectLang();
	}
	
	@Given("^state '(.*)' exists$")
	public void state_Delhi_exists(String state) throws Throwable {
		Assert.assertTrue(state+ "does not exists",test.scheme.verifyStateExists(state));
	}

	@Then("^User is able to select Delhi state successfully$")
	public void user_is_able_to_select_Delhi_state_successfully() throws Throwable {
		test.scheme.selectState();
	}
	
	@Given("^district '(.*)' exists$")
	public void district_Central_Delhi_exists(String district) throws Throwable {
		Assert.assertTrue(district+ "does not exists",test.scheme.verifyDistrictExists(district));
	  
	}

	@Then("^User is able to select Central Delhi district successfully$")
	public void user_is_able_to_select_Central_Delhi_district_successfully() throws Throwable {
		test.scheme.selectDistrict();
	}
	
	@Given("^category '(.*)' exists$")
	public void category_Women_and_Child_Development_exists(String category) throws Throwable {
		test.scheme.browsescheme();
		Assert.assertTrue(category+ "does not exists",test.scheme.verifyCategoryExists(category));
	}

	@Then("^User is able to select category successfully$")
	public void user_is_able_to_select_category_successfully() throws Throwable {
		test.scheme.selectCategory();
	}
	
	@Given("^scheme '(.*)' exists$")
	public void scheme_Swadhar_exists(String scheme) throws Throwable {
		Assert.assertTrue(scheme+ "does not exists",test.scheme.verifySchemeExists(scheme));
	}

	@Then("^User clicks on check Eligibility button$")
	public void user_clicks_on_check_Eligibility_button() throws Throwable {
	}

	@Then("^User fills phone number '(.*)' and password '(.*)'$")
	public void user_fills_phone_number_and_password(String contact, String password) throws Throwable {
		test.scheme.enterCredentials(contact, password);
	  
	}

	@Then("^User is able to start the survey successfully$")
	public void user_is_able_to_start_the_survey_successfully() throws Throwable {
		Assert.assertTrue("Survey does not start",test.scheme.verifyUserStartSurvey());
	    
	}
	
	@Given("^user apply scheme for 'Myself'$")
	public void user_apply_scheme_for_Myself() throws Throwable {
		test.scheme.applyForMyself();
	}

	@When("^user answers all the survey questions:$")
	public void user_answers_all_the_survey_questions(DataTable table) throws Throwable {
		List<List<String>> data = table.raw();
		String gender = data.get(1).get(1).toString();
		test.scheme.selectGender(gender);
		String dob = data.get(2).get(1).toString();
		test.scheme.selectDOB(dob);
		String domicile = data.get(3).get(1).toString();
		test.scheme.selectDomicile(domicile);
		String abled = data.get(4).get(1).toString();
		test.scheme.selectAbled(abled);
	    
	}

	@Then("^user is able to check eligibilty for user$")
	public void user_is_able_to_check_eligibilty_for_user() throws Throwable {
		Assert.assertTrue("You are not eligible",test.scheme.isAble());
		
	}

	@Then("^user is able to apply for a scheme successfully$")
	public void user_is_able_to_apply_for_a_scheme_successfully() throws Throwable {
		test.scheme.checkElgb();
	    test.scheme.selectReason();
	    Assert.assertTrue("You are not eligible",test.scheme.destitute());
	    Assert.assertTrue("You did not reach to Application page",test.scheme.apply());
	}
	
	@When("^User clicks on Logout button$")
	public void user_clicks_on_Logout_button() throws Throwable {
	     test.scheme.clickLogOut();
	}

	@Then("^User is able to signout successfully$")
	public void user_is_able_to_signout_successfully() throws Throwable {
		Assert.assertTrue("You are not logged out",test.scheme.signOut());
	}


}
