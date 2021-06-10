/*  <applet code="Sample149.class" width="310" height="100"></applet> */
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
public class Sample149 extends Applet
        implements ActionListener {

    TextField tf = new TextField(19);
    Button bt = new Button("取得したいボタンのラベル");

    public void init() {
        add(tf);
        add(bt);
        bt.addActionListener(this);
    }

    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == bt) {
            // ボタンのラベルを取得する
            tf.setText(bt.getLabel());
        }
    }
    
}
