package com.wbl.qa.util;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestUtilLogin {

    static Sheet sheet;
    static Workbook book;

    public static Object[][] getData(String sheetName) {
        FileInputStream file = null;
        BufferedInputStream bufferedInputStream = null;



        try {
            file = new FileInputStream("C:\\Users\\sunil\\IdeaProjects\\WhiteboxQA\\src\\main\\java" +
                    "\\com\\wbl\\qa\\testdata\\login.xlsx");
            bufferedInputStream = new BufferedInputStream(file);
            // System.out.println("MArk Supported? =" + bufferedInputStream.markSupported());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            book = WorkbookFactory.create(bufferedInputStream);

        } catch (InvalidFormatException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }

        sheet = book.getSheet("Logindata");
        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
        for (int i = 0; i < sheet.getLastRowNum(); i++) {
            for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
                data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
            }
        }
        return data;
    }
}


