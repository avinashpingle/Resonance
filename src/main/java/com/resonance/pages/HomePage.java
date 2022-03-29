package com.resonance.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.resonance.config.BaseFramework;

public class HomePage extends BaseFramework{
	private static final Logger LOG = Logger.getLogger(HomePage.class);
	
	@FindBy(css = "a[href^=\"https://ijmeet.com/app\"]")
	public WebElement joinMeeting;
	
	@FindBy(css = "span.mvlogo-size-app1 img[alt=\"ijmeetimage\"]")
	public WebElement logo;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnJoinMeeting() {
		joinMeeting.click();
		LOG.info("Clicked on Join Meeting link");
	}
	
	public void clickOnLogo() {
		logo.click();
		LOG.info("Clicked on Logo");
	}

	public String getTitle() {
		return driver.getTitle();
	}
}
