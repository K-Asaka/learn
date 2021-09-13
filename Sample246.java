import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class Sample246 extends JFrame {
    public static void main(String[] args) {
        Sample246 app = new Sample246();
        app.setSize(250, 200);
        app.setVisible(true);
        app.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        app.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public Sample246() {
        JEditorPane ep = new JEditorPane();
        ep.setEditable(false);

        try {
            // 表示対象のURLを設定する
            ep.setPage("https://www.google.co.jp/");
        } catch (IOException e) {
            ep.setContentType("text/html");
            ep.setText("指定したページは見つかりませんでした");
        }

        JScrollPane sp = new JScrollPane(ep);
        Container cp = getContentPane();
        cp.add(sp);
    }
}
