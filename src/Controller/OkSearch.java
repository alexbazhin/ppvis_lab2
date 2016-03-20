package Controller;

import Model.Student;
import View.TableStudents;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lion on 20.03.2016.
 */
public class OkSearch {
    public List<Integer> searchStudent(String name, String group, String typeOmissions, JTable tableStudents, int lowerLim, int upperLim) {
        int column=0;
        List<Integer> list = new ArrayList<>();
        if (name!=null && group!=null) {
            for (int i=0; i<tableStudents.getRowCount(); i++) {
                if (name.equals(tableStudents.getValueAt(i, 0)) && group.equals(tableStudents.getValueAt(i, 1))) {
                    list.add(0);
                    list.add(1);
                    list.add(i);
                    list.add(i);
                    /*tableStudents.setColumnSelectionInterval(0, 1);
                    tableStudents.setRowSelectionInterval(i, i);*/
                }
            }
        }


        if (name != null && group == null) {

            if (typeOmissions.equals("Пропуски по болезни")) {column=2;}
            if (typeOmissions.equals("Пропуски по другим причинам")) {column=3;}
            if (typeOmissions.equals("Пропуски без уважительной причины")) {column=4;}

            for (int i=0; i<tableStudents.getRowCount(); i++) {
                if (name.equals(tableStudents.getValueAt(i, 0))) {
                    list.add(0);
                    list.add(column);
                    list.add(i);
                    list.add(i);
                    /*tableStudents.setColumnSelectionInterval(0, column);
                    tableStudents.setRowSelectionInterval(i, i);*/
                }
            }
        }

        if (name != null && group == null) {

            if (typeOmissions.equals("Пропуски по болезни")) {column=2;}
            if (typeOmissions.equals("Пропуски по другим причинам")) {column=3;}
            if (typeOmissions.equals("Пропуски без уважительной причины")) {column=4;}

            for (int i=0; i<tableStudents.getRowCount(); i++) {
                if (name.equals(tableStudents.getValueAt(i, 0))) {
                    int value = (Integer) tableStudents.getValueAt(i, column);
                    if (value>lowerLim && value<upperLim) {
                        list.add(0);
                        list.add(column);
                        list.add(i);
                        list.add(i);
                        /*tableStudents.setColumnSelectionInterval(0, column);
                        tableStudents.setRowSelectionInterval(i, i);*/
                    }
                }
            }
        }
        return list;
    }
}
