import java.io.*;
import java.util.*;
public class Sample284 {
    public static void main(String[] args) {
        try {
            FileInputStream fi1 = new FileInputStream("sample1.txt");
            FileInputStream fi2 = new FileInputStream("sample2.txt");
            FileInputStream fi3 = new FileInputStream("sample3.txt");
            Vector v = new Vector();
            v.add(fi1);
            v.add(fi2);
            v.add(fi3);

            SequenceInputStream si = new SequenceInputStream(v.elements());

            // ファイルを連続して読む
            int bchar;
            while ((bchar = si.read()) != -1) {
                System.out.print((char)bchar);
            }

            si.close();
        } catch (Exception e) {
            System.out.println("例外" + e + "が発生しました");
        }
    }
}
