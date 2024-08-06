package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ExcelReadClass {
	static FileInputStream f;
	static  XSSFWorkbook w;
	static  XSSFSheet sh;
	
	public static Properties property;
	
	public static String getStringData(int a,int b) throws IOException
	{
		
		property = new Properties();
		f = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\ExcelSheet.xlsx");
	    w= new XSSFWorkbook(f);
	    sh=w.getSheet("Sheet1");
	    XSSFRow r = sh.getRow(a);
	    XSSFCell c = r.getCell(b);
	    return c.getStringCellValue();
	}
	    
	public static String getIntegerData(int a,int b) throws IOException
	{
		f = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\ExcelSheet.xlsx");
	    w= new XSSFWorkbook(f);
	    sh=w.getSheet("Sheet1");
	    XSSFRow r = sh.getRow(a);
	    XSSFCell c = r.getCell(b);
	    int x = (int)c.getNumericCellValue();
	    return String.valueOf(x);
	}

}
