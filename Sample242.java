/* <applet code="Sample242" width="310" height="150"></applet> */
import java.awt.*;
import javax.swing.*;
import javax.swing.tree.*;

public class Sample242 extends JApplet {

    public void init() {
        // ツリーのルート項目rootを作成
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("root");

        // rootに項目tr1を追加
        DefaultMutableTreeNode tr1 = new DefaultMutableTreeNode("①");
        root.add(tr1);

        // tr1に項目tr11を追加
        DefaultMutableTreeNode tr11 = new DefaultMutableTreeNode("①-①");
        tr1.add(tr11);

        // tr11に項目tr111を追加
        DefaultMutableTreeNode tr111 = new DefaultMutableTreeNode("①-①-①");
        tr11.add(tr111);

        // tr11に項目tr112を追加
        DefaultMutableTreeNode tr112 = new DefaultMutableTreeNode("①-①-②");
        tr11.add(tr112);

        // tr1に項目tr12を追加
        DefaultMutableTreeNode tr12 = new DefaultMutableTreeNode("①-②");
        tr1.add(tr12);
        
        // rootに項目tr2を追加
        DefaultMutableTreeNode tr2 = new DefaultMutableTreeNode("②");
        root.add(tr2);

        // ツリーオブジェクトを作成
        JTree tr = new JTree(root);

        // スクロールペインにツリーオブジェクトを追加
        JScrollPane sp = new JScrollPane(tr);

        Container cp = getContentPane();
        cp.add(sp);
    }
}
