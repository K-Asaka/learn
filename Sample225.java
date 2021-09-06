import java.awt.*;
import java.io.File;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.filechooser.*;

public class Sample225 extends JFrame implements ActionListener {
    // ファイル選択ダイアログボックスを作成
    JFileChooser fc = new JFileChooser();

    JButton bt = new JButton("ファイル選択ダイアログを表示");
    JTextField tf = new JTextField(30);

    public static void main(String[] args) {
        Sample225 app = new Sample225();
        app.setSize(550, 450);
        app.setVisible(true);
        app.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        app.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public Sample225() {
        Container cp = getContentPane();
        cp.setLayout(new FlowLayout());
        cp.add(bt);
        cp.add(tf);
        bt.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        // ファイル選択ダイアログボックスを呼び出す
        int ret = fc.showOpenDialog(null);

        // 選択したファイルを取得する
        File obj = fc.getSelectedFile();

        // [開く]ボタンがクリックされた時にパスを表示する
        if (ret == JFileChooser.APPROVE_OPTION) {
            tf.setText("パス: " + obj.getPath());
        }
    }
}