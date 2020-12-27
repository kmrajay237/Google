package excelhandling;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadNumberOfRowsAndColumnsInExcelFile{
	@Test
	public void countRowsAndColumns() throws Exception{
		String filepath="./excel/NameData.xlsx";
		FileInputStream fis=new FileInputStream(filepath);
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		int rows = workbook.getSheet("name").getLastRowNum();
		int cols=workbook.getSheet("name").getRow(0).getLastCellNum();
		System.out.println("Number of Rows: "+rows);
		System.out.println("Number of Columns: "+cols);
		workbook.close();
	}
}
