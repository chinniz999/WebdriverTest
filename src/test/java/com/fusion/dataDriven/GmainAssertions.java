package com.fusion.dataDriven;

import org.junit.Assert;

public class GmainAssertions {

	public static void AssertEqualsg(String expected, String actual) {

		try {
			Assert.assertEquals(expected, actual);

		} catch (Exception e) {

			Exception a = e;
			System.out.println(a);
		}
	}
	
	public static void AssertFail(Boolean fail){
		try{
			Assert.assertFalse(fail);
		}catch(Exception e){
			System.out.println(e);
		}
	}
}
