package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestInput {

	//Variables

	public String origination,destination, depDate;


	public ArrayList<String> ReadTestDataFromExcel(int RowNum) throws IOException
	{
		ArrayList<String> Inputs = new ArrayList<String>();

		FileInputStream fs = new FileInputStream("C:\\Users\\USER\\eclipse-workspace\\SeleniumAutomation\\src\\test\\resources\\Input Data.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		XSSFSheet sheet = workbook.getSheetAt(0);
		//XSSFRow row = sheet.getRow(0);
		//XSSFCell cell = row.getCell(0);

		origination = sheet.getRow(RowNum).getCell(0).toString();
		destination = sheet.getRow(RowNum).getCell(1).toString();
		depDate = sheet.getRow(RowNum).getCell(2).toString();
		Inputs.add(origination);
		Inputs.add(destination);
		Inputs.add(depDate);
		workbook.close();
		return Inputs;

	}





}
