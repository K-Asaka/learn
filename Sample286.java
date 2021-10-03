import java.io.*;
public class Sample286 {
    public static void main(String[] args) {
        try {
            FileInputStream fi = new FileInputStream("sample.txt");
            PushbackInputStream pi = new PushbackInputStream(fi, 3);
            int c1, c2, c3, c4, c;

            c1 = pi.read();
            c2 = pi.read();
            c3 = pi.read();
            c4 = pi.read();
            System.out.println("1件目:" + (char)c1);
            System.out.println("2件目:" + (char)c2);
            System.out.println("3件目:" + (char)c3);
            System.out.println("4件目:" + (char)c4);
            System.out.println("2件目まで戻って読み直します");
            pi.unread(c4);
            pi.unread(c3);
            pi.unread(c2);
            c = pi.read();
            System.out.println("2件目:" + (char)c);
            pi.close();
        } catch (Exception e) {
            System.out.println("例外" + e + "が発生しました");
        }            
    }
}
