package com.fusion.selenium.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Browser {

	WebDriver driver;
	
	//@Test
	public void setBrowser() {

		String brow = System.getProperty("browser");
		
		if(brow.equalsIgnoreCase("firefox")){
			driver=new FirefoxDriver();
		}else if(brow.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver=new ChromeDriver();
		}
			
		System.out.println(brow);
		String SuiteName = System.getProperty("SuiteName");
		System.out.println(SuiteName);
	}

}
