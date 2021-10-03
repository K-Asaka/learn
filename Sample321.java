import java.net.*;
import java.io.*;
public class Sample321 {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("www.moug.net", 80);
            System.out.println("ソケットのバインド先ローカルポートは");
            System.out.println(s.getLocalPort() + "です");
        } catch (Exception e) {
            System.out.println("例外" + e + "が発生しました");
        }
    }
}
