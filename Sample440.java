import com.nttdocomo.ui.*;
import java.io.*;
import javax.microedition.io.*;

// ComponentListenerインタフェースを実装する
public class Sample440 extends IApplication implements ComponentListener {
    // リストボックスを定義する
    ListBox lbxTest;
    
    public void start() {
        int intData = 0;
        Panel pnlDisp = new Panel();

        // ラジオボタン型のリストボックスを作成する
        lbxTest = new ListBox(ListBox.RADIO_BUTTON);

        // リストボックスの末尾に項目を追加する
        lbxTest.append("チョコレート");
        lbxTest.append("アイスキャンディー");
        lbxTest.append("ソフトクリーム");
        lbxTest.append("ポップコーン");
        lbxTest.append("キャラメル");

        // パネルにリストボックスを追加する
        pnlDisp.add(lbxTest);

        // コンポーネントリスナーを登録する
        pnlDisp.setComponentListener(this);

        // パネルを画面上に表示する
        Display.setCurrent(pnlDisp);

        // スクラッチパッドからデータを取得する
        try {
            InputStream in = Connector.openInputStream("scratchpad:///0");
            intData = in.read();
            in.close();
            // 取得データから項目選択
            lbxTest.select(intData);
        } catch (IOException e) {
        }
    }

    // リスト選択が行われると以下が実行される
    public void componentAction(Component c, int act, int prm) {
        // リストボックスのイベントが発生した場合実行
        if (c == lbxTest) {
            // 項目選択確定時のイベントの場合実行
            if (act == ComponentListener.SELECTION_CHANGED) {
                // スクラッチパッドへデータを保存する
                try {
                    OutputStream out = Connector.openOutputStream("scratchpad:///0");
                    out.write(prm);
                    out.close();
                } catch (IOException e) {
                }
            }
        }
    }
}
