package com.resonance.stepdefinitions;

import org.testng.Assert;

import com.resonance.pages.HomePage;
import com.resonance.pages.JoinMeetingPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageSteps{

	@When("user clicks on Join Meeting from homepage")
	public void clickOnJoinMeeting() {
		HomePage home = new HomePage();
		home.clickOnJoinMeeting();
	}
	
	@Then("verify that user redirects on Quick Join Meeting page")
	public void verify_that_user_redirects_on_quick_join_meeting_page() {
		JoinMeetingPage joinMeeting = new JoinMeetingPage();
		String actual = joinMeeting.getPageHeading();
		Assert.assertEquals(actual, "Quick Join a Meeting");
	}
	
	@Then("verify title of ijmeet homepage is {string}")
	public void verifyTitle(String expectedTitle) {
		HomePage home = new HomePage();
		String title = home.getTitle();
		Assert.assertEquals(title, expectedTitle);
	}
	
}
