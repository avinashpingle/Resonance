package com.resonance.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;

import static com.resonance.utility.Keyword.*;

public class BaseFramework {

	public RemoteWebDriver driver; //static variable
	
	public ThreadLocal<WebDriver> thread = new ThreadLocal<WebDriver>();
	
	@Parameters("browser-name")
	@BeforeMethod
	public void setup(@Optional String browserName) {
		String browser = null;
		if(browserName.isEmpty() || browserName == null) {
			browser = System.getProperty("browserName");
			if(browser.isEmpty() || browser == null) {
				throw new Error("Please specify browser name");
			}
		}else {
			browser = browserName;
		}
		this.driver = openBrowser(browser);
		thread.set(this.driver);
		Config conf = new Config();
		launchUrl(conf.getAppUrl());
	}
	
	@AfterMethod
	public void tearDown() {
		thread.get().close();
		thread.remove();
	}
	
}
