import java.io.*;
public class Sample277 {
    public static void main(String[] args) {
        System.out.println("データの書き込みを開始します");
        try {
            // ファイルをオープンする
            FileWriter fw = new FileWriter("sample.txt");

            // ファイルに書き込む
            fw.write("123456789");

            // ファイルをクローズする
            fw.close();
        } catch (Exception e) {
            // 例外処理を行う
            System.out.println("例外" + e + "が発生しました");
        }
        System.out.println("データの書き込みを終了します");
    }
}
