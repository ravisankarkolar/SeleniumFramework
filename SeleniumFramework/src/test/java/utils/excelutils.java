package utils;

import java.io.IOException;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelutils {
static	XSSFWorkbook wb;
static XSSFSheet sheet;
static Properties prop= new Properties();
static String PrjPath=System.getProperty("user.dir");


public static void main(String[] args) {
	getRowCount();
	getData();
	//flightSearchtest();
	// TODO Auto-generated method stub

}


public static void getRowCount() {
	
	
	try {
		wb = new XSSFWorkbook(PrjPath+"\\excel\\data.xlsx");
		sheet=wb.getSheet("Sheet1");
		int rwcnt=sheet.getPhysicalNumberOfRows();
		System.out.println("Row count"+rwcnt);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
	
	public static void getData() {
		
		
		try {
			wb = new XSSFWorkbook(PrjPath+"\\excel\\data.xlsx");
			sheet=wb.getSheet("Sheet1");
			String r1=sheet.getRow(1).getCell(0).getStringCellValue();
			String r2=sheet.getRow(1).getCell(1).getStringCellValue();
			double r3=sheet.getRow(1).getCell(2).getNumericCellValue();
			System.out.println("Row Data"+r1+" "+r2+"  "+r3);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
}
}
