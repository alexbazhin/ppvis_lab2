package View;

import Controller.SearchingNameGroup;
import Controller.SearchingType;
import Model.Student;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class SearchView {

    public JTextField nameOfStudentField;
    JComboBox omissionsComboBox;
    JTextField upperLimit;
    JTextField lowerLimit;

    JTextField numberOfGroupField;
    //TableStudents tableModel = new TableStudents(Student.students);
    List<Student> resultOfSearchStudent = new ArrayList<>();
    TablePanel tablepanel = new TablePanel(Student.students);

    //JTable tableStudents = new JTable(tableModel);

    public SearchView() {
        super();
    }

    public JDialog createFrame(String name) {
        JDialog dialog = new JDialog();
        Box mainBox = Box.createVerticalBox();
        Box groupBox = Box.createHorizontalBox();
        Box omissionsBox = Box.createHorizontalBox();

        groupBox.add(name());
        groupBox.add(Box.createHorizontalStrut(6));
        groupBox.add(group());

        omissionsBox.add(omissionsOtherCauses());
        omissionsBox.add(Box.createHorizontalStrut(6));
        omissionsBox.add(omissionsWithoutGoodReason());

        JButton ok = new JButton("OK");
        ok.setAlignmentX(JComponent.CENTER_ALIGNMENT);

        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               /* tableStudents.clearSelection();
               List<Integer> list = new OkSearch().searchStudent(getFullName(), getGroup(),
               (String) omissionsComboBox.getSelectedItem(), tableStudents, lowerLimit.getText(),
               upperLimit.getText(), tableModel);
               for (int i=0; i<list.size(); i++) {
                   tableStudents.addRowSelectionInterval(list.get(i), list.get(i));
               }*/
                String name = getFullName();
                String group = getGroup();
                String typeOmissions = (String) omissionsComboBox.getSelectedItem();
                int column=0;

                if (name != null && group != null) {
                    resultOfSearchStudent = new SearchingNameGroup().search(name, group, typeOmissions, lowerLimit.getText(), upperLimit.getText());
                }

                if (name != null && (group == null || group.equals("")) &&
                        !typeOmissions.equals("Выберите вид пропуска") && Integer.parseInt(lowerLimit.getText())==0 &&
                        Integer.parseInt(upperLimit.getText())==0) {
                    resultOfSearchStudent = new SearchingType().search(name, group, typeOmissions, lowerLimit.getText(), upperLimit.getText());

                }

                if (name != null && lowerLimit.getText() != null && upperLimit.getText() != null &&
                        !typeOmissions.equals("Выберите вид пропуска") && Integer.parseInt(lowerLimit.getText())>=0 &&
                        Integer.parseInt(upperLimit.getText())>0) {

                    if (typeOmissions.equals("Пропуски по болезни")) {column=2;}
                    if (typeOmissions.equals("Пропуски по другим причинам")) {column=3;}
                    if (typeOmissions.equals("Пропуски без уважительной причины")) {column=4;}

                    int lowerLim = Integer.parseInt(lowerLimit.getText());
                    int upperLim = Integer.parseInt(upperLimit.getText());

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
                }
                tablepanel.setStudents(resultOfSearchStudent);
                tablepanel.updateTable();
            }
        });

        mainBox.add(groupBox);
        mainBox.add(Box.createVerticalStrut(12));
        mainBox.add(omissions());
        mainBox.add(Box.createVerticalStrut(12));
        mainBox.add(omissionsBox);
        mainBox.add(Box.createHorizontalStrut(12));
        //JScrollPane scrollPane = new JScrollPane(tableStudents);
        mainBox.add(tablepanel);

        JButton cancel = new JButton("Cancel");
        cancel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tablepanel.setStudents(Student.students);
                tablepanel.updateTable();
            }
        });

        Box groupBox1 = Box.createHorizontalBox();
        groupBox1.add(ok);
        groupBox1.add(Box.createHorizontalStrut(6));
        groupBox1.add(cancel);
        mainBox.add(Box.createVerticalStrut(12));

        mainBox.add(groupBox1);
        mainBox.add(Box.createVerticalStrut(12));

        dialog.setContentPane(mainBox);
        dialog.pack();
        dialog.setName(name);

        return dialog;
    }

    private Box group() {
        Box group = Box.createHorizontalBox();
        group.setBorder(new TitledBorder("Номер группы"));
        numberOfGroupField = new JTextField(20);
        group.add(numberOfGroupField);
        return group;
    }

    private Box name() {
        Box fullName = Box.createHorizontalBox();
        fullName.setBorder(new TitledBorder("ФИО студента"));
        nameOfStudentField = new JTextField(20);
        fullName.add(nameOfStudentField);
        return fullName;
    }

    private Box omissionsOtherCauses() {
        Box omissionsOtherCauses = Box.createHorizontalBox();
        omissionsOtherCauses.setBorder(new TitledBorder("Нижний предел"));
        lowerLimit = new JTextField(20);
        lowerLimit.setText("0");
        omissionsOtherCauses.add(lowerLimit);
        return omissionsOtherCauses;
    }

    private Box omissionsWithoutGoodReason() {
        Box omissionsWithoutGoodReason = Box.createHorizontalBox();
        omissionsWithoutGoodReason.setBorder(new TitledBorder("Верхний предел"));

        upperLimit = new JTextField(20);
        upperLimit.setText("0");
        omissionsWithoutGoodReason.add(upperLimit);
        return omissionsWithoutGoodReason;
    }

    private Box omissions() {
        Box omissions = Box.createHorizontalBox();
        omissions.setBorder(new TitledBorder("Вид пропуска"));
        omissionsComboBox = new JComboBox();
        omissionsComboBox.addItem("Выберите вид пропуска");
        omissionsComboBox.addItem("Пропуски по болезни");
        omissionsComboBox.addItem("Пропуски по другим причинам");
        omissionsComboBox.addItem("Пропуски без уважительной причины");
        omissions.add(omissionsComboBox);
        return omissions;
    }

    public String getFullName() {
        return nameOfStudentField.getText();
    }

    public String getGroup() {
        return numberOfGroupField.getText();
    }
}
