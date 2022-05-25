package utility;

import java.io.File;
import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.sql.RowIdLifetime;

import org.apache.poi.xssf.usermodel.XSSFCell;

import org.apache.poi.xssf.usermodel.XSSFRow;

import org.apache.poi.xssf.usermodel.XSSFSheet;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtils {

    private static XSSFSheet ExcelWSheet;

    private static XSSFWorkbook ExcelWBook;

    private static XSSFCell Cell;
    private static String[] headers = new String[] { "Date Time", "Order", "RFID TAG","Product","Quantity","Total","Gate","Detail" };
    private static XSSFRow Row;
    private static MissingCellPolicy xRow;

    //This method is to set the File path and to open the Excel file, Pass Excel Path and Sheetname as Arguments to this method
    public static void setExcelFile(String Path, String SheetName) throws Exception {

        try {

            // Open the Excel file
            File f = new File(Path);
            if(!f.exists()) {
            	ExcelWBook = new XSSFWorkbook();
            	ExcelWSheet = ExcelWBook.createSheet(SheetName);
            	FileOutputStream fileOut = new FileOutputStream(Path);
            	 ExcelWSheet.createRow(0);
            	for(int i=0;i< headers.length;i++){
            		 ExcelWSheet.getRow(0).createCell(i);
                   ExcelWSheet.getRow(0).getCell(i).setCellValue(headers[i]);
                }
            	ExcelWBook.write(fileOut);
            	fileOut.flush();
            	fileOut.close();
            }else{
            }
            FileInputStream ExcelFile = new FileInputStream(Path);
        	ExcelWBook = new XSSFWorkbook(ExcelFile);
        	ExcelWSheet = ExcelWBook.getSheet(SheetName);
            // Access the required test data sheet
            

            
            
        } catch (Exception e) {

            throw (e);

        }

    }

    //This method is to read the test data from the Excel cell, in this we are passing parameters as Row num and Col num
    public static String getCellData(int RowNum, int ColNum) throws Exception {

        try {

            Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);

            String CellData = Cell.getStringCellValue();

            return CellData;

        } catch (Exception e) {

            return "";

        }

    }

    //This method is to write in the Excel cell, Row num and Col num are the parameters
    public static void setCellData(String path,String Result, int RowNum, int ColNum) throws Exception {

        try {
            Row = ExcelWSheet.getRow(RowNum);
            if(Row == null) {
            	Row = ExcelWSheet.createRow(RowNum);
            }
            Cell = Row.getCell(ColNum, MissingCellPolicy.CREATE_NULL_AS_BLANK);

            if (Cell == null) {

                Cell = Row.createCell(ColNum);

                Cell.setCellValue(Result);

            } else {

                Cell.setCellValue(Result);

            }

            // Constant variables Test Data path and Test Data file name
            FileOutputStream fileOut = new FileOutputStream(path);

            ExcelWBook.write(fileOut);

            fileOut.flush();

            fileOut.close();

        } catch (Exception e) {

            throw (e);

        }

    }

}
