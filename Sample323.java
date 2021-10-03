import java.io.*;
import java.net.*;
public class Sample323 {
    public static void main(String[] args) {
        try {
            ServerSocket svsock = new ServerSocket(2525);
            Socket sock = svsock.accept();
            PrintWriter out = new PrintWriter(sock.getOutputStream(), true);
            out.println("Hello Java!");
            sock.close();
        } catch (Exception e) {
            System.out.println("例外" + e + "が発生しました");
        }
    }
}
