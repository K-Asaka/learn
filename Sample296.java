import java.net.*;
public class Sample296 {
    public static void main(String[] args) {
        try {
            URL u = new URL("http://www.moug.net/");
            System.out.print("プロトコル名は");
            System.out.println(u.getProtocol() + "です");
        } catch (MalformedURLException e) {
            System.out.println("例外" + e + "が発生しました");
        }
    }
}
