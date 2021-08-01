/*  <applet code="Sample159.class" width="310" height="100"></applet> */
import java.applet.Applet;
import java.awt.*;

public class Sample159 extends Applet {
    public void init() {
        // 4つのパネルオブジェクトを作成
        bpl pl1 = new bpl();
        bpl pl2 = new bpl();
        bpl pl3 = new bpl();
        bpl pl4 = new bpl();

        // 2行×2列のグリッドレイアウトを設定
        setLayout(new GridLayout(2, 2));

        // 4つのパネルオブジェクトを追加
        add(pl1);
        add(pl2);
        add(pl3);
        add(pl4);
    }
}

// 3つのテキストフィールドを追加したパネルクラスを定義
class bpl extends Panel {
    bpl() {
        TextField tf1 = new TextField("①");
        TextField tf2 = new TextField("②");
        TextField tf3 = new TextField("③");

        add(tf1);
        add(tf2);
        add(tf3);
    }
}