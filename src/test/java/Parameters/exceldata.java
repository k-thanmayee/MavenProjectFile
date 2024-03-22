package Parameters;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class exceldata {
	XSSFWorkbook wb;
	XSSFSheet sheet;
	
	public exceldata(String excelfilepath) {
		try {
			File name=new File(excelfilepath);
			FileInputStream fis=new FileInputStream(name);
			wb=new XSSFWorkbook(fis);
		}
		catch(Exception e) {
			System.out.print("error "+e); 
		}
		
	}
	public String getdata(int sheetno,int row, int cell) {
		sheet=wb.getSheetAt(sheetno);
		//System.out.println(sheetno+" "+row+" "+cell);
		String data=sheet.getRow(row).getCell(cell).getStringCellValue();
		System.out.println(data);
		return data;
	}
	public int getrowcount(int sheetindex) {
		int rowcount=wb.getSheetAt(sheetindex).getLastRowNum();
		System.out.println(rowcount);
		return rowcount;
	}
	
}
