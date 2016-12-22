package ge.sangu.statistics;

import java.util.Comparator;

/**
 * Created by paata on 22-Dec-16.
 */
public class BestRateComparatorSimple implements Comparator<DisciplinData> {

    @Override
    public int compare(DisciplinData d1, DisciplinData d2) {
        return Double.compare(d1.BestRate(),d2.BestRate());
    }

}
