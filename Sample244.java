/* <applet code="Sample244" width="310" height="150"></applet> */
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.tree.*;

public class Sample244 extends JApplet {

    public void init() {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("root");
        DefaultMutableTreeNode tr1 = new DefaultMutableTreeNode("①");
        root.add(tr1);
        DefaultMutableTreeNode tr11 = new DefaultMutableTreeNode("①-①");
        tr1.add(tr11);
        DefaultMutableTreeNode tr111 = new DefaultMutableTreeNode("①-①-①");
        tr11.add(tr111);
        DefaultMutableTreeNode tr112 = new DefaultMutableTreeNode("①-①-②");
        tr11.add(tr112);
        DefaultMutableTreeNode tr12 = new DefaultMutableTreeNode("①-②");
        tr1.add(tr12);
        DefaultMutableTreeNode tr2 = new DefaultMutableTreeNode("②");
        root.add(tr2);
        // ツリーオブジェクトを作成
        JTree tr = new JTree(root);
        JScrollPane sp = new JScrollPane(tr);
        Container cp = getContentPane();
        cp.add(sp);

        // ツリーを編集可能に設定する
        tr.setEditable(true);
    }
}
