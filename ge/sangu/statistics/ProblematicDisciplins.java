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

    private static void printToFile(String fileName, String data) {
        try (PrintWriter out = new PrintWriter(fileName)) {
            out.println(data);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void viewStatistic(String fileName, List<DisciplinData> dds) {
        StringBuilder sb = new StringBuilder();
        for (DisciplinData d : dds) {
            sb.append(d + "\n").
                    append("count(0)=" + d.countOfInterval(0, 0) + ";").
                    append("count(1-11)=" + d.countOfInterval(1, 11) + ";\n").
                    append("\n\n");
        }
        printToFile(fileName, sb.toString());
    }

    public static void viewProblematic(String fileName, List<DisciplinData> dds) {
        StringBuilder sb = new StringBuilder();
        for (DisciplinData d : dds) {
            if (((double) d.countOfInterval(1, 11)) / d.getMis().size() > 50.0 / 100
                    && d.getMis().size() != 1
                    ) {
                sb.append(d + "\n").
                        append("count(0)=" + d.countOfInterval(0, 0) + ";").
                        append("count(1-11)=" + d.countOfInterval(1, 11) + ";\n").
                        append("\n\n");
            }
        }
        printToFile(fileName, sb.toString());
    }

    public static void viewError(String fileName, List<DisciplinData> dds) {
        StringBuilder sb = new StringBuilder();
        for (DisciplinData d : dds) {
            if (d.getMis().size() == 1 && d.getMis().get(0).getMark() == 0) {
                sb.append(d + "\n");
            }
        }
        printToFile(fileName, sb.toString());
    }

    private static void viewSortedFailRate(String fileName, List<DisciplinData> dds) {
        boolean includeZero = true;
        List<DisciplinData> sorted = new ArrayList<DisciplinData> ();
        StringBuilder sb = new StringBuilder();
        for (DisciplinData d : dds) {
            if (d.getMis().size() != 1) {
//            if (d.getMis().size() != 1 || d.getMis().get(0).getMark() != 0) {
                sorted.add(d);
            }
        }
        Collections.sort(sorted, new FailRateComparator(includeZero));
        for (DisciplinData dd : sorted) {
            sb.append(dd).append("failRate="+dd.failRate(includeZero)+"\n\n");
        }
        printToFile(fileName, sb.toString());
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
        //viewStatistic("all.txt", dds);
        //viewProblematic("problematic.txt", dds);
        //viewError("error.txt", dds);
        viewSortedFailRate("sortedFailRate.txt", dds);
        viewSortedFailRate("sortedFailRateWithZero.txt", dds);

    }

}
