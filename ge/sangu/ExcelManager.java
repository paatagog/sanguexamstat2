package ge.sangu;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;

/**
 * Created by amigo on 3/12/2016.
 */
public class ExcelManager {
    public List<MarkItem> loadMarks() {
        List<MarkItem> markItems = new ArrayList<MarkItem>();
        try {
            FileInputStream file = new FileInputStream(new File("d:/dev/examstat/marks.xls"));
            HSSFWorkbook workbook = new HSSFWorkbook(file);
            HSSFSheet sheet = workbook.getSheetAt(0);
            int i = 0;
            for (Row row: sheet) {
                MarkItem mi = new MarkItem();
                Iterator<Cell> cellIterator = row.cellIterator();
                if (i==0) {
                    i++;
                } else {

                    Cell cell = cellIterator.next();
                    mi.setId((long) cell.getNumericCellValue());

                    cell = cellIterator.next();
                    mi.setStudentId((long) cell.getNumericCellValue());

                    cell = cellIterator.next();
                    mi.setStudentName(cell.getStringCellValue());

                    cell = cellIterator.next();
                    mi.setPersonalNumber(String.valueOf(cell.getNumericCellValue()));

                    cell = cellIterator.next();
                    mi.setFaculty(cell.getStringCellValue());

                    cell = cellIterator.next();
                    mi.setDisciplin(cell.getStringCellValue());

                    cell = cellIterator.next();
                    mi.setMark((int) cell.getNumericCellValue());

                    markItems.add(mi);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Can not open file");
            e.printStackTrace();
        }

        return markItems;
    }
}
