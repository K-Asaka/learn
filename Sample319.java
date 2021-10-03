import java.net.*;
import java.io.*;
public class Sample319 {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("www.moug.net", 80);
            System.out.println("ソケットのバインド先ローカルアドレスは");
            System.out.println(s.getLocalAddress() + "です");
        } catch (Exception e) {
            System.out.println("例外" + e + "が発生しました");
        }
    }
}
