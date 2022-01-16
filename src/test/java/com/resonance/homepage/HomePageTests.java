package com.resonance.homepage;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.resonance.config.BaseFramework;
import com.resonance.pages.HomePage;
import com.resonance.pages.JoinMeetingPage;
import com.resonance.utility.Keyword;

public class HomePageTests extends BaseFramework{

	@Test
	public void verifyOnClickOfJoinMeetingUserLandsOnQuickJoinMeetingPage() {
		HomePage home = new HomePage();
		home.clickOnJoinMeeting();
		Keyword.waitFor(3000);
		JoinMeetingPage joinMeeting = new JoinMeetingPage();
		String actual = joinMeeting.getPageHeading();
		Assert.assertEquals(actual, "Quick Join a Meeting");
	}
}
