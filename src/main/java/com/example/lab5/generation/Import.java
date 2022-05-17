package com.example.lab5.generation;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;

public class Import {
    //https://statusname.ru/articles/lichnye-imena/pravila-obrazovaniya-i-napisan/
    private String[] arrProfSurnames;
    private String[] arrNames;
    private String[] arrWNames;
    private String[] arrSurnames;
    private String[] arrWSurnames;

    public String[] getArrWSurnames() {
        return arrWSurnames;
    }

    private String[] arrMiddlenames;
    private String[] arrWMiddlenames;

    public String[] getArrProfSurnames() {
        return arrProfSurnames;
    }

    public String[] getArrNames() {
        return arrNames;
    }

    public String[] getArrWNames() {
        return arrWNames;
    }

    public String[] getArrSurnames() {
        return arrSurnames;
    }

    public String[] getArrMiddlenames() {
        return arrMiddlenames;
    }

    public String[] getArrWMiddlenames() {
        return arrWMiddlenames;
    }

    public void setAll(File file) throws IOException, InvalidFormatException {
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        arrNames = read(workbook, 0);
        arrSurnames = read(workbook, 1);
        arrWNames = read(workbook, 4);
        arrProfSurnames = read(workbook, 3);
        workbook.close();
        arrMiddlenames = setMiddlenames();
        arrWMiddlenames = setWMiddlenames();
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

    public String[] setMiddlenames() {
        String[] arrMiddlenames = new String[arrNames.length];
        int i = 0;
        for (String name : arrNames) {
            if (name.endsWith("ж") || name.endsWith("ш") || name.endsWith("ч") || name.endsWith("щ") || name.endsWith("ц") || name.endsWith("и") || name.endsWith("э") || name.endsWith("я") || name.endsWith("ю") || name.endsWith("е") || name.endsWith("ё")) {
                arrMiddlenames[i] = name + "евич";
            } else if (name.endsWith("а") || name.endsWith("у") || name.endsWith("ы")) {
                arrMiddlenames[i] = name.substring(0, name.length() - 1) + "ович";
            } else if (name.endsWith("о")) {
                arrMiddlenames[i] = name.substring(0, name.length() - 1) + "вич";
            } else if (name.endsWith("ь")) {
                arrMiddlenames[i] = name.substring(0, name.length() - 1) + "евич";
            }else {
                arrMiddlenames[i] = name + "евич";
            }
            i++;
        }
        return arrMiddlenames;
    }

    public String[] setWMiddlenames() {
        String[] arrWMiddlenames = new String[arrNames.length];
        int i = 0;
        for (String name : arrNames) {
            if (name.endsWith("ж") || name.endsWith("ш") || name.endsWith("ч") || name.endsWith("щ") || name.endsWith("ц") || name.endsWith("и") || name.endsWith("э") || name.endsWith("я") || name.endsWith("ю") || name.endsWith("е") || name.endsWith("ё")) {
                arrWMiddlenames[i] = name + "евна";
            } else if (name.endsWith("а") || name.endsWith("у") || name.endsWith("ы")) {
                arrWMiddlenames[i] = name.substring(0, name.length() - 1) + "овна";
            } else if (name.endsWith("о")) {
                arrWMiddlenames[i] = name.substring(0, name.length() - 1) + "вна";
            } else if (name.endsWith("ь")) {
                arrWMiddlenames[i] = name.substring(0, name.length() - 1) + "евна";
            }else {
                arrWMiddlenames[i] = name + "евна";
            }
            i++;
        }
        return arrWMiddlenames;
    }


}
