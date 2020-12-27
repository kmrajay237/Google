package excelhandling;

import java.io.FileOutputStream;
import java.util.Date;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class WritingDataInExcelFile {
	
	@Test
	public void writeExcelFile() throws Exception{
		XSSFWorkbook workbook=new XSSFWorkbook();
		XSSFSheet sheet=workbook.createSheet("Employee Info");
		Object empData[][]= {
				{"EmpId","Name","Occupation"},
				{101,"David","Engineer"},
				{102,"Miller","Analyst"},
				{103,"Steve","Product Owner"},
				{104,"Smith","Director"},
				{105,"Tyagi","Manager"},
				{106,"Morgan","Lead"},
				{107,"Natraj","HR"}
		};
//		Using Normal for loop -> rows=8,columns=3
		int rows=empData.length;
		int cols=empData[0].length;
		System.out.println("Number of Rows: "+rows);
		System.out.println("Number of Columns: "+cols);
		for(int r=0;r<rows;r++) {
			XSSFRow row=sheet.createRow(r);
			for(int c=0;c<cols;c++) {
				XSSFCell cell=row.createCell(c);
				Object value = empData[r][c];
				if(value instanceof String)
					cell.setCellValue((String)value);
				if(value instanceof Integer)
					cell.setCellValue((Integer)value);
				if(value instanceof Boolean)
					cell.setCellValue((Boolean)value);
			}
		}
		Date date=new Date();
		String filepath="./excel/"+date+"_Employee_Data.xlsx";
		FileOutputStream fos=new FileOutputStream(filepath);
		workbook.write(fos);
		fos.close();
		workbook.close();
		System.out.println("Employee Data Written Successfully!!");
	}
}
