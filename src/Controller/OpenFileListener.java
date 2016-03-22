package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Lion on 21.03.2016.
 */
public class OpenFileListener implements ActionListener {
    Parser parser;
    public OpenFileListener(Parser parser) {
        this.parser = parser;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        parser.openFile();
    }
}
