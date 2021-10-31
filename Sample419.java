import com.nttdocomo.ui.*;

public class Sample419 extends IApplication implements ComponentListener {
    // リストボックスを定義する
    ListBox lbxTest;
    Label lblTest;

    public void start() {
        Panel pnlDisp = new Panel();

        // チェックボックス型のリストボックスを作成する
        lbxTest = new ListBox(ListBox.CHECK_BOX);

        // リストボックスの末尾に項目を追加する
        lbxTest.append("チョコレート");
        lbxTest.append("アイスキャンディー");
        lbxTest.append("ソフトクリーム");
        lbxTest.append("ポップコーン");
        lbxTest.append("キャラメル");

        // パネルにリストボックスを追加する
        pnlDisp.add(lbxTest);

        // 選択項目表示用ラベルを作成する
        lblTest = new Label("", Label.LEFT);
        lblTest.setSize(96, 15);

        pnlDisp.add(lblTest);

        // コンポーネントリスナーを登録する
        pnlDisp.setComponentListener(this);

        // パネルを画面上に表示する
        Display.setCurrent(pnlDisp);
    }

    // リスト選択が行われると以下が実行される
    public void componentAction(Component c, int act, int prm) {
        // リストボックスのイベントが発生した場合実行
        if (c == lbxTest) {
            // 項目選択確定時のイベントの場合実行
            if (act == ComponentListener.SELECTION_CHANGED) {
                // 選択項目をラベルへ表示
                lblTest.setText(lbxTest.getItem(prm) + "を選択");
            }
        }
    }
}
