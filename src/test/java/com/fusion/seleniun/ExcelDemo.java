package com.fusion.seleniun;

import java.io.IOException;

import com.fusion.selenium.utility.ExcelUtil;

public class ExcelDemo {

	public static void main(String[] args) throws IOException {

		ExcelUtil excelData = new ExcelUtil("C:\\Users\\madhubs\\Desktop\\Login Credential.xlsx","Sheet1");
		System.out.println("Number of Rows: "+excelData.excel_get_rows());
	}

}
