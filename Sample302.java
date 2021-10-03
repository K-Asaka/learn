import java.net.*;
public class Sample302 {
    public static void main(String[] args) {
        try {
            URL u1 = new URL("http://www.moug.net/boards/index.htm#abc");
            System.out.print("アンカー部分は");
            System.out.println(u1.getRef() + "です(指定)");

            URL u2 = new URL("http://www.moug.net/boards/index.htm");
            System.out.print("アンカー部分は");
            System.out.println(u2.getRef() + "です(未指定)");

        } catch (MalformedURLException e) {
            System.out.println("例外" + e + "が発生しました");
        }
    }
}
