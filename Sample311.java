import java.net.*;
import java.io.*;
public class Sample311 {
    public static void main(String[] args) {
        try {
            URL u1 = new URL("http://www.moug.net/");
            URLConnection uc1 = u1.openConnection();
            System.out.print("http://www.moug.net/のタイプは");
            System.out.println(uc1.getContentType() + "です");

            URL u2 = new URL("file:/c:\\sample.txt");
            URLConnection uc2 = u2.openConnection();
            System.out.print("sample.txtのタイプは");
            System.out.println(uc2.getContentType() + "です");

            URL u3 = new URL("file:/c:\\sample.gif");
            URLConnection uc3 = u3.openConnection();
            System.out.print("sample.gifのタイプは");
            System.out.println(uc3.getContentType() + "です");

        } catch (Exception e) {
            System.out.println("例外" + e + "が発生しました");
        }
    }
}
