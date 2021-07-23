/*  <applet code="Sample152.class" width="310" height="100"></applet> */
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class Sample152 extends Applet
        implements ItemListener {
    // チェックボックスグループを作成
    CheckboxGroup cbg = new CheckboxGroup();

    // チェックボックスグループのオブジェクトを
    // コンストラクタに指定してチェックボックスを作成
    Checkbox rb1 = new Checkbox("C", false, cbg);
    Checkbox rb2 = new Checkbox("JAVA", false, cbg);
    Checkbox rb3 = new Checkbox("BASIC", false, cbg);
    Checkbox rb4 = new Checkbox("COBOL", false, cbg);
    TextField tf = new TextField(20);
    
    public void init() {
        add(rb1);
        add(rb2);
        add(rb3);
        add(rb4);
        add(tf);

        rb1.addItemListener(this);
        rb2.addItemListener(this);
        rb3.addItemListener(this);
        rb4.addItemListener(this);
    }

    public void itemStateChanged(ItemEvent e) {
        String str = ((Checkbox)e.getItemSelectable()).getLabel();
        tf.setText(str + " が選択されました");
    }
}
