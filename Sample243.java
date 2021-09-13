/* <applet code="Sample243" width="310" height="150"></applet> */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.tree.*;

public class Sample243 extends JApplet {

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

        tr.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                JTree jtr = (JTree)e.getSource();

                // クリックされた行を取得する
                int row = jtr.getRowForLocation(e.getX(), e.getY());
                if (row != -1) {
                    // 指定された行のパスを取得する
                    TreePath treepath = jtr.getPathForRow(row);

                    // 指定されたパスの末尾のコンポーネントを取得
                    TreeNode treenode = (TreeNode)treepath.getLastPathComponent();

                    // 選択された項目をステータスバーに表示
                    if (e.getClickCount() == 1) {
                        showStatus(treenode.toString() + " を選択");
                    }
                }
            }
        });
    }
}
