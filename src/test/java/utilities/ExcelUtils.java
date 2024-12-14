package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

    public static int getRowCount(String xlfile, String xlsheet) throws IOException {
        try (FileInputStream fi = new FileInputStream(xlfile);
             XSSFWorkbook wb = new XSSFWorkbook(fi)) 
        {
            XSSFSheet ws = wb.getSheet(xlsheet);
            return ws.getLastRowNum();
        }
    }

    public static int getCellCount(String xlfile, String xlsheet, int rownum) throws IOException {
        try (FileInputStream fi = new FileInputStream(xlfile);
             XSSFWorkbook wb = new XSSFWorkbook(fi)) 
        {
            XSSFSheet ws = wb.getSheet(xlsheet);
            XSSFRow row = ws.getRow(rownum);
            return row.getLastCellNum();
        }
    }

    public static String getCellData(String xlfile, String xlsheet, int rownum, int colnum) throws IOException {
        try (FileInputStream fi = new FileInputStream(xlfile);
             XSSFWorkbook wb = new XSSFWorkbook(fi)) 
        {
            XSSFSheet ws = wb.getSheet(xlsheet);
            XSSFRow row = ws.getRow(rownum);
            if (row == null) 
            {
                return "";
            }
            XSSFCell cell = row.getCell(colnum);
            if (cell == null) 
            {
                return "";
            }
            DataFormatter formatter = new DataFormatter();
            return formatter.formatCellValue(cell);
        } catch (Exception e) 
        {
            return "";
        }
    }

    public static void setCellData(String xlfile, String xlsheet, int rownum, int colnum, String data) throws IOException {
        try (FileInputStream fi = new FileInputStream(xlfile);
             XSSFWorkbook wb = new XSSFWorkbook(fi)) {
            XSSFSheet ws = wb.getSheet(xlsheet);
            XSSFRow row = ws.getRow(rownum);
            if (row == null) {
                row = ws.createRow(rownum);
            }
            XSSFCell cell = row.getCell(colnum);
            if (cell == null) {
                cell = row.createCell(colnum);
            }
            cell.setCellValue(data);
            try (FileOutputStream fo = new FileOutputStream(xlfile)) {
                wb.write(fo);
            }
        }
    }
}
