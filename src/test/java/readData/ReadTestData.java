package readData;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;

public class ReadTestData {

    public String[][] readUserTestData() throws IOException, InvalidFormatException {
        File file = new File("./src/test/resources/UserTestData.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(file);
        XSSFSheet sheet = wb.getSheet("Sheet1");
        int numofrow = sheet.getPhysicalNumberOfRows();
        int numofcol = sheet.getRow(0).getLastCellNum();
        String [][] array = new String[numofrow-1][numofcol];
        for(int i=1; i<numofrow; i++){
            for (int j=0; j<numofcol;j++){
                XSSFRow row = sheet.getRow(i);
                array[i-1][j]=row.getCell(j).toString();
            }
        }
    return array;
    }
    public String[][] readLoginTestData() throws IOException, InvalidFormatException {
        File file = new File("./src/test/resources/UserTestData.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(file);
        XSSFSheet sheet = wb.getSheet("Sheet2");
        int numofrow = sheet.getPhysicalNumberOfRows();
        int numofcol = sheet.getRow(0).getLastCellNum();
        String [][] array = new String[numofrow-1][numofcol];
        for(int i=1; i<numofrow; i++){
            for (int j=0; j<numofcol;j++){
                XSSFRow row = sheet.getRow(i);
                array[i-1][j]=row.getCell(j).toString();
            }
        }
        return array;
    }

    public String[][] readUpdateUserTestData() throws IOException, InvalidFormatException {
        File file = new File("./src/test/resources/UserTestData.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(file);
        XSSFSheet sheet = wb.getSheet("Sheet3");
        int numofrow = sheet.getPhysicalNumberOfRows();
        int numofcol = sheet.getRow(0).getLastCellNum();
        String [][] array = new String[numofrow-1][numofcol];
        for(int i=1; i<numofrow; i++){
            for (int j=0; j<numofcol;j++){
                XSSFRow row = sheet.getRow(i);
                array[i-1][j]=row.getCell(j).toString();
            }
        }
        return array;
    }

    public String[][] readChangePassTestData() throws IOException, InvalidFormatException {
        File file = new File("./src/test/resources/UserTestData.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(file);
        XSSFSheet sheet = wb.getSheet("Sheet4");
        int numofrow = sheet.getPhysicalNumberOfRows();
        int numofcol = sheet.getRow(0).getLastCellNum();
        String [][] array = new String[numofrow-1][numofcol];
        for(int i=1; i<numofrow; i++){
            for (int j=0; j<numofcol;j++){
                XSSFRow row = sheet.getRow(i);
                array[i-1][j]=row.getCell(j).toString();
            }
        }
        return array;
    }

    public String[][] readNotesTestdata() throws IOException, InvalidFormatException {
        File file = new File("./src/test/resources/NotesTestData.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(file);
        XSSFSheet sheet = wb.getSheet("Sheet1");
        int numofrow = sheet.getPhysicalNumberOfRows();
        int numofcol = sheet.getRow(0).getLastCellNum();
        String [][] array = new String[numofrow-1][numofcol];
        for(int i=1; i<numofrow; i++){
            for (int j=0; j<numofcol;j++){
                XSSFRow row = sheet.getRow(i);
                array[i-1][j]=row.getCell(j).toString();
            }

        }
        return array;
    }

    public String[][] readUpdateNotesTestdata() throws IOException, InvalidFormatException {
        File file = new File("./src/test/resources/NotesTestData.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(file);
        XSSFSheet sheet = wb.getSheet("Sheet2");
        int numofrow = sheet.getPhysicalNumberOfRows();
        int numofcol = sheet.getRow(0).getLastCellNum();
        String [][] array = new String[numofrow-1][numofcol];
        for(int i=1; i<numofrow; i++){
            for (int j=0; j<numofcol;j++){
                XSSFRow row = sheet.getRow(i);
                array[i-1][j]=row.getCell(j).toString();
            }

        }
        return array;
    }
    

}
