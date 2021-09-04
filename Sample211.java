/* <applet code="Sample211.class" width="310" height="140"></applet> */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Sample211 extends JApplet implements ActionListener {

    JComboBox cb = new JComboBox();
    JTextField tf = new JTextField(20);
    
    public void init() {
        cb.addItem("リスト1");
        cb.addItem("リスト2");
        cb.addItem("リスト3");

        // コンボボックスのテキストフィールドを編集可能にする
        cb.setEditable(true);

        // 編集イベントを取得する
        cb.getEditor().addActionListener(this);
        
        Container cp = getContentPane();
        cp.setLayout(new FlowLayout());
        cp.add(tf);
        cp.add(cb);
    }

    public void actionPerformed(ActionEvent e) {
        // コンボボックスのテキストフィールドの値を取得する
        String str = "";
        str += cb.getEditor().getItem();
        str += " を入力しました";
        tf.setText(str);
    }
}