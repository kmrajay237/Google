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

public class TestLinkedin extends BaseTest{
	@Test
	public void linkedin() {
		try {
			GoogleSearchPagePO gsp=new GoogleSearchPagePO(driver);
			gsp.searchTextBox().sendKeys("linkedin");
			gsp.searchTextBox().sendKeys(Keys.ENTER);
			
			SearchResultPagePO srp=new SearchResultPagePO(driver);
//			Thread.sleep(4000);
			srp.linkedinLink().click();
			
			String expTitle="LinkedIn: Log In or Sign Up";
			String actTitle = driver.getTitle();
			
			AssertJUnit.assertEquals(actTitle, expTitle);
			Reporter.log("Linkedin Title is matching", true);
		} catch (Exception e) {
			Reporter.log("Linkedin Title is not matching", true);
			AssertJUnit.fail();
		}
	}
}
