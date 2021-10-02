import java.io.*;
public class Sample279 {
    public static void main(String[] args) {
        System.out.println("データの書き込みを開始します");
        try {
            // ファイルをオープンする
            PrintWriter pr = new PrintWriter(new BufferedWriter(new FileWriter("sample.txt")));
            // ファイrに書き込む
            pr.println("123");
            pr.println("456");
            pr.println("789");

            // ファイルをクローズする
            pr.close();
        } catch (Exception e) {
            System.out.println("例外" + e + "が発生しました");
        }
        System.out.println("データの書き込みを終了します");
    }    
}
