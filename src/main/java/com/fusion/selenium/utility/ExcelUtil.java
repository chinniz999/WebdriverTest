package com.fusion.selenium.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

	private XSSFWorkbook ExcelWbook;
	private XSSFSheet ExcelSheet;
	
	public ExcelUtil(String path, String SheetName) throws IOException{
					
		//open excel file
		FileInputStream ExcelFile = new FileInputStream(path);
		
		//Access require excel sheet
		ExcelWbook = new XSSFWorkbook(ExcelFile);
		ExcelSheet = ExcelWbook.getSheet(SheetName);
		ExcelSheet.getPhysicalNumberOfRows();
	}
	
	//set the row count of excel file
	public int excel_get_rows(){
		return ExcelSheet.getPhysicalNumberOfRows();
	}
	
	//get the data from excel cell
	public String getCellDataAsString(int rowNum, int colNum){
		String cellData = ExcelSheet.getRow(rowNum).getCell(colNum).getStringCellValue();
		return cellData;
	}
}
