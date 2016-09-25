package com.fusion.seleniun;

import org.testng.annotations.Test;

//import org.testng.annotations.BeforeTest;
//import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class NewTest {

	WebDriver driver = null;
	
	@Test
	public void test2() {
	String title =	driver.getTitle();
	System.out.println("title is"+title);
	Assert.assertTrue(true, title);
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