import java.io.*;
public class Sample282 {
    public static void main(String[] args) {
        System.out.println("データの読み込みを開始します");
        try {
            // バイト配列を作成
            byte bytedata[] = {'A', 'B', 'C', 'D', 'E', 'F'};
            // 入力ストリームをオープンする
            ByteArrayInputStream bi = new ByteArrayInputStream(bytedata);
            // 入力ストリームを読み込む
            int bchar;
            while ((bchar = bi.read()) != -1) {
                System.out.print((char)bchar);
            }
            // 入力ストリームをクローズする
            bi.close();
        } catch (Exception e) {
            // 例外処理を行う
            System.out.println("例外" + e + "が発生しました");
        }
        System.out.println();
        System.out.println("データの読み込みを終了します");
    }
}
