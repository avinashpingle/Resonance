package com.resonance.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.resonance.config.BaseFramework;

public class JoinMeetingPage extends BaseFramework{

	@FindBy(css = "h2.m-txt")
	public WebElement quickJoinMeetingTxt;
	
	public JoinMeetingPage() {
		PageFactory.initElements(thread.get(), this);
	}
	
	/**
	 * This method will return "Quick Join Meeting" if Join Meeting page loads successfully
	 */
	public String getPageHeading() {
		return quickJoinMeetingTxt.getText();
	}
}
