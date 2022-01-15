package com.resonance.traveltests;

import org.testng.annotations.Test;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.resonance.config.BaseFramework;
import com.resonance.constants.Locator;
import com.resonance.constants.LocatorType;

import static com.resonance.utility.Keyword.*;
/**
 * 
 * @author Mayur
 *
 */
public class Travel extends BaseFramework{
	private static final Logger LOG = Logger.getLogger(Travel.class);
	
	@Test
	public void verifyErrorOnSelectingSameCitiesAsSourceAndDestination(){
		waitFor(3000);
		click(Locator.homeScreen_closePopupBtn);
		click(Locator.homeScreen_travelLink);
		waitFor(5000);
		click(Locator.homeScreen_fromCity);
		waitFor(2000);
		LOG.info("Clicked on From city dropdown");
		click(Locator.homeScreen_fromCity_BOM);
		LOG.info("Selected Bombay as from city");
	}
	

	@Test
	public void verifySearchResultsForShoes() {
		enterText(Locator.homeScreen_searchTxtBx,"Shoes");
	}
	
	@Test
	public void m1() {
		System.out.println("My Test case");
	}
}
