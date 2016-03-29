package Controller;

import Model.Student;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.stream.*;
import java.io.*;
import java.util.List;

public class Parser {

    private JTable table;
    public List<Student> theModel;

    public Parser(List<Student> theModel, JTable table) {
        this.table = table;
        this.theModel = theModel;
    }

    public void saveFile() {
        try {
            JFileChooser fc = new JFileChooser();
            if (fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                XMLOutputFactory output = XMLOutputFactory.newInstance();
                XMLStreamWriter writer = output.createXMLStreamWriter
                        (new FileWriter(fc.getSelectedFile() + "." + "xml"));
                writer.writeStartDocument("UTF-8", "1.0");

                writer.writeStartElement("students");

                for (Student student : Student.students) {
                    writer.writeStartElement("student");
                    writer.writeAttribute("fullName", student.getFullName());
                    writer.writeAttribute("group", student.getGroup());
                    writer.writeAttribute("omissionsDisease", student.getOmissionsDisease());
                    writer.writeAttribute("omissionsOtherCauses", student.getOmissionsOtherCauses());
                    writer.writeAttribute("omissionsWithoutGoodReason", student.getOmissionsWithoutGoodReason());
                    writer.writeAttribute("omissions", student.getOmissions());
                    writer.writeEndElement();
                }
                writer.writeEndElement();
                writer.writeEndDocument();
                writer.flush();
            }
        } catch (Exception eSave) {
            JOptionPane.showMessageDialog
                    (null, "Can't save file", "ERROR", JOptionPane.ERROR_MESSAGE | JOptionPane.OK_OPTION);
        }
    }

    public void openFile() {
        JFileChooser fc = new JFileChooser();
        fc.setFileFilter(new FileNameExtensionFilter(".xml", "xml"));
        if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            String fileName = fc.getSelectedFile().getPath();

            try {
                String fullName="";
                String group="";
                String omissionsDisease="";
                String omissionsOtherCauses="";
                String omissionsWithoutGoodReason="";
                String omissions="";

                XMLStreamReader xmlr = XMLInputFactory.newInstance()
                        .createXMLStreamReader(fileName, new FileInputStream(fileName));
                while (xmlr.hasNext()) {
                    xmlr.next();
                    if (xmlr.isStartElement()) {
                        if (xmlr.getLocalName().equals("student")) {
                            fullName = xmlr.getAttributeValue(null, "fullName");
                            group = xmlr.getAttributeValue(null, "group");
                            omissionsDisease = xmlr.getAttributeValue(null, "omissionsDisease");
                            omissionsOtherCauses = xmlr.getAttributeValue(null, "omissionsOtherCauses");
                            omissionsWithoutGoodReason = xmlr.getAttributeValue(null, "omissionsWithoutGoodReason");
                            omissions = xmlr.getAttributeValue(null, "omissions");
                            Student student = new Student(fullName, group, omissionsDisease, omissionsOtherCauses,
                                    omissionsWithoutGoodReason, omissions + "");
                            Student.students.add(student);
                        }
                    } else if (xmlr.isEndElement()) {
                        if (xmlr.getLocalName().equals("student")) {
                            Student.students.add(new Student(fullName, group, omissionsDisease,
                                    omissionsOtherCauses, omissionsWithoutGoodReason, omissions));
                        }
                    }
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog
                        (null, "Can't open file", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}