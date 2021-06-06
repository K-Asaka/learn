import java.awt.*;
import java.awt.event.*;

public class Sample120 extends Frame {
    public static void main(String[] args) {
        Sample120 app = new Sample120();
    }

    public Sample120() {
        setSize(250, 100);
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public void paint(Graphics g) {
        g.drawString("Hello Java AWT!", 10, 60);
    }
}
