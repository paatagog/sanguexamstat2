package ge.sangu.statistics;

import ge.sangu.MarkItem;

import java.util.Comparator;

/**
 * Created by amigo on 6/12/2016.
 */
public class FailRateComparator implements Comparator<DisciplinData> {

    private boolean includeZero;

    public FailRateComparator(boolean includeZero) {
        this.includeZero = includeZero;
    }

    @Override
    public int compare(DisciplinData d1, DisciplinData d2) {
        return Double.compare(d1.failRate(includeZero),d2.failRate(includeZero));
    }
}
