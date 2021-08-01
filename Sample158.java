/*  <applet code="Sample158.class" width="310" height="100"></applet> */
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class Sample158 extends Applet 
        implements ActionListener {
    Button bt1 = new Button("ボタン1");
    Button bt2 = new Button("ボタン2");
    Button bt3 = new Button("ボタン3");

    // グリッドバッグレイアウトを定義
    GridBagLayout gbl = new GridBagLayout();

    GridBagConstraints gbc = new GridBagConstraints();

    public void init() {
        // グリッドバッグレイアウトを設定
        setLayout(gbl);

        // コンポーネントを水平方向にサイズ変更する
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // 水平方向の配分方法を1に設定
        gbc.weightx = 1;
        gbl.setConstraints(bt1, gbc);
        bt1.setActionCommand("ボタン1");

        // 水平方向の配分方法を2に指定
        gbc.weightx = 3;
        gbl.setConstraints(bt2, gbc);
        bt2.setActionCommand("ボタン2");

        // 水平方向の配分方法を3に指定
        gbc.weightx = 5;
        gbl.setConstraints(bt3, gbc);
        bt3.setActionCommand("ボタン3");

        add(bt1);
        add(bt2);
        add(bt3);

        bt1.addActionListener(this);
        bt2.addActionListener(this);
        bt3.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        String str = ((Button)e.getSource()).getActionCommand();
        showStatus(str + "をクリックしました");
    }
}
