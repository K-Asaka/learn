/*  <applet code="Sample138.class" width=310" height="100"></applet> */
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;
import java.applet.Applet;
public class Sample138 extends Applet
        implements MouseListener {
    
    Point pt1;
    Point pt2;
    boolean bool = false;

    public void init() {
        addMouseListener(this);
    }

    public void paint(Graphics g) {
        g.drawString("角が丸い四角形を描画する", 10, 60);

        if (bool) {
            int width = pt2.x - pt1.x;
            int height = pt2.y - pt1.y;
            g.drawRoundRect(pt1.x, pt1.y, width, height, 10, 10);
        }
    }

    public void mousePressed(MouseEvent e) {
        bool = false;
        pt1 = new Point(e.getX(), e.getY());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        pt2 = new Point(Math.max(e.getX(), pt1.x), Math.max(e.getY(), pt1.y));
        pt1 = new Point(Math.min(e.getX(), pt1.x), Math.min(e.getY(), pt1.y));
        bool = true;
        repaint();
    }

    public void mouseClicked(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void actionPerformed(ActionEvent e) {}
}