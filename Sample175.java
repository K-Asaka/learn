/*  <applet code="Sample175.class" width="310" height="100"></applet> */
import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;

public class Sample175 extends Applet implements MouseListener {
    
    Label lb = new Label("画面で右クリックしてください");

    // ポップアップメニューオブジェクトを作成
    PopupMenu pm = new PopupMenu();

    public void init() {
        add(lb);
        MenuItem mi1 = new MenuItem("項目1");
        MenuItem mi2 = new MenuItem("項目2");
        MenuItem mi3 = new MenuItem("項目3");
        pm.add(mi1);
        pm.add(mi2);
        pm.add(mi3);

        // ポップアップメニューをコンポーネントに追加
        add(pm);

        addMouseListener(this);
    }

    public void mousePressed(MouseEvent e) {
        // マウスの右クリックでポップアップメニューを表示
        if ((e.getModifiers() & InputEvent.BUTTON3_MASK) == InputEvent.BUTTON3_MASK) {
            pm.show(this, e.getX(), e.getY());
        }
    }
    public void mouseClicked(MouseEvent e) {
    }
    public void mouseReleased(MouseEvent e) {
    }
    public void mouseEntered(MouseEvent e) {
    }
    public void mouseExited(MouseEvent e) {
    }
}
