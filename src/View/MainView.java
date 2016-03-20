package View;

import Controller.*;
import Model.Student;

import javax.swing.*;

/**
 * Created by Lion on 12.03.2016.
 */
public class MainView {
    JMenuBar menu;

    JMenu fileMenu;
    JMenuItem newFile;
    JMenuItem openFile;
    JMenuItem exitFrame;

    JMenu toolsMenu;
    JMenuItem searchTools;
    JMenuItem deleteTools;
    JMenuItem addTools;
    JTable tableStudents = new JTable(new TableStudents(Student.students));

    public MainView() {
        super();
    }

    public JFrame createFrame(String name) {
        JFrame frame = new JFrame();

        menu = new JMenuBar();
        menu.add(fileMenu());
        menu.add(toolsMenu());

        frame.setJMenuBar(menu);
        JScrollPane scrollPane = new JScrollPane(tableStudents);

        frame.add(scrollPane);
        frame.pack();
        frame.setName(name);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return frame;
    }

    private JMenu fileMenu() {
        fileMenu = new JMenu("File");
        newFile = new JMenuItem("New");
        fileMenu.add(newFile);
        openFile = new JMenuItem("Open");
        fileMenu.add(openFile);
        exitFrame = new JMenuItem("Exit");
        fileMenu.add(exitFrame);

        newFile.addActionListener(new NewFileListener());
        exitFrame.addActionListener(new ExitFrameListener());

        return fileMenu;
    }

    private JMenu toolsMenu() {
        toolsMenu = new JMenu("Tools");
        addTools = new JMenuItem("Add");
        toolsMenu.add(addTools);
        searchTools = new JMenuItem("Search");
        toolsMenu.add(searchTools);
        deleteTools = new JMenuItem("Delete");
        toolsMenu.add(deleteTools);

        addTools.addActionListener(new AddToolsListener());
        searchTools.addActionListener(new SearchToolsListener());
        deleteTools.addActionListener(new DeleteToolsListener());

        return toolsMenu;
    }
}
