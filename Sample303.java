import java.net.*;
public class Sample303 {
    public static void main(String[] args) {
        try {
            URL u = new URL("http://password@www.moug.net/");
            System.out.print("ユーザー情報は");
            System.out.println(u.getUserInfo() + "です");
        } catch (MalformedURLException e) {
            System.out.println("例外" + e + "が発生しました");
        }
    }
}
