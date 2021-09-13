/* <applet code="Sample245" width="310" height="100"></applet> */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Sample245 extends JApplet {
    // エディタペインオブジェクトを作成
    JEditorPane ep = new JEditorPane();

    JButton bt = new JButton("エディタペインのテキストを取得");

    public Sample245() {
        ep.setEditable(true);

        // テキストを設定
        ep.setText("エディタペイン");

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(new JScrollPane(ep), BorderLayout.CENTER);
        cp.add(bt, BorderLayout.SOUTH);

        bt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // テキストを取得
                showStatus(ep.getText());
            }
        });
    }
}
