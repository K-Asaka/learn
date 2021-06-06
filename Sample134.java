/*  <applet code="Sample134.class" width="310" height="100"></applet> */
import java.awt.*;
import java.applet.*;
public class Sample134 extends Applet {
    Image ig;

    public void init() {
        // イメージファイルを取得
        ig = getImage(getDocumentBase()."Sample.jpg");
    }

    public void paint(Graphics g) {
        // イメージファイルを表示
        g.drawImage(ig, 10, 10, this);
    }
}
