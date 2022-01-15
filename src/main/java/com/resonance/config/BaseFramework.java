package com.resonance.config;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.resonance.utility.Keyword.*;

public class BaseFramework {

	@BeforeMethod
	public void setup() {
		openBrowser("Chrome");
		launchUrl("https://www.flipkart.com");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
