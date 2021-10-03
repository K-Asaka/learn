import java.net.*;
public class Sample297 {
    public static void main(String[] args) {
        try {
            URL u = new URL("http://www.moug.net/");
            System.out.print("ホスト名は");
            System.out.println(u.getHost() + "です");
        } catch (MalformedURLException e) {
            System.out.println("例外" + e + "が発生しました");
        }
    }
}
