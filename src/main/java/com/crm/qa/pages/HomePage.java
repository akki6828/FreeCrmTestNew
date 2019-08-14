package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	@FindBy(xpath="//td[contains(text(),'User: ankit kumar')]")
	WebElement userNameLabel;
	@FindBy(xpath="//a[text()='Contacts']")
	WebElement contactsLink;
	@FindBy(xpath="//a[text()='New Contact']")
	WebElement newContactLink;
	@FindBy(xpath="//a[text()='Deals']")
	WebElement dealsLink;
	@FindBy(xpath="//a[text()='Tasks']")
	WebElement tasksLink;
   
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyUserName() {
		return userNameLabel.isDisplayed();
	}
	public ContactsPage clickOnContactsLink() {
		contactsLink.click();
		return new ContactsPage();
	}
	public DealsPage clickOnDealsLink() {
		dealsLink.click();
		return new DealsPage();
	}
	public Taskspage clickOnTaskLink() {
		tasksLink.click();
		return new Taskspage();
	}
	public void clickOnNewContactLink() {
		Actions action= new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		newContactLink.click();
	}

}
