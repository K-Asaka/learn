import java.io.*;
public class Sample261 {
    public static void main(String[] args) {
        try {
            InputStreamReader reader = new InputStreamReader(System.in);
            BufferedReader buffreader = new BufferedReader(reader);
            
            // readLineメソッドを使って入力された文字列を取得する
            String str = buffreader.readLine();
            while (str != null) {
                // endを入力するとループを抜けます
                if (str.equals("end")) {
                    break;
                }
                // 入力された文字列を画面に出力する
                System.out.println(str);
                
                // readLineメソッドを使って入力された文字列を再度取得する
                str = buffreader.readLine();
            }
        } catch (Exception e) {
            // 例外処理を行う
            System.out.println("例外" + e + "が発生しました");
        }
    }
}
