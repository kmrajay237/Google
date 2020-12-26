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

public class TestInstagram extends BaseTest{
	@Test
	public void instagram() {
		try {
			GoogleSearchPagePO gsp=new GoogleSearchPagePO(driver);
			gsp.searchTextBox().sendKeys("Instagram");
			gsp.searchTextBox().sendKeys(Keys.ENTER);
			
			SearchResultPagePO srp=new SearchResultPagePO(driver);
			srp.instagramLink().click();
			
			String expTitle="Instagram";
			String actTitle = driver.getTitle();
			
			AssertJUnit.assertEquals(actTitle, expTitle);
			Reporter.log("Instagram Title is matching", true);
		} catch (Exception e) {
			Reporter.log("Instagram Title is not matching", true);
			AssertJUnit.fail();
		}
	}
}
