package generic;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.Reporter;

public class Excel implements Auto_const
{
	public static String readData(String sheet, int row, int cell)
	{
		String val="";
		try 
		{
			FileInputStream fis=new FileInputStream(excel);
			Workbook wb = WorkbookFactory.create(fis);
			val = wb.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
		}
		catch (Exception e) 
		{
			Reporter.log("failed to read the data", true);
		}
		return val;
	}
	
	public static void writeData(String sheet, int row, int cell, String value)
	{
		try
		{
			FileInputStream fis=new FileInputStream(excel);
			Workbook wb = WorkbookFactory.create(fis);
			Cell c = wb.getSheet(sheet).getRow(row).createCell(cell);
			c.setCellValue(value);
			FileOutputStream fout=new FileOutputStream(excel);
			wb.write(fout);
		}
		catch (Exception e)
		{
			Reporter.log("failed to write data", true);
		}
	}
}
