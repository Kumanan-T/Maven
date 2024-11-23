package com.utitlity;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import io.netty.handler.codec.DateFormatter;

public class ReadExcelData {

	public static String readParticularCellData(String sheet,int row,int col) throws InvalidFormatException, IOException {

		File f = new File("F:\\SQL GREENS\\DataDriver_Excel.xlsx");
		Workbook book = new XSSFWorkbook(f);
		Sheet sheet1 = book.getSheet(sheet);
		Row row1 = sheet1.getRow(row);
		Cell cell = row1.getCell(col);
	/*	String data = cell.getStringCellValue();
		System.out.println(data);*/
		
		DataFormatter dataFormat=new DataFormatter();
		String data = dataFormat.formatCellValue(cell);
//		System.out.println(data);
		return data;
	}

	public static void readCellData() throws InvalidFormatException, IOException {
		File f = new File("F:\\SQL GREENS\\DataDriver_Excel.xlsx");
		Workbook book = new XSSFWorkbook(f);
		Sheet sheet = book.getSheet("Sheet1");
		
		int lastRowNum = sheet.getLastRowNum();
		short lastCellNum = sheet.getRow(0).getLastCellNum();
		
		Row row = sheet.getRow(0);
		
		for (int i = 0; i < lastCellNum; i++) {
			Cell cell = row.getCell(i);
			DataFormatter dataFormat = new DataFormatter();
			String data = dataFormat.formatCellValue(cell);
			System.out.println(data);
		}
		
		
		
	}
	
	public static void readAlldata() throws InvalidFormatException, IOException {	
	
		File f = new File("F:\\SQL GREENS\\DataDriver_Excel.xlsx");
		Workbook book = new XSSFWorkbook(f);
		Sheet sheet = book.getSheet("Sheet1");
		
		int lastRowNum = sheet.getLastRowNum();
		short lastCellNum = sheet.getRow(0).getLastCellNum();
		
		for (int i = 0; i <=lastRowNum; i++) {//row iterate
			Row row = sheet.getRow(i);
			for (int j = 0; j <=lastCellNum; j++) {//column iterate
				Cell cell = row.getCell(j);
				DataFormatter dataFormat = new DataFormatter();
				String data = dataFormat.formatCellValue(cell);
				System.out.println(data);
			} 
		}
		
	
	
	}
	public static void main(String[] args) throws InvalidFormatException, IOException{
		//readParticularCellData();
		
		//readCellData();
		readAlldata();
	}

	

}
