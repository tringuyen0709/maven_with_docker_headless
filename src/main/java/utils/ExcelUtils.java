package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	public static Object[][] getExcelData(String filePath, String sheetName) throws IOException {
		
//		System.out.println("debug 333");
//
//        FileInputStream fis = new FileInputStream(filePath);
//        Workbook workbook = new XSSFWorkbook(fis);
//        Sheet sheet = workbook.getSheet(sheetName);
//
//        int rowCount = sheet.getPhysicalNumberOfRows();
//        int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
//
//        Object[][] data = new Object[rowCount - 1][colCount];
//
//        for (int i = 1; i < rowCount; i++) {
//            Row row = sheet.getRow(i);
//            for (int j = 0; j < colCount; j++) {
//                Cell cell = row.getCell(j);
//                data[i - 1][j] = cell.toString();           	
//            }
//        }
//
//        workbook.close();
//        fis.close();
//
//
//        System.out.println("debug 444");
//        System.out.println("data = " + data);
//        
//        for (int i = 0; i < data.length; i++) {
//        	System.out.println("Row " + i + " = " + Arrays.toString(data[i]));
//        }
//        
//        return data;
		

		
		   FileInputStream fis = new FileInputStream(filePath);
	        Workbook workbook = new XSSFWorkbook(fis);
	        Sheet sheet = workbook.getSheet(sheetName);

	        int colCount = sheet.getRow(0).getPhysicalNumberOfCells();

	        List<Object[]> dataList = new ArrayList<>();

	        // Bỏ header, bắt đầu từ row 1
	        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
	            Row row = sheet.getRow(i);
	            if (row == null) continue;

	            Object[] rowData = new Object[colCount];
	            boolean hasData = false;

	            for (int j = 0; j < colCount; j++) {
	                Cell cell = row.getCell(j, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);

	                if (cell != null && !cell.toString().trim().isEmpty()) {
	                    rowData[j] = cell.toString();
	                    hasData = true;
	                } else {
	                    rowData[j] = "";
	                }
	            }

	            // Chỉ add row có data
	            if (hasData) {
	                dataList.add(rowData);
	            }
	        }

	        workbook.close();
	        fis.close();

	        Object[][] data = new Object[dataList.size()][colCount];
	        data = dataList.toArray(data);

	        // Debug
	        for (int i = 0; i < data.length; i++) {
	            System.out.println("Row " + i + " = " + java.util.Arrays.toString(data[i]));
	        }

	        return data;

    }

}










