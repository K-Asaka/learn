import java.io.*;
public class Sample276 {
    public static void main(String[] args) {
        System.out.println("データの読み込みを開始します");
        try {
            char data[] = new char[100];
            
            // ファイルをオープンする
            FileReader fr = new FileReader("sample.txt");

            // ファイルを読み込む
            int charscount = fr.read(data);
            String str = new String(data, 0, charscount);
            System.out.println(str);

            // ファイルをクローズする
            fr.close();
        } catch (Exception e) {
            // 例外処理を行う
            System.out.println("例外" + e + "が発生しました");
        }
        System.out.println("データの読み込みを終了します");
    }
}
