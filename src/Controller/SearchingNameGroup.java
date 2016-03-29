package Controller;

import Model.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lion on 28.03.2016.
 */
public class SearchingNameGroup extends Searching {

    @Override
    public List<Student> search(String name, String group, String typeOmissions, String lower, String upper) {
        List<Student> resultOfSearchStudent = new ArrayList<>();
            for (int i=0; i<Student.students.size(); i++) {
                if (name.equals(Student.students.get(i).getFullName()) &&
                        group.equals(Student.students.get(i).getGroup())) {
                    resultOfSearchStudent.add(Student.students.get(i));
                }
            }

        return resultOfSearchStudent;
    }
}
