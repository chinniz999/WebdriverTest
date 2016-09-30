package com.fusion.seleniun;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class gmailLogin {

	WebDriver driver = new FirefoxDriver();
	Actions myaction;
	@Test(priority = 0)
	public void Test_gmailLogin() {
		WebElement UserName = driver.findElement(By.id("Email"));
		UserName.clear();
		UserName.sendKeys("bsm.bills@gmail.com");
		driver.findElement(By.id("next")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.id("Passwd")).sendKeys("bsmbills123");
		driver.findElement(By.id("signIn")).click();
		// driver.findElement(By.id(":3l")).click();

	}

	@Test(priority = 1)
	public void Test_RefreshGmail() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//body")).sendKeys(Keys.F5);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	
	@Test(priority = 2)
	public void Test_gmailLogOut() {

		// using mouse over
		Actions myaction = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// right click on mouse
		Action rightClick = myaction.contextClick(driver.findElement(By.id(":3q"))).click().build();
		rightClick.perform();
		// read the message
		myaction.moveToElement(driver.findElement(By.id(":lo"))).click().build().perform();

		// logout
		myaction.moveToElement(driver.findElement(By.xpath("//span[@class='gb_7a gbii']"))).click().build().perform();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		myaction.moveToElement(driver.findElement(By.id("gb_71"))).click().build().perform();
		
	}

	@BeforeTest
	public void beforeTest() {
		driver.manage().window().maximize();
		driver.navigate().to("http://www.gmail.com");
	}

	@AfterTest
	public void afterTest() {
		driver.manage().deleteAllCookies();
		driver.close();
	}

}
