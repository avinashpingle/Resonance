package com.resonance.config;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.resonance.utility.Keyword.*;

public class BaseFramework {

	public static RemoteWebDriver driver; //static variable
	@BeforeMethod
	public void setup() {
		this.driver = openBrowser("Chrome");
		Config conf = new Config();
		launchUrl(conf.getAppUrl());
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
