/*  <applet code="Sample161.class" width="310" height="100"></applet> */
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class Sample161 extends Applet 
        implements ActionListener {
    TextField tf = new TextField(20);
    Button bt = new Button("リスト追加");

    // 表示行数を4行に設定してリストオブジェクトを作成
    List lt = new List(4);

    public void init() {
        add(tf);
        add(bt);
        add(lt);
        bt.addActionListener(this);
    }

    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == bt) {
            // リストを追加する
            lt.add("追加リスト");
            tf.setText("リストを追加しました");
        }
    }    
}
