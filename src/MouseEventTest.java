import java.awt.Container;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.JFrame;

class MouseEventTest extends JFrame implements MouseListener {
    Container c;

    public MouseEventTest() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Mouse Event Test");
        setSize(400, 300);
        c = getContentPane();
        addMouseListener(this);
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {
        c.setBackground(Color.black);
        repaint();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        c.setBackground(Color.white);
        repaint();
    }

    public static void main(String[] args) {
        MouseEventTest met = new MouseEventTest();

        met.setVisible(true);
    }
}
