package View;

import Model.Student;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteView {

    public JTextField nameOfStudentField;
    JComboBox omissionsComboBox;
    JComboBox upperLimit;
    JComboBox lowerLimit;
    JTextField omissionsDiseaseField;
    JTextField numberOfGroupField;
    TableStudents model = new TableStudents(Student.students);

    JTable tableStudents = new JTable(model);

    public DeleteView() {
        super();
    }

    public JFrame createFrame(String name) {
        JFrame frame = new JFrame();
        Box mainBox = Box.createVerticalBox();
        Box nameAndBirth = Box.createHorizontalBox();
        Box enteringAndGraduate = Box.createHorizontalBox();

        nameAndBirth.add(name());
        nameAndBirth.add(Box.createHorizontalStrut(6));
        nameAndBirth.add(group());

        enteringAndGraduate.add(omissionsOtherCauses());
        enteringAndGraduate.add(Box.createHorizontalStrut(6));
        enteringAndGraduate.add(omissionsWithoutGoodReason());

        JButton ok = new JButton("OK");
        ok.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = getName();
                String group = getGroup();
                String omissionsDisease = getOmissionsDisease();
                /*String omissionsOtherCauses = getOmissionsOtherCauses();
                String omissionsWithoutGoodReasonField = getOmissionsWithoutGoodReason();*/
                /*String omissions = getOmissions();*/

                if (name!=null && group!=null) {
                    for (int i=0; i<tableStudents.getRowCount(); i++) {
                        if (name.equals(tableStudents.getValueAt(i, 0)) && group.equals(tableStudents.getValueAt(i, 1))) {
                            Student student = new Student("", "", "", "", "", "");
                            Student.students.set(i,student);
                            /*model.removeRow(i);*/
                            model.model(Student.students);
                            TableStudents model = new TableStudents(Student.students);

                            tableStudents = new JTable(model);
                            /*tableStudents.removeRowSelectionInterval(i,i);*/
                            for (i=0; i<Student.students.size(); i++) {
                                System.out.println(Student.students.get(i).getFullName());
                            }
                        }
                    }

                }

                if (name != null && group == null) {
                    String typeOmissions = (String) omissionsComboBox.getSelectedItem();
                    int column=0;

                    if (typeOmissions.equals("Пропуски по болезни")) {column=2;}
                    if (typeOmissions.equals("Пропуски по другим причинам")) {column=3;}
                    if (typeOmissions.equals("Пропуски без уважительной причины")) {column=4;}

                    for (int i=0; i<tableStudents.getRowCount(); i++) {
                        if (name.equals(tableStudents.getValueAt(i, 0))) {
                            tableStudents.setColumnSelectionInterval(0, column);
                            tableStudents.setRowSelectionInterval(i, i);
                        }
                    }

                }

                if (name != null && group == null) {

                    String typeOmissions = (String) omissionsComboBox.getSelectedItem();
                    int column=0;

                    if (typeOmissions.equals("Пропуски по болезни")) {column=2;}
                    if (typeOmissions.equals("Пропуски по другим причинам")) {column=3;}
                    if (typeOmissions.equals("Пропуски без уважительной причины")) {column=4;}

                    int lowerLim = (Integer) lowerLimit.getSelectedItem();
                    int upperLim = (Integer) upperLimit.getSelectedItem();

                    for (int i=0; i<tableStudents.getRowCount(); i++) {
                        if (name.equals(tableStudents.getValueAt(i, 0))) {
                            int value = (Integer) tableStudents.getValueAt(i, column);
                            if (value>lowerLim && value<upperLim) {
                                tableStudents.setColumnSelectionInterval(0, column);
                                tableStudents.setRowSelectionInterval(i, i);
                            }
                        }
                    }
                }
            }
        });

        mainBox.add(nameAndBirth);
        mainBox.add(Box.createVerticalStrut(12));
        mainBox.add(omissions());
        mainBox.add(Box.createVerticalStrut(12));
        mainBox.add(omissionsDisease());
        mainBox.add(Box.createVerticalStrut(12));
        mainBox.add(enteringAndGraduate);
        mainBox.add(Box.createHorizontalStrut(12));
        JScrollPane scrollPane = new JScrollPane(tableStudents);

        mainBox.add(scrollPane);
        mainBox.add(ok);

        frame.setContentPane(mainBox);
        frame.pack();
        frame.setName(name);

        return frame;
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

    private Box omissionsDisease() {
        Box omissionsDisease = Box.createHorizontalBox();
        omissionsDisease.setBorder(new TitledBorder("Пропуски по болезни"));
        omissionsDiseaseField = new JTextField(20);
        omissionsDisease.add(omissionsDiseaseField);
        return omissionsDisease;
    }

    private Box omissionsOtherCauses() {
        Box omissionsOtherCauses = Box.createHorizontalBox();
        omissionsOtherCauses.setBorder(new TitledBorder("Нижний предел"));

        String[] items = new String[30];
        for (int i=0; i<30; i++) {
            items[i]=Integer.toString(i);
        }
        lowerLimit = new JComboBox(items);

        omissionsOtherCauses.add(lowerLimit);
        return omissionsOtherCauses;
    }

    private Box omissionsWithoutGoodReason() {
        Box omissionsWithoutGoodReason = Box.createHorizontalBox();
        omissionsWithoutGoodReason.setBorder(new TitledBorder("Верхний предел"));
        String[] items = new String[30];
        for (int i=0; i<30; i++) {
            items[i]=Integer.toString(i);
        }
        upperLimit = new JComboBox(items);
        omissionsWithoutGoodReason.add(upperLimit);
        return omissionsWithoutGoodReason;
    }

    private Box omissions() {
        Box omissions = Box.createHorizontalBox();
        omissions.setBorder(new TitledBorder("Вид пропуска"));
        omissionsComboBox = new JComboBox();
        omissionsComboBox.addItem("Пропуски по болезни");
        omissionsComboBox.addItem("Пропуски по другим причинам");
        omissionsComboBox.addItem("Пропуски без уважительной причины");
        omissions.add(omissionsComboBox);
        return omissions;
    }

    public String getName() {
        return nameOfStudentField.getText();
    }

    public String getGroup() {
        return numberOfGroupField.getText();
    }

    public String getOmissionsDisease() {
        return omissionsDiseaseField.getText();
    }

   /* public String getOmissionsOtherCauses() {
        return omissionsOtherCausesField.getText();
    }

    public String getOmissionsWithoutGoodReason() {
        return omissionsWithoutGoodReasonField.getText();
    }*/

   /* public String getOmissions() {
      *//*  return omissionsField.getText();*//*
    }*/
}
