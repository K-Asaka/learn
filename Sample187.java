/* <applet code="Sample187.class" width="310" height="100"></applet> */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Sample187 extends JApplet {
    // パスワード設定
    String pass = "1234";

    // パスワードフィールドオブジェクト作成
    JPasswordField pf = new JPasswordField(4);

    JTextField tf = new JTextField("パスワードを入力してください", 16);

    public void init() {
        Container cp = getContentPane();
        cp.setLayout(new FlowLayout());
        cp.add(pf);
        cp.add(tf);

        // パスワード表示文字を設定
        pf.setEchoChar('*');

        pf.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 入力したパスワードを取得
                String str = new String(pf.getPassword());

                // パスワードチェック
                if (pass.equals(str)) {
                    tf.setText("正しいパスワードです");
                } else {
                    tf.setText("不正なパスワードです");
                }
            }
        });
    }
}
