package com.fusion.seleniun;

import org.testng.annotations.Test;

import com.fusion.selenium.utility.Browser;

import org.testng.annotations.BeforeTest;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class NewTest {

	WebDriver driver;
	@Test
	public void test2() {
	String title =	driver.getTitle();
	System.out.println("title is"+title);
	}
	
	@BeforeTest
	public void LanchBrowser(){
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();	
		driver.get("http:\\www.paytm.com");
	}
	
	@AfterTest
	public void CloseBrowser(){
		driver.close();
	}
}