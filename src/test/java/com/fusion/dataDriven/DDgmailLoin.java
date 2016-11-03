package com.fusion.dataDriven;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fusion.selenium.utility.ExcelUtil;
import com.fusion.selenium.utility.Log4jConfig;
import com.fusion.selenium.utility.ScreanShort;

public class DDgmailLoin {

	WebDriver driver = null;
	String value = "";
	@Test(dataProvider = "Credentials")
	public void gmailLoin(String sUsername, String sPassWord, String abc) throws IOException {

		Log4jConfig logg = new Log4jConfig();
		System.out.println("sUsername" + sUsername);
		System.out.println("sPassWord" + sPassWord);
		System.out.println("abc" + abc);
		try {
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			logg.Logg("5 seconds implictly wait");
			driver.findElement(By.id("Email")).sendKeys(sUsername);
			logg.Logg("user name entered");
			driver.findElement(By.id("next")).click();
			logg.Logg("click next button");
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			logg.Logg("5 seconds implictly wait");
			driver.findElement(By.id("PersistentCookie")).click();
			logg.Logg("tick PersistentCookie");
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			logg.Logg("5 seconds implictly wait");
			driver.findElement(By.id("Passwd")).sendKeys(sPassWord);
			logg.Logg("password entered");
			driver.findElement(By.id("signIn")).click();
			logg.Logg("Click the signin button");
			value = driver.getTitle();
			logg.Logg("get title");
			GmainAssertions.AssertEqualsg("Gmail", value);
			logg.Logg("validate title with expected value");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			logg.Logg("10 seconds implictly wait");
			driver.findElement(By
					.xpath("//a[@href='https://accounts.google.com/SignOutOptions?hl=en&continue=https://mail.google.com/mail&service=mail']"))
					.click();
			logg.Logg("sellect the logout option");
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.findElement(By.id("gb_71")).click();
			logg.Logg("click the logout button");
		} catch (Exception e) {
			ScreanShort.takeScreanShot(driver, sUsername);
			GmainAssertions.AssertEqualsg("Gma", value);
		}
		// System.out.println(value);
	}

	@DataProvider(name = "Credentials")
	public Object[][] LonginCredentials() throws IOException {
		ExcelUtil ExcelData = new ExcelUtil(
				"C:\\Users\\madhubs\\git\\WebdriverTest\\src\\test\\resources\\Login Credential.xlsx", "Sheet2");
		int rows = ExcelData.excel_get_rows();
		int columns = ExcelData.excel_get_column();
		System.out.println("Row count----" + rows);
		System.out.println("column count----" + columns);

		Object[][] data = new Object[rows][columns];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				data[i][j] = ExcelData.getCellDataAsString(i, j);
				// System.out.println("----------------" + data[i][j]);
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