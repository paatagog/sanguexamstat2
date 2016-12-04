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
}
