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
                System.out.println(name);
                if (name.equals(Student.students.get(i).getFullName()) && typeOmissions.equals("�������� �� �������") && !Student.students.get(i).getOmissionsDisease().equals("0")) {
                    System.out.println(Student.students.get(i).getOmissionsDisease());
                    resultOfSearchStudent.add(Student.students.get(i));
                }
                if (name.equals(Student.students.get(i).getFullName()) && typeOmissions.equals("�������� �� ������ ��������") && !Student.students.get(i).getOmissionsOtherCauses().equals("0")) {
                    //System.out.println(Student.students.get(i).getOmissionsDisease());
                    resultOfSearchStudent.add(Student.students.get(i));
                }
                if (name.equals(Student.students.get(i).getFullName()) && typeOmissions.equals("�������� ��� ������������ �������") && !Student.students.get(i).getOmissionsWithoutGoodReason().equals("0")) {
                    resultOfSearchStudent.add(Student.students.get(i));
                }
            }

        return resultOfSearchStudent;
    }
}
