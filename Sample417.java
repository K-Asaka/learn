import com.nttdocomo.ui.*;

public class Sample417 extends IApplication {
    public void start() {
        // リストボックスを定義する
        ListBox lbxTest;
        Panel pnlDisp = new Panel();

        // 単一選択のリストボックスを作成する
        lbxTest = new ListBox(ListBox.SINGLE_SELECT);

        // リストボックスの末尾に項目を追加する
        lbxTest.append("チョコレート");
        lbxTest.append("アイスキャンディー");
        lbxTest.append("ソフトクリーム");
        lbxTest.append("ポップコーン");
        lbxTest.append("キャラメル");

        // パネルにリストボックスを追加する
        pnlDisp.add(lbxTest);
       
        // パネルを画面上に表示する
        Display.setCurrent(pnlDisp);
    }
}
