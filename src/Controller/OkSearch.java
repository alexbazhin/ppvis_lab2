package Controller;

import View.TableStudents;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lion on 20.03.2016.
 */
public class OkSearch {
    public List<Integer> searchStudent(String name, String group, String typeOmissions, JTable tableStudents,
                                       String lowerLimit, String upperLimit, TableStudents tableModel) {
        int column=0;
        List<Integer> list = new ArrayList<>();


        if (name != null && group != null) {
            tableStudents.clearSelection();
            for (int i=0; i<tableStudents.getRowCount(); i++) {
                if (name.equals(tableStudents.getValueAt(i, 0)) && group.equals(tableStudents.getValueAt(i, 1))) {
                   list.add(i);
                }
            }
        }

        if (name != null && (group == null || group.equals("")) && !typeOmissions.equals("Выберите вид пропуска") &&
                Integer.parseInt(lowerLimit)==0 && Integer.parseInt(upperLimit)==0) {
            tableStudents.clearSelection();
            if (typeOmissions.equals("Пропуски по болезни")) {column=2;}
            if (typeOmissions.equals("Пропуски по другим причинам")) {column=3;}
            if (typeOmissions.equals("Пропуски без уважительной причины")) {column=4;}

            for (int i=0; i<tableModel.getRowCount(); i++) {
                int value = Integer.parseInt(tableModel.getValueAt(i, column));
                if (name.equals(tableModel.getValueAt(i, 0)) && value>0) {
                    list.add(i);
                }
            }
        }

        if (name != null && lowerLimit != null && upperLimit != null &&
                !typeOmissions.equals("Выберите вид пропуска") && Integer.parseInt(lowerLimit)>=0 &&
                Integer.parseInt(upperLimit)>0) {

            tableStudents.clearSelection();

            if (typeOmissions.equals("Пропуски по болезни")) {column=2;}
            if (typeOmissions.equals("Пропуски по другим причинам")) {column=3;}
            if (typeOmissions.equals("Пропуски без уважительной причины")) {column=4;}

            System.out.println(column);

            int lowerLim = Integer.parseInt(lowerLimit);
            int upperLim = Integer.parseInt(upperLimit);

            for (int i=0; i<tableStudents.getRowCount(); i++) {
                if (name.equals(tableStudents.getValueAt(i, 0))) {
                    int value = Integer.parseInt(tableModel.getValueAt(i, column));
                    if (value>lowerLim && value<=upperLim) {
                        list.add(i);
                    }
                }
            }
        }
        return list;
    }
}
