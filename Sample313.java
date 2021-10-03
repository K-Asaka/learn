import java.net.*;
import java.io.*;
public class Sample313 {
    public static void main(String[] args) {
        try {
            URL u = new URL("http://www.moug.net/");
            URLConnection uc = u.openConnection();
            System.out.print("http://www.moug.net/のエンコード方式は");
            System.out.println(uc.getContentEncoding() + "です");
        } catch (Exception e) {
            System.out.println("例外" + e + "が発生しました");
        }
    }
}
