import java.net.*;
import java.io.*;
public class Sample310 {
    public static void main(String[] args) {
        try {
            int num;
            byte buf[] = new byte[4096];
            URL u = new URL("http://www.moug.net/");
            DataInputStream di = new DataInputStream(u.openStream());
            while ((num = di.read(buf)) != -1) {
                System.out.write(buf, 0, num);
            }
        } catch (Exception e) {
            System.out.println("例外" + e + "が発生しました");
        }
    }
}
