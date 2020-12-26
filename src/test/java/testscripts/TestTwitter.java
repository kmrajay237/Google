package testscripts;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import library.BaseTest;
import pageobject.GoogleSearchPagePO;
import pageobject.SearchResultPagePO;

public class TestTwitter extends BaseTest{

	@Test
	public void twitter() {
		try {
			GoogleSearchPagePO gsp=new GoogleSearchPagePO(driver);
			gsp.searchTextBox().sendKeys("twitter");
			gsp.searchTextBox().sendKeys(Keys.ENTER);
			
			SearchResultPagePO srp=new SearchResultPagePO(driver);
			srp.twitterLink().click();
			
			String expTitle="Twitter. It’s what’s happening / Twitter";
			String actTitle = driver.getTitle();
			
			AssertJUnit.assertEquals(actTitle, expTitle);
			Reporter.log("Twitter Title is matching", true);
		} catch (Exception e) {
			Reporter.log("Twitter Title is not matching", true);
			AssertJUnit.fail();
		}
	}
}
