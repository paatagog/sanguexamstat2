package ge.sangu.statistics;

import ge.sangu.ExcelManager;
import ge.sangu.MarkItem;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by amigo on 3/12/2016.
 */
public class ProblematicDisciplins {
    public static void viewStatistic(String fileName, List<DisciplinData> dds) {
        try (PrintWriter out = new PrintWriter(fileName)) {
            for (DisciplinData d : dds) {
                out.println(d);
                out.print("count(0)=" + d.countOfInterval(0, 0) + ";");
                out.println("count(1-11)=" + d.countOfInterval(1, 11) + ";");
                out.println("");
                out.println("");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void viewProblematic(String fileName, List<DisciplinData> dds) {
        try (PrintWriter out = new PrintWriter(fileName)) {
            for (DisciplinData d : dds) {
                if (
                        ((((double) d.countOfInterval(1, 11)) / d.getMis().size()) > (50.0 / 100))
                        && (d.getMis().size() != 1)
                        ) {
                    out.println(d);
                    out.print("count(0)=" + d.countOfInterval(0, 0) + ";");
                    out.println("count(1-11)=" + d.countOfInterval(1, 11) + ";");
                    out.println("");
                    out.println("");
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ExcelManager em = new ExcelManager();
        List<MarkItem> mis = em.loadMarks();
        Collections.sort(mis, new MarkComparator());
        MarkItem currentMi = null;
        List<DisciplinData> dds = new ArrayList<DisciplinData>();
        DisciplinData dd = new DisciplinData();
        for (MarkItem mi : mis) {
            if (currentMi == null) {
                currentMi = mi;
                dd.getMis().add(currentMi);
                continue;
            }

            if (mi.getFaculty().equals(currentMi.getFaculty()) && mi.getDisciplin().equals(currentMi.getDisciplin())) {
                currentMi = mi;
                dd.getMis().add(currentMi);
            } else {
                dds.add(dd);
                currentMi = mi;
                dd = new DisciplinData();
                dd.getMis().add(currentMi);
            }
        }
        viewStatistic("all.txt", dds);
        viewProblematic("problematic.txt", dds);

    }

}
