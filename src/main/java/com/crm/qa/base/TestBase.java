package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.WebEventListener;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	public TestBase() {
		try {
		prop= new Properties();
			FileInputStream fis = new FileInputStream("E:\\FreeCrmTestNew\\config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}

 
public static void initialization() {
	String browserName=prop.getProperty("browser");
	if (browserName.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver", "./resourse/chromedriver.exe");
		driver= new ChromeDriver();
	}
	else if(browserName.equals("firefox")) {
		System.setProperty("webdriver.gecko.driver", "./resourse/geckodriver.exe");
		driver= new FirefoxDriver();
	}
	
	
	e_driver = new EventFiringWebDriver(driver);
	// Now create object of EventListerHandler to register it with EventFiringWebDriver
	eventListener = new WebEventListener();
	e_driver.register(eventListener);
	driver = e_driver;
	
	driver.manage().window().maximize();
	driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.manage().deleteAllCookies();
	driver.get(prop.getProperty("url"));
	
		
	
}
}
