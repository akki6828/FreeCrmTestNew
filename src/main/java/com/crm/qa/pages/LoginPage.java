package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	@FindBy(name="username")
	WebElement userName;
	@FindBy(name="password")
	WebElement password;
	@FindBy(xpath="//input[@class='btn btn-small']")
	WebElement loginBtn;
    @FindBy(xpath="//img[@src='https://d3lh3kd7bj2evy.cloudfront.net/img/logo.png']")
    WebElement logo;


public LoginPage() {
	PageFactory.initElements(driver,this);
	}
 public  String validateLoginPageTitle() {
	return driver.getTitle();
 }
 public boolean validateLogo() {
	 return logo.isDisplayed();
 }
 public HomePage login(String un, String pwd) {
	 userName.sendKeys(un);
	 password.sendKeys(pwd);
	 loginBtn.click();
	 return new HomePage();
	 
 }
}
