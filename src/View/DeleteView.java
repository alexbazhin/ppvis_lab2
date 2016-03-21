package View;

import Model.Student;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteView {

    public JTextField nameOfStudentField;
    JComboBox omissionsComboBox;
    JTextField upperLimit;
    JTextField lowerLimit;
    JTextField omissionsDiseaseField;
    JTextField numberOfGroupField;
    TableStudents tableModel = new TableStudents(Student.students);

    JTable tableStudents = new JTable(tableModel);

    public DeleteView() {
        super();
    }

    public JDialog createFrame(String name) {
        JDialog dialog = new JDialog();
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

                String typeOmissions = (String) omissionsComboBox.getSelectedItem();

                int column=0;
                if (name != null && group != null) {
                    TableStudents model = new TableStudents(Student.students);
                    for (int i=0; i<tableStudents.getRowCount(); i++) {
                        if (name.equals(tableStudents.getValueAt(i, 0)) && group.equals(tableStudents.getValueAt(i, 1))) {
                            model.removeRow(i);
                            //tableStudents = new JTable(model);
                        }
                    }

                }

                if (name != null && (group == null || group.equals("")) && !typeOmissions.equals("Выберите вид пропуска") && Integer.parseInt(lowerLimit.getText())==0 && Integer.parseInt(upperLimit.getText())==0) {

                    if (typeOmissions.equals("Пропуски по болезни")) {column=2;}
                    if (typeOmissions.equals("Пропуски по другим причинам")) {column=3;}
                    if (typeOmissions.equals("Пропуски без уважительной причины")) {column=4;}

                    for (int i=0; i<tableStudents.getRowCount(); i++) {
                        int value = Integer.parseInt(tableModel.getValueAt(i, column));
                        if (name.equals(tableStudents.getValueAt(i, 0)) && value > 0) {
                            TableStudents model = new TableStudents(Student.students);
                            model.removeRow(i);
                            tableStudents = new JTable(model);
                        }
                    }
                }

                if (name != null && lowerLimit.getText()!=null && upperLimit.getText()!=null && (group == null || group.equals("")) && Integer.parseInt(lowerLimit.getText())>=0 && Integer.parseInt(upperLimit.getText())>0) {

                    if (typeOmissions.equals("Пропуски по болезни")) {column=2;}
                    if (typeOmissions.equals("Пропуски по другим причинам")) {column=3;}
                    if (typeOmissions.equals("Пропуски без уважительной причины")) {column=4;}

                    int lowerLim = Integer.parseInt(lowerLimit.getText());
                    int upperLim = Integer.parseInt(upperLimit.getText());

                    for (int i=0; i<tableStudents.getRowCount(); i++) {
                        if (name.equals(tableStudents.getValueAt(i, 0))) {
                            int value = Integer.parseInt(tableModel.getValueAt(i, column));
                            if (value>lowerLim && value<=upperLim) {
                                TableStudents model = new TableStudents(Student.students);
                                model.removeRow(i);
                                tableStudents = new JTable(model);
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
        mainBox.add(enteringAndGraduate);
        mainBox.add(Box.createHorizontalStrut(12));
        JScrollPane scrollPane = new JScrollPane(tableStudents);

        mainBox.add(scrollPane);
        mainBox.add(ok);

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

    public String getName() {
        return nameOfStudentField.getText();
    }

    public String getGroup() {
        return numberOfGroupField.getText();
    }

    public String getOmissionsDisease() {
        return omissionsDiseaseField.getText();
    }

}
