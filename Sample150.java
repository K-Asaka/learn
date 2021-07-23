/*  <applet code="Sample150.class" width="310" height="100"></applet> */
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class Sample150 extends Applet 
        implements ActionListener {
    TextField tf = new TextField("設定したいラベル", 15);
    Button bt = new Button("ラベルが変更されます");

    public void init() {
        add(tf);
        add(bt);
        bt.addActionListener(this);
    }

    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == bt) {
            // ボタンのラベルをセットする
            bt.setLabel(tf.getText());
        }
    }    
}
