package Controller;

import View.SearchView;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Lion on 13.03.2016.
 */
public class SearchToolsListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JDialog searchView = new SearchView().createFrame("PPVIS-2");
        searchView.setSize(850, 500);
        searchView.setVisible(true);
        searchView.setLocationRelativeTo(null);
    }
}
