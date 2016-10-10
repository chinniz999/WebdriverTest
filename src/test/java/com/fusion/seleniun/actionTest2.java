package com.fusion.seleniun;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class actionTest2 {
		WebDriver driver;
		 
		 @Before
		 public void beforetest() {
		  System.setProperty("webdriber.chrome.driver", "chromedriver.exe");
		  driver.manage().window().maximize();
		  driver.get("http://only-testing-blog.blogspot.in/p/mouse-hover.html");
		 }
		 
		 @After
		 public void aftertest() {
		  driver.quit();
		  
		 }
		 
		 @Test
		 public void test () throws InterruptedException, IOException 
		 { 

			 Actions actions = new Actions(driver);
			  WebElement moveonmenu = driver.findElement(By.xpath("//div[@id='menu1']/div"));
			  actions.moveToElement(moveonmenu).moveToElement(driver.findElement(By.xpath("//div[@id='menu1choices']/a"))).click().perform();
			  
		  //Generate mouse hover event on main menu to click on sub menu
		  /*Actions actions = new Actions(driver);
		  WebElement moveonmenu = driver.findElement(By.xpath("//div[@id='menu1']/div"));
		  actions.moveToElement(moveonmenu);
		  actions.moveToElement(driver.findElement(By.xpath("//div[@id='menu1choices']/a"))).click();
		  actions.perform();*/
		  
		  WebDriverWait wait = new WebDriverWait(driver, 15);
		  wait.until(ExpectedConditions.titleContains("Google"));
		 }
		   
		}
