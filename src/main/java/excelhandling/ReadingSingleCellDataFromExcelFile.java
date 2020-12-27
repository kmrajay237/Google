package excelhandling;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class ReadingSingleCellDataFromExcelFile {
	@Test
	public void readExcelData() throws Exception {
		String filepath="./excel/NameData.xlsx";
		FileInputStream fis=new FileInputStream(filepath);
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
//		XSSFSheet sheet=workbook.getSheet("name");
//		XSSFRow row=sheet.getRow(1);
//		XSSFCell cell=row.getCell(1);
//		String data = cell.toString();
		String data=workbook.getSheet("name").getRow(0).getCell(0).toString();
		workbook.close();
		Reporter.log(data, true);
	}
}
