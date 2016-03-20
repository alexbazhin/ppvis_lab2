package Controller;

import View.AddView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Lion on 19.03.2016.
 */
public class OkAddListener implements ActionListener {
    AddView addView;
    public OkAddListener(AddView view) {
        addView=view;
   }
    public OkAddListener() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {


    }
}
