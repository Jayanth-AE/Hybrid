package generic;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.Reporter;

public class Data_provider implements Auto_const
{
	public static Object[][] getData(String sheet)
	{
		Object[][] data=null;
		try
		{
			FileInputStream fis=new FileInputStream(excel);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(sheet);
			int rc = sh.getLastRowNum();
			Row x = sh.getRow(0);
			short cc = x.getLastCellNum();
			data=new Object[rc+1][cc];
			
			for (int i=0; i<rc+1; i++)
			{
				Row r = sh.getRow(i);
				for(int j=0; j<cc; j++)
				{
					Cell c = r.getCell(j);
					String val = c.getStringCellValue();
					data[i][j]=val;
				}
			}
		}
		catch(Exception e)
		{
			Reporter.log("failed to retrive the data", true);
		}
		return data;
	}
}
