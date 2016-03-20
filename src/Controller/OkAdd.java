package Controller;

import Model.Student;

/**
 * Created by Lion on 19.03.2016.
 */
public class OkAdd {
    public void addStudent(String name, String group, String omissionsDisease, String omissionsOtherCauses, String omissionsWithoutGoodReasonField, String omissions) {
        Student student = new Student(name, group, omissionsDisease, omissionsOtherCauses, omissionsWithoutGoodReasonField, omissions);
        Student.students.add(student);
    }
}
