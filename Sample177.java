import java.awt.*;
import java.awt.event.*;

public class Sample177 extends Frame implements ActionListener {
    Button bt1 = new Button("ファイルを開く");
    Button bt2 = new Button("ファイルを保存");
    TextField tf = new TextField(30);
    FileDialog fd;

    public static void main(String[] args) {
        Sample177 app = new Sample177();
    }

    Sample177() {
        setSize(550, 350);
        setLayout(new FlowLayout());
        add(bt1);
        add(bt2);
        add(tf);
        bt1.addActionListener(this);
        bt2.addActionListener(this);
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bt1) {
            fd = new FileDialog(this, "Open", FileDialog.LOAD);
        } else if (e.getSource() == bt2) {
            fd = new FileDialog(this, "Save", FileDialog.SAVE);
        }
        fd.setVisible(true);
        tf.setText("選択したファイル : " + fd.getFile());
    }
}
