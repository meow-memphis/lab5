package com.example.lab5.books.bgen;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;

public class ImpB {

    private String[] arrNames;
    private String[] arrMiddlenames;
    private String[] arrSurnames;
    private String[] arrProfSurnames;
    private String[] arrWNames;


    public void setAll(File file) throws IOException, InvalidFormatException {
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        arrNames = read(workbook, 0);
        arrWNames = read(workbook, 1);
        arrSurnames = read(workbook, 2);
        arrProfSurnames = read(workbook, 3);
        workbook.close();
    }

    public String[] read(XSSFWorkbook workbook, int num) {
        XSSFSheet sheet = workbook.getSheetAt(num);
        String[] arr = new String[sheet.getLastRowNum() + 1];
        for (int i = 0; i <= sheet.getLastRowNum(); i++) {
            if (sheet.getRow(i).getCell(0) != null) {
                arr[i] = sheet.getRow(i).getCell(0).getStringCellValue();
            }
        }
        return arr;
    }

}
