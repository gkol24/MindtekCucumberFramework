package utilities;

import io.cucumber.java.an.E;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.PaneInformation;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.*;

public class ExelTest {
    public static void main(String[] args) throws IOException {

        // String path = System.getProperty("user.dir") + "/src/test/resources/testData/FirstNameJohn.xlsx";

        // FileInputStream input = new FileInputStream(path);
        //Workbook workbook = new XSSFWorkbook(input);
        //Sheet sheet1 = workbook.getSheet("Sheet1");

        //String firstName = sheet1.getRow(1).getCell(0).toString();
        //System.out.println(firstName);
        //System.out.println(sheet1.getRow(2).getCell(1).toString());

        //sheet1.getRow(2).getCell(1).setCellValue("Abinov");
        //System.out.println(sheet1.getRow(2).getCell(1).toString());

        //FileOutputStream output = new FileOutputStream(path);
        //workbook.write(output);
        //output.close();
        ExcelUtils.openExcelFile("FirstNameJohn", "Sheet1");
        System.out.println(ExcelUtils.getValue(3, 2));

        ExcelUtils.setValue(1, 2, "tom@gmail.com");
        System.out.println(ExcelUtils.getValue(1, 2));

        //ExcelUtils.setValue(5,0,"Emily");
       // System.out.println(ExcelUtils.getValue(5,0));


        ExcelUtils.setValue(1, 3, "smith@gmail.com");
        System.out.println(ExcelUtils.getValue(2, 1));
        ExcelUtils.setValue(4, 2, "smith1@gmail.com");
        System.out.println(ExcelUtils.getValue(4, 2));

        System.out.println(ExcelUtils.getValue(4, 1));
        System.out.println(ExcelUtils.getValue(4,3));

        List<String> names = new ArrayList<>();
        names.add("Raif");
        names.add("Usha");
        names.add("Najya");
        names.add("Tom");

        for (String name : names) {
            ExcelUtils.setValue(1, 2, name);
            System.out.println(ExcelUtils.getValue(1, 2));

        }

        List<String> lastNames =new ArrayList<>();
        lastNames.add("Smith");
        lastNames.add("Monroe");
        lastNames.add("Baker");

        for(String lastName : lastNames){
            ExcelUtils.setValue(1,1,lastName);
            System.out.println(ExcelUtils.getValue(1,1));
        }

        System.out.println(ExcelUtils.getValue(1,0));
        System.out.println(ExcelUtils.getValue(1,1));
        System.out.println(ExcelUtils.getValue(1,2));
        System.out.println(ExcelUtils.getValue(2,3));

    }

}

