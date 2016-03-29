package Controller;

import Model.Student;

import java.util.List;

/**
 * Created by Lion on 28.03.2016.
 */
public abstract class Searching {
    public abstract List<Student> search(String name, String group, String typeOmissions, String lower, String upper);
}
