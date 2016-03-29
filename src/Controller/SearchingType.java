package Controller;

import Model.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lion on 28.03.2016.
 */
public class SearchingType extends Searching {

    @Override
    public List<Student> search(String name, String group, String typeOmissions, String lower, String upper) {

        List<Student> resultOfSearchStudent = new ArrayList<>();

            for (int i=0; i < Student.students.size(); i++) {
                if (name.equals(Student.students.get(i).getFullName()) && typeOmissions.equals("Пропуски по болезни") && !Student.students.get(i).getOmissionsDisease().equals("0")) {
                    resultOfSearchStudent.add(Student.students.get(i));
                }
                if (name.equals(Student.students.get(i).getFullName()) && typeOmissions.equals("Пропуски по другим причинам") && !Student.students.get(i).getOmissionsOtherCauses().equals("0")) {
                    resultOfSearchStudent.add(Student.students.get(i));
                }
                if (name.equals(Student.students.get(i).getFullName()) && typeOmissions.equals("Пропуски без уважительной причины") && !Student.students.get(i).getOmissionsWithoutGoodReason().equals("0")) {
                    resultOfSearchStudent.add(Student.students.get(i));
                }
            }
        return resultOfSearchStudent;
    }
}
