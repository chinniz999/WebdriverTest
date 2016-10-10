package com.fusion.dataDriven;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fusion.selenium.utility.ExcelUtil;

public class DDgmailLoin {

	WebDriver driver = null;

	@Test(dataProvider = "Credentials")
	public void gmailLoin(String sUsername, String sPassWord, String abc) {
		
		System.out.println("sUsername" + sUsername);
		System.out.println("sPassWord" + sPassWord);
		System.out.println("abc" + abc);
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.id("Email")).sendKeys(sUsername);
		driver.findElement(By.id("next")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.id("PersistentCookie")).click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(By.id("Passwd")).sendKeys(sPassWord);
		driver.findElement(By.id("signIn")).click();
		String value=driver.getTitle();
		GmainAssertions.AssertEqualsg("Gmail", value);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//span[@class='gb_7a gbii']")).click();
		driver.findElement(By.id("gb_71")).click();
		//System.out.println(value);
	}

	@DataProvider(name = "Credentials")
	public Object[][] LonginCredentials() throws IOException {
		ExcelUtil ExcelData = new ExcelUtil("src\\main\\resources\\Login Credential.xlsx", "Sheet2");
		int rows = ExcelData.excel_get_rows();
		int columns = ExcelData.excel_get_column();
		System.out.println("Row count----" + rows);
		System.out.println("column count----" + columns);
		
		Object[][] data = new Object[rows][columns];
		for (int i = 0; i <rows; i++){
			for (int j = 0; j < columns; j++) {
				data[i][j] = ExcelData.getCellDataAsString(i, j);
			//	System.out.println("----------------" + data[i][j]);
			}
		}
		return data;
	}

	@BeforeTest
	public void beforeTest() {
		driver = new FirefoxDriver();
		driver.get("http://www.gmail.com");
		driver.manage().window().maximize();
	}

	@AfterTest
	public void afterTest() {
		
		driver.manage().deleteAllCookies();
		driver.close();
	}

}