import java.net.*;
public class Sample295_2 {
    public static void main(String[] args) {
        try {
            URL u1 = new URL("http://www.moug.net/");
            URL u2 = new URL(u1, "boards/index.htm");
            System.out.println("URLオブジェクトが作成されました");
        } catch (MalformedURLException e) {
            System.out.println("例外" + e + "が発生しました");
        }
    }
}
