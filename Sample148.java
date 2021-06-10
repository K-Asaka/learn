/* <applet code="Sample148.class" width="310" height="100"></applet> */
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
public class Sample148 extends Applet
        implements ActionListener {
    TextField tf = new TextField(15);

    // ラベルの付いたボタンを作成
    Button bt = new Button("クリックしてください");
    
    public void init() {
        add(tf);
        add(bt);
        bt.addActionListener(this);
    }

    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == bt) {
            tf.setText("クリックされました");
        }
    }
}
