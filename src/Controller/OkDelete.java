package Controller;

import Model.Student;
import View.TableStudents;

import javax.swing.*;

/**
 * Created by Lion on 22.03.2016.
 */
public class OkDelete {
    String name;
    String group;
    String typeOmissions;
    JTable tableStudents;
    TableStudents tableModel;
    String lowerLimit;
    String upperLimit;

    public OkDelete(String name, String group, String typeOmissions, JTable tableStudents, TableStudents tableModel,
                    String lowerLimit, String upperLimit) {

        this.name=name;
        this.group=group;
        this.typeOmissions=typeOmissions;
        this.tableStudents=tableStudents;
        this.tableModel=tableModel;
        this.lowerLimit=lowerLimit;
        this.upperLimit=upperLimit;
    }

    public void deleteStudent() {
        int column=0;
        if (name != null && group != null) {
            for (int i=0; i<tableStudents.getRowCount(); i++) {
                if (name.equals(tableStudents.getValueAt(i, 0)) && group.equals(tableStudents.getValueAt(i, 1))) {
                    Student.students.remove(i);
                }
            }
        }

        if (name != null && (group == null || group.equals("")) && !typeOmissions.equals("Выберите вид пропуска") &&
                Integer.parseInt(lowerLimit)==0 && Integer.parseInt(upperLimit)==0) {

            if (typeOmissions.equals("Пропуски по болезни")) {column=2;}
            if (typeOmissions.equals("Пропуски по другим причинам")) {column=3;}
            if (typeOmissions.equals("Пропуски без уважительной причины")) {column=4;}

            for (int i=0; i<tableStudents.getRowCount(); i++) {
                int value;
                value = Integer.parseInt(tableModel.getValueAt(i, column));
                if (name.equals(tableStudents.getValueAt(i, 0)) && value > 0) {
                    Student.students.remove(i);
                }
            }
        }

        if (name != null && lowerLimit!=null && upperLimit!=null && (group == null || group.equals("")) &&
                Integer.parseInt(lowerLimit)>=0 && Integer.parseInt(upperLimit)>0) {

            if (typeOmissions.equals("Пропуски по болезни")) {column=2;}
            if (typeOmissions.equals("Пропуски по другим причинам")) {column=3;}
            if (typeOmissions.equals("Пропуски без уважительной причины")) {column=4;}

            int lowerLim = Integer.parseInt(lowerLimit);
            int upperLim = Integer.parseInt(upperLimit);

            for (int i=0; i<tableStudents.getRowCount(); i++) {
                if (name.equals(tableStudents.getValueAt(i, 0))) {
                    int value;
                    value = Integer.parseInt(tableModel.getValueAt(i, column));
                    if (value > lowerLim && value <= upperLim) {
                        Student.students.remove(i);
                    }
                }
            }
        }
    }
}
