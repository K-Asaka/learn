/*  <applet code="Sample143.class" width="310" height="100"></applet> */
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
public class Sample143 extends Applet {
    public void init() {
        // 指定の列数を使用して空のテキストフィールドを作成
        TextField tf1 = new TextField(5);
        // 指定の文字列を使用してテキストフィールドを作成
        TextField tf2 = new TextField("Hello Text!");
        // 指定の文字列と列数を使用してテキストフィールドを作成
        TextField tf3 = new TextField("Hello Text!", 20);
        // 作成したオブジェクトをコンテナに追加
        add(tf1);
        add(tf2);
        add(tf3);
    }
}
