/*  <applet code="Sample157.class" width="310" height="100"></applet> */
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class Sample157 extends Applet
        implements ActionListener {
    int index = 1;

    // カードレイアウトを定義
    CardLayout cl = new CardLayout();

    public void init() {
        Panel cd1 = new Panel();
        Panel cd2 = new Panel();
        Label lb1 = new Label("1枚目のカード");
        Label lb2 = new Label("2枚目のカード");
        Button bt1 = new Button("2枚目のカードを表示");
        Button bt2 = new Button("1枚目のカードを表示");

        // カードレイアウトを設定
        setLayout(cl);

        // パネルに1枚目のカードを設定
        cd1.add(lb1);
        cd1.add(bt1);

        // パネルに2枚目のカードを設定
        cd2.add(lb2);
        cd2.add(bt2);

        // パネルをコンポーネントに追加
        add("first", cd1);
        add("second", cd2);

        bt1.addActionListener(this);
        bt2.addActionListener(this);
    }

    public void actionPerformed(ActionEvent event) {
        switch (++index) {
        case 1:
            cl.show(this, "first");
            break;
        case 2:
            cl.show(this, "second");
            break;
        }
        if (index == 2) {
            index = 0;
        }
    }
    
}
