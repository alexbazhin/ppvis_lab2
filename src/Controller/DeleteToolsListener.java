package Controller;

import View.DeleteView;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Lion on 13.03.2016.
 */
public class DeleteToolsListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JFrame deleteView = new DeleteView().createFrame("PPVIS-2");
        deleteView.setSize(850, 500);
        deleteView.setVisible(true);
        deleteView.setLocationRelativeTo(null);

    }
}
