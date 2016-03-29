package View;

import Model.Student;

import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.*;
import java.util.List;


public class TablePanel extends JPanel {
    private List<Student> students;
    private int currentPage = 1;
    private int countStudentsOnPage = 10;

    public TablePanel(List<Student> students) {
        this.students = students;
        setLayout(new BorderLayout());
        add(new JScrollPane(makeTable(students)));
        add(makeToolBar(), BorderLayout.SOUTH);
    }

    public TablePanel() {
        this.students = new ArrayList<>();
        setLayout(new BorderLayout());
        add(new JScrollPane(makeTable(students)));
        add(makeToolBar(), BorderLayout.SOUTH);
    }

    public JTable makeTable(List<Student> students) {
        JTable table = new JTable(new Object[countStudentsOnPage][6], new Object[]{"ФИО", "Группа",
                "по болезни", "по другим причинам", "без уважительной причины", "Итого"});

        table.setEnabled(false);
        int firstTrainOnPage = countStudentsOnPage * (currentPage - 1);
        for (int x = 0, student = firstTrainOnPage; x < countStudentsOnPage && student < students.size(); x++, student++) {
            table.setValueAt(students.get(student).getFullName(), x, 0);
            table.setValueAt(students.get(student).getGroup(), x, 1);
            table.setValueAt(students.get(student).getOmissionsDisease(), x, 2);
            table.setValueAt(students.get(student).getOmissionsOtherCauses(),
                    x, 3);
            table.setValueAt(students.get(student).getOmissionsWithoutGoodReason(),
                    x, 4);
            table.setValueAt(students.get(student).getOmissions(),
                    x, 5);
        }
        table.setColumnSelectionAllowed(true);
        table.setRowSelectionAllowed(true);
        return table;
    }

    public JPanel makeTablePanel(){
        JPanel table = new JPanel();
        table.setLayout(new GridBagLayout());
        int numberExaminations = 10;
       // List<Student> students = tableModel.getStudents();
        AddComponent.add(table, "Full Name", 0, 1, 1, 3);
        AddComponent.add(table, "Group", 1, 1, 1, 3);
        AddComponent.add(table, "Examinations", 2, 1, 10 * 2, 1);
        for (int i = 0, x = 2; i < numberExaminations; i++, x += 2) {
            AddComponent.add(table, Integer.toString(i + 1), x, 2, 2, 1);
            AddComponent.add(table, "name", x, 3, 1, 1);
            AddComponent.add(table, "mark", x + 1, 3, 1, 1);
        }
        int firstStudentOnPage = countStudentsOnPage * (currentPage - 1);
        for (int y = 4, student = firstStudentOnPage; y < countStudentsOnPage + 4 && student < students.size(); y++, student++) {
            //tableModel.setNumberMaxExaminations(students.get(student).getExaminations().size());
            for (int i = 0; i < numberExaminations * 2 + 2; i++) {
               // String write = students.get(student).getField(i);
               // AddComponent.add(table, write, i, y, 1, 1);
            }
        }
        return table;
    }

    private JPanel makeToolBar() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        String statusBar = "Страница " + currentPage + "/" + getNumberMaxPage();
        panel.add(new JLabel(statusBar));
        JButton firstButton = new JButton("Первая");
        panel.add(firstButton);
        firstButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentPage > 1) {
                    currentPage = 1;
                    updateTable();
                }
            }
        });
        JButton prevButton = new JButton("Предыдущая");
        panel.add(prevButton);
        prevButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentPage > 1) {
                    currentPage--;
                    updateTable();
                }
            }
        });
        JButton nextButton = new JButton("Следующая");
        panel.add(nextButton);
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (students.size() > countStudentsOnPage * (currentPage - 1) + countStudentsOnPage) {
                    currentPage++;
                    updateTable();
                }
            }
        });
        JButton lastButton = new JButton("Последняя");
        panel.add(lastButton);
        lastButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentPage != getNumberMaxPage()) {
                    currentPage = getNumberMaxPage();
                    updateTable();
                }
            }
        });

        JLabel label = new JLabel(" Строк на странице: ");
        panel.add(label);
        String[] sizeStudent = {"10", "20", "30", "50", "100"};
        JComboBox<String> sizeBox = new JComboBox<String>(sizeStudent);
        sizeBox.setSelectedIndex(Arrays.asList(sizeStudent).indexOf(Integer.toString(countStudentsOnPage)));
        sizeBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String change = (String) sizeBox.getSelectedItem();
                if (countStudentsOnPage != Integer.parseInt(change)) {
                    countStudentsOnPage = Integer.parseInt(change);
                    updateTable();
                }
            }
        });
        panel.add(sizeBox);
        return panel;
    }

    private int getNumberMaxPage() {
        return ((students.size() - 1) / countStudentsOnPage) + 1;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void updateTable() {
        removeAll();
        updateUI();
        add(new JScrollPane(makeTable(students)));
        add(makeToolBar(), BorderLayout.SOUTH);
        revalidate();
        repaint();
    }
}
