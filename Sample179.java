import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Sample179 extends JFrame {
    public static void main(String[] args) {
        Sample179 app = new Sample179();
        app.setSize(250, 100);
        app.setVisible(true);

        app.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        app.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public Sample179() {
        Container contentPane = getContentPane();
        JLabel lb = new JLabel("Hello Java SWING!");
        contentPane.add(lb);
    }
}
