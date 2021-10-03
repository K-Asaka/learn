import java.net.*;
import java.io.*;
public class Sample324 {
    public static void main(String[] args) {
        byte[] buff = new byte[1024];
        try {
            Socket sock = new Socket("127.0.0.1", 2525);
            InputStream in = sock.getInputStream();
            int n = in.read(buff);
            System.out.println("サーバーから");
            System.out.write(buff, 0, n);
            System.out.println("を取得しました");
            sock.close();
        } catch (Exception e) {
            System.out.println("例外" + e + "が発生しました");
        }
    }
}
