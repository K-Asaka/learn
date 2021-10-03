import java.net.*;
public class Sample299 {
    public static void main(String[] args) {
        try {
            URL u = new URL("http://www.moug.net/?aaa=bbb");
            System.out.print("クエリー情報は");
            System.out.println(u.getQuery() + "です");
        } catch (MalformedURLException e) {
            System.out.println("例外" + e + "が発生しました");
        }
    }
}
