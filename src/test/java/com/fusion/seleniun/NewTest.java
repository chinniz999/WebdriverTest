package com.fusion.seleniun;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

@Test
public class NewTest {

	public void test2(){
		System.out.println("welcome to testing");
	}
	
	/*WebDriver driver;	
	@Test				
	public void testEasy() {	
		driver.get("http://www.guru99.com/selenium-tutorial.html");  
		String title = driver.getTitle();				 
		Assert.assertTrue(title.contains("Free Selenium Tutorials")); 		
	}	
	
	@BeforeTest
	public void beforeTest() {	
	//	System.setProperty("webdriver.chrome.driver", "F:\\JenkinsSample\\chromedriver.exe");
		//ChromeDriver driver = new ChromeDriver();
		WebDriver driver = new FirefoxDriver();
	}		
	@AfterTest
	public void afterTest() {
		driver.close();			
	}	*/	
}	