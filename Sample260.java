import java.io.*;

public class Sample260 {
    public static void main(String[] args) {
        try {
            // InputStreamReaderクラスのオブジェクトを作成する
            InputStreamReader reader = new InputStreamReader(System.in);

            // BufferedReaderクラスのオブジェクトを作成する
            BufferedReader buffreader = new BufferedReader(reader);

            System.out.print("文字列を入力してください：");

            // readLineメソッドを使用して入力された文字列を取得する
            String str = buffreader.readLine();
            System.out.print(str + "が入力されました");
        } catch (Exception e) {
            // 例外処理を行う
            System.out.println("例外" + e + "が発生しました");
        }
    }    
}
