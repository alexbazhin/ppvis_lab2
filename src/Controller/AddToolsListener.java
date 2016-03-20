package Controller;

import View.AddView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Lion on 13.03.2016.
 */
public class AddToolsListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        JFrame addView = new AddView().createFrame("PPVIS-2");
        addView.setSize(850, 500);
        addView.setVisible(true);
        addView.setLocationRelativeTo(null);

    }
}
