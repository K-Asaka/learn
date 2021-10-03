import java.net.*;
import java.io.*;
public class Sample318 {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("www.moug.net", 80);
            System.out.println("ソケットの接続先アドレスは");
            System.out.println(s.getInetAddress() + "です");
        } catch (Exception e) {
            System.out.println("例外" + e + "が発生しました");
        }
    }
}
