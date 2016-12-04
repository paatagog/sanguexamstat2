package ge.sangu;

/**
 * Created by amigo on 3/12/2016.
 */
public class MarkItem {
    long id;
    long studentId;
    String studentName;
    String personalNumber;
    String faculty;
    String disciplin;
    int mark;

    public String toString() {
        return "(" + String.valueOf(id) + ";" + studentId + ";" + studentName + ";" + personalNumber + ";" + faculty + ";" + disciplin + ";" + mark + ")";
    }

    public String toStudentMark() {
        return "(" + studentName + ";" + mark + ")";
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(String personalNumber) {
        this.personalNumber = personalNumber;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getDisciplin() {
        return disciplin;
    }

    public void setDisciplin(String disciplin) {
        this.disciplin = disciplin;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }
}
