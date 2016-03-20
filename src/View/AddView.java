package View;

import Model.Student;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddView {

    public JTextField nameOfStudentField;
    JTextField omissionsField;
    JTextField omissionsWithoutGoodReasonField;
    JTextField omissionsOtherCausesField;
    JTextField omissionsDiseaseField;
    JTextField numberOfGroupField;

    public AddView() {
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
                String omissionsOtherCauses = getOmissionsOtherCauses();
                String omissionsWithoutGoodReasonField = getOmissionsWithoutGoodReason();
                String omissions = getOmissions();
                Student student = new Student(name, group, omissionsDisease, omissionsOtherCauses, omissionsWithoutGoodReasonField, omissions);
                Student.students.add(student);
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
        omissionsOtherCauses.setBorder(new TitledBorder("Пропуски по другим причинам"));
        omissionsOtherCausesField = new JTextField(20);
        omissionsOtherCauses.add(omissionsOtherCausesField);
        return omissionsOtherCauses;
    }

    private Box omissionsWithoutGoodReason() {
        Box omissionsWithoutGoodReason = Box.createHorizontalBox();
        omissionsWithoutGoodReason.setBorder(new TitledBorder("Пропуски без уважительной причины"));
        omissionsWithoutGoodReasonField = new JTextField(20);
        omissionsWithoutGoodReason.add(omissionsWithoutGoodReasonField);
        return omissionsWithoutGoodReason;
    }

    private Box omissions() {
        Box omissions = Box.createHorizontalBox();
        omissions.setBorder(new TitledBorder("Все пропуски"));
        omissionsField = new JTextField(20);
        omissions.add(omissionsField);
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

    public String getOmissionsOtherCauses() {
        return omissionsOtherCausesField.getText();
    }

    public String getOmissionsWithoutGoodReason() {
        return omissionsWithoutGoodReasonField.getText();
    }

    public String getOmissions() {
        return omissionsField.getText();
    }
}