package Controller;

import Model.Student;
import javax.swing.*;

/**
 * Created by Lion on 19.03.2016.
 */
public class OkAdd {
    public void addStudent(String name, String group, String omissionsDisease, String omissionsOtherCauses,
                           String omissionsWithoutGoodReasonField) {

        if (name.equals("") || group.equals("") || omissionsDisease.equals("") || omissionsOtherCauses.equals("") ||
                omissionsWithoutGoodReasonField.equals("")) {
            JOptionPane.showMessageDialog(null, "Заполните все поля");
            return;
        }

        int omissionsInt = Integer.parseInt(omissionsDisease) + Integer.parseInt(omissionsOtherCauses) +
                Integer.parseInt(omissionsWithoutGoodReasonField);

        Student student = new Student(name, group, omissionsDisease, omissionsOtherCauses,
                omissionsWithoutGoodReasonField, omissionsInt + "");

        Student.students.add(student);
    }
}
