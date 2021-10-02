import java.io.*;
public class Sample281 {
    public static void main(String[] args) {
        System.out.println("データの書き込みを開始します");
        try {
            // ファイルをオープンする
            FileOutputStream fo = new FileOutputStream("Sample.dat");

            // ファイルに書き込む
            fo.write(1);
            fo.write(2);
            fo.write(3);

            // ファイルをクローズする
            fo.close();
        } catch (Exception e) {
            // 例外処理を行う
            System.out.println("例外" + e + "が発生しました");
        }
        System.out.println("データの書き込みを終了します");
    }
}
