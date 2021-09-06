import java.awt.*;
import java.io.File;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.filechooser.*;

public class Sample226 extends JFrame implements ActionListener {
    JFileChooser fc = new JFileChooser();
    JButton bt = new JButton("ファイル選択ダイアログを表示(フィルタ付き)");
    JTextField tf = new JTextField(30);

    public static void main(String[] args) {
        Sample226 app = new Sample226();
        app.setSize(550, 450);
        app.setVisible(true);
        app.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        app.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public Sample226() {
        Container cp = getContentPane();
        cp.setLayout(new FlowLayout());
        cp.add(bt);
        cp.add(tf);
        bt.addActionListener(this);

        // ファイル選択ダイアログボックスに
        // ファイル選択フィルタを追加する
        fc.addChoosableFileFilter(new ff());
    }

    public void actionPerformed(ActionEvent e) {
        int ret = fc.showOpenDialog(null);
        File obj = fc.getSelectedFile();
        if (ret == JFileChooser.APPROVE_OPTION) {
            tf.setText("パス: " + obj.getPath());
        }
    }
}

// ファイル選択フィルタを作成
class ff extends javax.swing.filechooser.FileFilter {
    // 「java」という拡張子を持つファイルを検索する
    public boolean accept(File obj) {
        String fil = "";
        if (obj.getPath().lastIndexOf('.') > 0) {
            fil = obj.getPath().substring(
                obj.getPath().lastIndexOf('.') + 1
            ).toLowerCase();
        }

        if (fil != "") {
            return fil.equals("java");
        } else {
            return obj.isDirectory();
        }
    }

    // ファイル選択ダイアログボックスの
    // ファイルタイプに表示する文字列
    public String getDescription() {
        return "Java Files (*.java)";
    }
}