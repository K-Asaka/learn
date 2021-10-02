import java.io.*;
public class Sample280 {
    public static void main(String[] args) {
        System.out.println("データの読込を開始します");
        try {
            int bytedata;
            // ファイルをオープンする
            FileInputStream fi = new FileInputStream("Sample.dat");
            // ファイルを読み込む
            for (int i = 0; i < 50; i++) {
                bytedata = fi.read();
                System.out.print(Integer.toHexString(bytedata) + " ");
            }
            // ファイルをクローズする
            fi.close();
        } catch (Exception e) {
            // 例外処理を行う
            System.out.println("例外" + e + "が発生しました");
        }
        System.out.println();
        System.out.println("データの読み込みを終了します");
    }
}
