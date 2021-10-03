import java.net.*;
public class Sample300 {
    public static void main(String[] args) {
        try {
            URL u = new URL("http://www.moug.net/boards/index.htm");
            System.out.print("パス名は");
            System.out.println(u.getPath() + "です");
        } catch (MalformedURLException e) {
            System.out.println("例外" + e + "が発生しました");
        }
    }
}
