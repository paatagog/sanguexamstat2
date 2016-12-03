package ge.sangu.statistics;

import ge.sangu.ExcelManager;
import ge.sangu.MarkItem;

import java.util.Collections;
import java.util.List;

/**
 * Created by amigo on 3/12/2016.
 */
public class FileReadTest {
    public static void main(String[] args) {
        ExcelManager em = new ExcelManager();
        List<MarkItem> mis = em.loadMarks();
        Collections.sort(mis, new MarkComparator());
        mis.forEach(System.out::println);
    }
}
