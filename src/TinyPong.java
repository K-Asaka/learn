import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Color;

class myPanel4 extends JPanel implements ActionListener, KeyListener {
    int x = 30, y = 20;
    int dx = 1, dy = 1, d = 30;
    int padY = 55;
    int pd = 0;
    Timer pTimer;
    final int width, hight;

    public myPanel4(int w, int h) {
        width = w;
        hight = h;
        setPreferredSize(new Dimension(w, h));
        setBackground(Color.black);
        pTimer = new Timer(100, this);
        addKeyListener(this);
    }

    public void start() {
        pTimer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.white);
        g.fillRect(30, 0, width, 5);
        g.fillRect(width - 5, 0, 5, hight);
        g.fillRect(30, hight - 5, width, 5);

        g.fillOval(x, y, 10, 10);

        g.fillRect(20, padY, 8, 30);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        padY += pd;
        if (padY < 0) {
            padY = 0;
        } else if (padY > hight - 30) {
            padY = hight - 30;
        }

        x += 10 * dx;
        y += 5 * dy;

        if (x > width - 15) {
            dx *= -1;
            x = width - 15;
        }
        if (y < 5) {
            dy *= -1;
            y = 5;
        } else if (y > hight - 15) {
            dy *= -1;
            y = hight - 15;
        }

        if (x < 30) {
            if ((y >= padY) && (y <= padY + 30)) {
                dx *= -1;
                x = 30;
            }
        }
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
        case KeyEvent.VK_UP:
            pd = -10;
            break;
        case KeyEvent.VK_DOWN:
            pd = 10;
            break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
            case KeyEvent.VK_DOWN:
            pd  =0;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) { }

    @Override
    public boolean isFocusable() {
        return true;
    }
}

class TinyPong extends JFrame {
    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new BorderLayout());
        f.setSize(300, 200);
        f.setTitle("TinyPong");
        f.setResizable(false);
        Container contentPane = f.getContentPane();
        myPanel4 p = new myPanel4(300, 150);

        contentPane.add(p, "Center");
        p.start();

        f.setVisible(true);
    }
}
