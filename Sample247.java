import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.event.*;

public class Sample247 extends JFrame {
    public static void main(String[] args) {
        Sample247 app = new Sample247();
        app.setSize(250, 200);
        app.setVisible(true);
        app.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        app.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public Sample247() {
        JEditorPane ep = new JEditorPane();
        ep.setEditable(false);

        // HyperlinkListenerを追加
        ep.addHyperlinkListener(new PageLink(ep));

        try {
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

class PageLink implements HyperlinkListener {
    private JEditorPane ep;

    public PageLink(JEditorPane ep) {
        this.ep = ep;
    }

    // ハイパーリンクが更新された時に呼び出される
    public void hyperlinkUpdate(HyperlinkEvent evt) {
        if (evt.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
            try {
                // リンクの参照先URLを取得しエディタペインにセットする
                ep.setPage(evt.getURL());
            } catch (Exception e) {
            }
        }        
    }
}