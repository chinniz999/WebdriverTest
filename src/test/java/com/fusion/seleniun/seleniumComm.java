package com.fusion.seleniun;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class seleniumComm {
	WebDriver driver;

	@Test
	public void act() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://wwww.flightaware.com/");
		//driver.get("http://www.paytm.com");
		/*Actions actions = new Actions(driver);
		WebElement mouseover = driver.findElement(By.xpath("//html[@lang='en']"));
		actions.moveToElement(mouseover);
		actions.click().perform();*/
		//driver.navigate().forward();
		driver.navigate().back();
		
		Select listbox = new Select(driver.findElement(By.xpath("//span[@class='search_in_content']")));
		listbox.selectByIndex(0);		
		// actions.keyDown(theKey)

		String winHandleBefore = driver.getWindowHandle();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		/*
		 * Actions oActions = new Actions(driver); WebElement menuoption =
		 * driver.findElement(By.xpath("//span[@data-reactid='125']"));
		 * oActions.moveToElement(menuoption); oActions.perform();
		 */ }

	@AfterTest
	public void afterTest() {
		driver.manage().deleteAllCookies();
		//driver.close();
		driver.quit();

	}
}
