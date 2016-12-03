package ge.sangu.statistics;

import ge.sangu.MarkItem;

import java.util.Comparator;

/**
 * Created by amigo on 3/12/2016.
 */
public class MarkComparator implements Comparator<MarkItem> {

    @Override
    public int compare(MarkItem mi1, MarkItem mi2) {
        if (!mi1.getFaculty().equals(mi2.getFaculty())) {
            return mi1.getFaculty().compareTo(mi2.getFaculty());
        }

        if (!mi1.getDisciplin().equals(mi2.getDisciplin())) {
            return mi1.getDisciplin().compareTo(mi2.getDisciplin());
        }

        if (!mi1.getStudentName().equals(mi2.getStudentName())) {
            return mi1.getStudentName().compareTo(mi2.getStudentName());
        }

        return mi1.getPersonalNumber().compareTo(mi2.getPersonalNumber());
    }
}
