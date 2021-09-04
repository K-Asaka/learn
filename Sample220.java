/* <applet code="Sample220.class" width="310" height="100"></applet> */
import java.awt.*;
import javax.swing.*;

public class Sample220 extends JApplet {    
    public void init() {
        // 進捗バーオブジェクトを作成
        JProgressBar pb1 = new JProgressBar();
        // 現在地を設定
        pb1.setValue(50);

        JProgressBar pb2 = new JProgressBar();
        pb2.setValue(80);
        // 前景色を青に設定
        pb2.setForeground(Color.blue);
        // ラベルを表示する
        pb2.setStringPainted(true);
        // 境界線を設定
        pb2.setBorder(BorderFactory.createRaisedBevelBorder());

        Container cp = getContentPane();
        cp.setLayout(new FlowLayout());
        cp.add(pb1);
        cp.add(pb2);
    }
}