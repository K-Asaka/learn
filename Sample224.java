/* <applet code="Sample224.class" width="310" height="500"></applet> */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Sample224 extends JApplet implements ActionListener {
    JPanel pl = new JPanel();
    JButton bt = new JButton("色選択ダイアログボックスを開く"); 

    public void init() {
        Container cp = getContentPane();
        cp.setLayout(new FlowLayout());
        cp.add(pl);
        cp.add(bt);

        bt.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        // 色選択ダイアログボックスオブジェクトを表示する
        Color cc =
            JColorChooser.showDialog(
                Sample24.this, "ボタンの背景色を選択", Color.yellow
            );
        
        // 色選択ダイアログボックスで選択した色をボタンの背景色に設定
        bt.setBackground(cc);
    }
}