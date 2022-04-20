import javax.swing.JFrame;
import java.awt.Container;
import javax.swing.JButton;
import java.awt.GridLayout;

class GridLayoutTest extends JFrame {
    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(200, 100);

        Container c = f.getContentPane();
        c.setLayout(new GridLayout(2, 1));
        JButton b1 = new JButton("Push!");
        JButton b2 = new JButton("me");
        JButton b3 = new JButton("Please.");
        c.add(b1);
        c.add(b2);
        c.add(b3);

        f.setVisible(true);
    }
}
