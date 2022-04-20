import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class myPanel3 extends JPanel implements ActionListener {
    int x = 0, y = 0;
    int dx = 1, dy = 1, d = 10;
    Timer pTimer;
    final int width, hight;

    public myPanel3(int w, int h) {
        width = w;
        hight = h;
        pTimer = new Timer(200, this);
    }

    public void start() {
        pTimer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawRect(0, 0, width, hight);
        g.drawArc(x, y, 100, 100, 0, 360);
        g.drawArc(x + 15, y + 15, 70, 70, 0, -180);
        g.drawArc(x + 35, y + 35, 10, 10, 0, 360);
        g.drawArc(x + 60, y + 35, 10, 10, 0, 360);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        x += d * dx;
        y += d * dy;

        if (x < 0) {
            x += d;
            dx *= -1;
        } else if (x > width - 100) {
            x -= d;
            dx *= -1;
        }
        if (y < 0) {
            y += d;
            dy *= -1;
        } else if (y > hight - 100) {
            y -= d;
            dy *= -1;
        }
        repaint();
    }
}

class MovingSmiley extends JFrame {
    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(300, 200);
        f.setTitle("Moving Smiley");
        f.setResizable(false);
        Container contentPane = f.getContentPane();
        myPanel3 p = new myPanel3(300, 150);
        contentPane.add(p);
        p.start();

        f.setVisible(true);
    }
}
