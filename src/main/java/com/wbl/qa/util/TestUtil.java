package com.wbl.qa.util;

import com.wbl.qa.basePage.BasePage;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.internal.FileHelper;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.util.POILogger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.*;


public class TestUtil extends BasePage {
   static Sheet sheet;
   static Workbook book;
    private static FileHelper FileUtils;


    public static Object[][] getData(String sheetName) {
        FileInputStream file = null;
        BufferedInputStream bufferedInputStream = null;



        try {
            file = new FileInputStream("C:\\Users\\sunil\\IdeaProjects\\WhiteboxQA\\src\\main" +
                    "\\java\\com\\wbl\\qa\\testdata\\RegisterTestData.xlsx");
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

        sheet = book.getSheet("Register page");
        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
        for (int i = 0; i < sheet.getLastRowNum(); i++) {
            for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
                data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
            }
        }
        return data;
    }

    public static void takeScreenShot() throws IOException {

        File  srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String currentDir = System.getProperty("user.dir");
        FileUtils.copyFile(srcFile,new File(currentDir +"/screenshots/" +System.currentTimeMillis() + ".png"));
    }
}


