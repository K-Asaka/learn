/*  <applet code="Sample139.class" width="310" height="100"></applet> */
import java.applet.*;
import java.awt.*;
public class Sample139 extends Applet {
    int xp[] = {100, 190, 180, 170, 190, 150, 140};
    int yp[] = { 55,  10,  25,  90,  90,  45,  90};

    public void paint(Graphics g) {
        Polygon pg = new Polygon(xp, yp, yp.length);
        g.drawPolygon(pg);
    }
}
