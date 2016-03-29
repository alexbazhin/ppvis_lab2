package Controller;

import Model.Student;
import View.MainView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

/**
 * Created by Lion on 12.03.2016.
 */
public class NewFileListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        Iterator<Student> iter = Student.students.iterator();
        while (iter.hasNext()) {
            Student s = iter.next();
            iter.remove();
        }
        MainView.tablepanel.updateTable();
    }
}
