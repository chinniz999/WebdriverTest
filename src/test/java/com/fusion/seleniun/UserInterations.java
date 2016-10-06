package com.fusion.seleniun;

import java.util.concurrent.TimeUnit;

//import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UserInterations {
	WebDriver driver = new FirefoxDriver();

	/*@Test(priority=0)
	public void TextBox() throws InterruptedException {
		driver.findElement(By.xpath("//input[@data-reactid='180']")).sendKeys("7675974567");
		Thread.sleep(1000);
		String Value1 = driver.findElement(By.xpath("//input[@data-reactid='180']")).getAttribute("value");
		System.out.println(Value1);
		//driver.findElement(By.xpath("//li[@ng-bind='text.signupLink']")).click();
	}
	
	@Test(priority=1)
	public void RadioButton(){
		driver.findElement(By.xpath("//span[@data-reactid='173']")).click();
		driver.findElement(By.xpath("//span[@data-reactid='168']")).click();
		System.out.println("Postpaid isSelected: "+driver.findElement(By.xpath("//span[@data-reactid='168']")).isSelected());
		System.out.println("Postpaid isEnabled: "+driver.findElement(By.xpath("//span[@data-reactid='168']")).isEnabled());
	}
	
	@Test(priority=2)
	public void checkBox(){
		driver.findElement(By.xpath("//input[@data-reactid='201']")).click();
		System.out.println("CheckBox isSelected: "+driver.findElement(By.xpath("//input[@data-reactid='201']")).isSelected());
		System.out.println("CheckBox isEnabled: "+driver.findElement(By.xpath("//input[@data-reactid='201']")).isEnabled());
		driver.findElement(By.xpath("//input[@data-reactid='201']")).click();
		System.out.println("CheckBox isSelected: "+driver.findElement(By.xpath("//input[@data-reactid='201']")).isSelected());
	}
	
	@Test(priority=3)
	public void DropDown(){
		driver.get("http://www.calculator.net/interest-calculator.html");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Select dropdownlist = new Select(driver.findElement(By.id("ccompound")));
		dropdownlist.selectByVisibleText("monthly");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println(driver.findElement(By.xpath("//option[@value='monthly']")).isSelected());
	}
*/
	@Test()
	public void DragNdrop(){
	//	driver.get("http://keenthemes.com/preview/metronic/theme/admin_1/ui_tree.html");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement From = driver.findElement(By.id("j3_7_anchor"));
		WebElement To = driver.findElement(By.id("j3_1_anchor"));
		Actions builder = new Actions(driver);
		
		builder.dragAndDrop(From, To).perform();
		
		
		/*//Action Drag_Drop = builder.clickAndHold(From).moveToElement(To).release(To).build();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Drag_Drop.perform();
*/		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	@BeforeTest
	public void lanching() throws InterruptedException {
		/*System.setProperty("webdriver.chrome.driver", "D:\\AutomationFramework\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();*/
		//driver.get("http://www.paytm.com");
		driver.get("http://keenthemes.com/preview/metronic/theme/admin_1/ui_tree.html");
		driver.manage().window().maximize();
		Thread.sleep(1000);
	}

	@AfterTest
	public void closing() {
		driver.manage().deleteAllCookies();
		//driver.close();
	}

}
