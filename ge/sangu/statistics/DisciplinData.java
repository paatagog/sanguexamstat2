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
}
