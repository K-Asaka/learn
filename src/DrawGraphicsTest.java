import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Container;
import java.awt.Graphics;

class myPanel2 extends JPanel {
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawArc(75, 50, 100, 100, 0, 360);
        g.drawArc(90, 65, 70, 70, 0, -180);
        g.drawArc(105, 85, 10, 10, 0, 360);
        g.drawArc(135, 85, 10, 10, 0, 360);
    }
}

class DrawGraphicsTest extends JFrame {
    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(300, 200);
        Container contentPane = f.getContentPane();
        myPanel2 p = new myPanel2();
        contentPane.add(p);

        f.setVisible(true);
    }
}
