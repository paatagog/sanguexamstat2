package ge.sangu.statistics;

import ge.sangu.ExcelManager;
import ge.sangu.MarkItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by amigo on 3/12/2016.
 */
public class ProblematicDisciplins {
    public static void main(String[] args) {
        ExcelManager em = new ExcelManager();
        List<MarkItem> mis = em.loadMarks();
        Collections.sort(mis, new MarkComparator());
        MarkItem currentMi = null;
        List<DisciplinData> dds = new ArrayList<DisciplinData>();
        DisciplinData dd = null;
        for (MarkItem mi : mis) {
            if (currentMi == null) {
                currentMi = mi;
                continue;
            }

            if (mi.getFaculty().equals(currentMi.getFaculty()) && mi.getDisciplin().equals(currentMi.getDisciplin())) {
                currentMi = mi;
                if (dd == null) {
                    dd = new DisciplinData();
                }
                dd.getMis().add(currentMi);
            }
        }


    }

}
