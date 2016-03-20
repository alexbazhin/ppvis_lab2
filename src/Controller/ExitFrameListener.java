package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Lion on 12.03.2016.
 */
public class ExitFrameListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
}
