package com.crm.qa.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	@FindBy(xpath="   //td[contains(text(),'Contacts')]")
	WebElement contactsLabel;
	
	@FindBy(name="title")
	WebElement title;
	
	@FindBy(id="first_name")
	WebElement firstName;
	
	@FindBy(id="surname")
	WebElement surName;
	
	@FindBy(name="client_lookup")
	WebElement companyName;
	
	@FindBy(xpath="//input[@value='Save' and @type='submit']"
			+ "//parent::td//input[@value='Load From Company']//following-sibling::input[@value='Save']")
	WebElement saveBtn;
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactsLabel() {
		return contactsLabel.isDisplayed();
	}
	public void selectContactsByName(String name) {
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']"
				+ "//preceding-sibling::td//input[@name='contact_id']")).click();	
		}
	public void createNewContact(String title,String ftName,String ltName,String company) {
		Select select= new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(title);
		
		firstName.sendKeys(ftName);
		surName.sendKeys(ltName);
		companyName.sendKeys(company);
		saveBtn.click();
		
	}
	}
	


