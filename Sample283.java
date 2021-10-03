import java.io.*;
public class Sample283 {
    public static void main(String[] args) {
        System.out.println("データの書き込みを開始します");
        try {
            // バイト配列を作成
            byte bytedata[] = {'A', 'B', 'C', 'D', 'E', 'F'};
            // 出力ストリームをオープンする
            ByteArrayOutputStream bo = new ByteArrayOutputStream();
            // 出力ストリームに書き込む
            bo.write(bytedata, 2, 3);
            System.out.println(bo.toString());
            // 出力ストリームをクローズする
            bo.close();
        } catch (Exception e) {
            // 例外処理を行う
            System.out.println("例外" + e + "が発生しました");
        }
        System.out.println("データの書き込みを終了します");
    }
}
