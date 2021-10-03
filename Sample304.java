import java.net.*;
public class Sample304 {
    public static void main(String[] args) {
        try {
            URL u = new URL("http://password@www.moug.net/");
            System.out.print("権限は");
            System.out.println(u.getAuthority() + "です");
        } catch (MalformedURLException e) {
            System.out.println("例外" + e + "が発生しました");
        }
    }
}
