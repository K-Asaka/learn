/* <applet code="Sample210.class" width="310" height="140"></applet> */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Sample210 extends JApplet implements ActionListener {

    // コンボボックスオブジェクトの作成
    JComboBox cb = new JComboBox();
    
    public void init() {
        cb.addItem("リスト1");
        cb.addItem("リスト2");
        cb.addItem("リスト3");

        cb.addActionListener(this);
        
        Container cp = getContentPane();
        cp.setLayout(new FlowLayout());
        cp.add(cb);
    }

    public void actionPerformed(ActionEvent e) {
        // 選択した項目を取得
        showStatus(cb.getSelectedItem() + " を選択");
    }
}