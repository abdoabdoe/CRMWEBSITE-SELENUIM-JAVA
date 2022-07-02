package testlogin;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class fileSheet {
    public static void main(String[] args) {
        File file = new File(); //put your file path here//
        FileInputStream fis = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet("ContactPage");
        String familyName = sheet.getRow(0).getCell(1).toString();
        System.out.println(familyName);
        int rows = sheet.getLastRowNum();
        int columns = sheet.getRow(0).getLastCellNum();
        Object data[][] = new Object[rows][columns];
        for (int i = 0; i < rows; i++)
        {
            for (int k = 0; k < columns ; k++)
                data[i][k] = sheet.getRow(i).getCell(k);
        }

        System.out.println(data[1][2]);
        return data;
    }


}
