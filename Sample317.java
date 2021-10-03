import java.net.*;
import java.io.*;
public class Sample317 {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("www.moug.net", 80);
            System.out.println("ソケットが作成されました");
        } catch (Exception e) {
            System.out.println("例外" + e + "が発生しました");
        }
    }
}
