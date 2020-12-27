package excelhandling;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadingAllCellDataFromExcelFile {
	@Test
	public void readExcelData() throws Exception {
		String filepath="./excel/NameData.xlsx";
		FileInputStream fis=new FileInputStream(filepath);
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		int rows = workbook.getSheet("name").getLastRowNum();
		int cols=workbook.getSheet("name").getRow(0).getLastCellNum();
		String data="";
		for(int r=0;r<=rows;r++) {
			for(int c=0;c<cols;c++) {
				data=workbook.getSheet("name").getRow(r).getCell(c).toString();
				System.out.print(data+"->");
			}
			System.out.println();
		}
		workbook.close();
	}
}
