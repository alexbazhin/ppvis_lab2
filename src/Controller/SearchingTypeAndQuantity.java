package Controller;

import Model.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lion on 28.03.2016.
 */
public class SearchingTypeAndQuantity extends Searching {

    @Override
    public List<Student> search(String name, String group, String typeOmissions, String lower, String upper) {
        int column=0;
        List<Student> resultOfSearchStudent = new ArrayList<>();

            if (typeOmissions.equals("Пропуски по болезни")) {column=2;}
            if (typeOmissions.equals("Пропуски по другим причинам")) {column=3;}
            if (typeOmissions.equals("Пропуски без уважительной причины")) {column=4;}

            int lowerLim = Integer.parseInt(lower);
            int upperLim = Integer.parseInt(upper);

            for (int i=0; i<Student.students.size(); i++) {
                if (name.equals(Student.students.get(i).getFullName())) {
                    int value=0;
                    if (column==2) {
                        value = Integer.parseInt(Student.students.get(i).getOmissionsDisease());
                    }
                    if (column==3) {
                        value = Integer.parseInt(Student.students.get(i).getOmissionsOtherCauses());
                    }
                    if (column==4) {
                        value = Integer.parseInt(Student.students.get(i).getOmissionsWithoutGoodReason());
                    }
                    if (value>lowerLim && value<=upperLim) {
                        resultOfSearchStudent.add(Student.students.get(i));
                    }
                }
            }

        return resultOfSearchStudent;
    }
}
