package com.crm.qa.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	public HomePageTest() {
		super();
	}
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil= new TestUtil();
		contactsPage= new ContactsPage();
		loginPage=new LoginPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
		
		
	}
	@Test
	public void verifyHomePageTitleTest() {
		String title=homePage.verifyHomePageTitle();
		Assert.assertEquals(title, "CRMPRO","homePage title not matched");
	}
	@Test
	public void verifyUserNameTest() {
		testUtil.switchToFrame();
		Assert.assertTrue(homePage.verifyUserName());
		}
	@Test
	public void verifyContactsLinkTest() {
		testUtil.switchToFrame();
		contactsPage=homePage.clickOnContactsLink();
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	
	
	
	
	
	
	

}
