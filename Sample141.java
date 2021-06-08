/*  <applet code="Sample141.class" width="310" height="100"></applet> */
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;
import java.applet.Applet;
public class Sample141 extends Applet
        implements MouseListener, MouseMotionListener {
    
    Point pt1;
    Point pt2;
    Point apt[] = new Point[500];
    int ipt = 0;
    boolean bool = false;

    public void init() {
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    public void paint(Graphics g) {
        g.drawString("自由曲線を描画する", 10, 60);

        if (bool) {
            int width = pt2.x - pt1.x;
            int height = pt2.y - pt1.y;

            // 点の情報をまとめて描画すると曲線が表現される
            for (int i = 0; i < ipt - 1; i++) {
                g.drawLine(apt[i].x, apt[i].y, apt[i + 1].x, apt[i + 1].y);
            }
        }
    }

    public void mousePressed(MouseEvent e) {
        bool = false;
        pt1 = new Point(e.getX(), e.getY());
    }

    public void mouseReleased(MouseEvent e) {
        pt2 = new Point(Math.max(e.getX(), pt1.x), Math.max(e.getY(), pt1.y));
        pt1 = new Point(Math.min(e.getX(), pt1.x), Math.min(e.getY(), pt1.y));
        bool = true;
        repaint();
    }

    public void mouseClicked(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}

    // ドラッグ中の点の情報を配列に格納する
    public void mouseDragged(MouseEvent e) {
        apt[ipt] = new Point(e.getX(), e.getY());
        ipt++;
        repaint();
    }

    public void mouseMoved(MouseEvent e) {}

}