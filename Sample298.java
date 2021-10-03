import java.net.*;
public class Sample298 {
    public static void main(String[] args) {
        try {
            URL u1 = new URL("http://www.moug.net/");
            System.out.print("ポート番号は");
            System.out.println(u1.getPort() + "です(未指定)");

            URL u2 = new URL("http://www.moug.net:80/");
            System.out.print("ポート番号は");
            System.out.println(u2.getPort() + "です(指定)");
        } catch (MalformedURLException e) {
            System.out.println("例外" + e + "が発生しました");
        }
    }
}
