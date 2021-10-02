import java.io.*;
public class Sample278 {
    public static void main(String[] args) {
        System.out.println("データの読み込みを開始します");
        try {
            // ファイルをオープンする
            BufferedReader br = new BufferedReader(new FileReader("sample.txt"));
            
            // ファイルを読み込む
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            // ファイルをクローズする
            br.close();

        } catch (Exception e) {
            System.out.println("例外" + e + "が発生しました");
        }
        System.out.println("データの読み込みを終了します");
    }
}
