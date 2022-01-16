package com.resonance.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JoinMeetingPage extends PageBase{

	@FindBy(css = "h2.m-txt")
	public WebElement quickJoinMeetingTxt;
	
	
	public JoinMeetingPage() {
		PageFactory.initElements(driver, this);
	}
	/**
	 * This method will return "Quick Join Meeting" if Join Meeting page loads successfully
	 */
	public String getPageHeading() {
		return quickJoinMeetingTxt.getText();
	}
}
