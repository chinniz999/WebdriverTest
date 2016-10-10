package com.fusion.seleniun;

//import java.io.IOException;

import org.junit.Assert;
//import org.testng.annotations.DataProvider;

//import com.fusion.selenium.utility.ExcelUtil;

public class samp {

	public static void AssertEqualsg(String expected, String actual){

			try{
			Assert.assertEquals(expected, actual);
			
			}catch(Exception e)	{

			Exception a =e;
			System.out.println(a);
			}
	}
	
/*	public static void verifyEquals(String expected, String actual){

		AssertEqualsg(expected, actual);

		}*/
}
