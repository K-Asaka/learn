import java.net.*;
public class Sample295_3 {
    public static void main(String[] args) {
        try {
            URL u = new URL("http", "www.moug.net", "boards/index.htm");
            System.out.println("URLオブジェクトが作成されました");
        } catch (MalformedURLException e) {
            System.out.println("例外" + e + "が発生しました");
        }
    }
}
