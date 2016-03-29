package View;


import Model.Student;
import javax.swing.table.AbstractTableModel;
import java.util.List;


public class TableStudents extends AbstractTableModel {

    List<Student> students;

    TableStudents(List<Student> students) {
        super();
        this.students = students;
    }

    public void add(Student student) {
        students.add(student);

    }
    public void model(List<Student> students) {
        this.students=students;
    }

    @Override
    public int getRowCount() {
        return students.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public String getColumnName(int c) {
        switch (c) {
            case 0:
                return "ФИО";
            case 1:
                return "Группа";
            case 2:
                return "по болезни";
            case 3:
                return "по другим причинам";
            case 4:
                return "без уважительной причины";
            case 5:
                return "Итого";
            default:
                return "Other Column";
        }
    }

    public void removeRow(int i)
    {
        students.remove(i);
    }

    @Override
    public String getValueAt(int r, int c) {
        switch (c) {
            case 0:
                return Student.students.get(r).getFullName();
            case 1:
                return Student.students.get(r).getGroup();
            case 2:
                return Student.students.get(r).getOmissionsDisease();
            case 3:
                return Student.students.get(r).getOmissionsOtherCauses();
            case 4:
                return Student.students.get(r).getOmissionsWithoutGoodReason();
            case 5:
                return Student.students.get(r).getOmissions();
            default:
                return "";
        }
    }
}

