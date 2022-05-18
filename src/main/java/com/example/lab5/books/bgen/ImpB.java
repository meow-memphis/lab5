package com.example.lab5.books.bgen;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;

public class ImpB {

    private String[] arrRuStNames;
    private String[] arrEnStNames;
    private String[] arrEnStUniversities;
    private String[] arrEnStAuthors;
    private String[] arrRuFicNames;
    private String[] arrRuFicAuthors;
    private String[] arrEnFicNames;
    private String[] arrEnFicAuthors;


    public void setAll(File file) throws IOException, InvalidFormatException {
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        arrRuStNames = read(workbook, 0);
        arrEnStNames = read(workbook, 1);
        arrEnStUniversities = read(workbook, 2);
        arrEnStAuthors = read(workbook, 3);
        arrRuFicNames = read(workbook, 4);
        arrRuFicAuthors = read(workbook, 5);
        arrEnFicNames = read(workbook, 6);
        arrEnFicAuthors = read(workbook, 7);
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
