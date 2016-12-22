package ge.sangu.statistics;

import ge.sangu.MarkItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by amigo on 3/12/2016.
 */
public class DisciplinData {
    List<MarkItem> mis = new ArrayList<MarkItem>();

    public List<MarkItem> getMis() {
        return mis;
    }

    public void setMis(List<MarkItem> mis) {
        this.mis = mis;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("faculty='").append(mis.get(0).getFaculty()).append("';").
                append(" disciplin='").append(mis.get(0).getDisciplin()).append("';\n");
        for (MarkItem mi: mis) {
            sb.append(mi.toStudentMark()).append("\n");
        }
        return sb.toString();
    }

    public int countOfInterval(int min, int max)  {
        int count = 0;
        for (MarkItem mi: mis) {
            if (min <= mi.getMark() && mi.getMark() <= max) {
                count++;
            }
        }
        return count;
    }

    public double meanOfInterval(int min, int max)  {
        int count = 0;
        int total = 0;
        for (MarkItem mi: mis) {
            if (min <= mi.getMark() && mi.getMark() <= max) {
                count++;
                total += mi.getMark();
            }
        }
        return (double)total/count;
    }

    public double failRate(boolean includeZero) {
        return (double)countOfInterval(includeZero?0:1, 11) / mis.size();
    }
    public double BestRate() {
        return (double)countOfInterval(25, 30) / mis.size();
    }
    public double BestMeanRate() {
        return (double)meanOfInterval(25, 30) / mis.size();
    }
}
