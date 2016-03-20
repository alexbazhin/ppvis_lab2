import View.MainView;
import javax.swing.*;

/**
 * Created by Lion on 12.03.2016.
 */
public class Main {
    public static void main(String[] args) {
        JFrame mainWindow = new MainView().createFrame("PPVIS-2");
        mainWindow.setSize(850, 500);
        mainWindow.setVisible(true);
        mainWindow.setLocationRelativeTo(null);
    }
}
