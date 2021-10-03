import java.net.*;
import java.io.*;
import java.util.*;
public class Sample316 {
    public static void main(String[] args) {
        try {
            URL u = new URL("http://www.moug.net/");
            URLConnection uc = u.openConnection();
            System.out.println("http://www.moug.net/の最終更新日は");
            System.out.print(new java.util.Date(uc.getLastModified()));
            System.out.println("です");
        } catch (Exception e) {
            System.out.println("例外" + e + "が発生しました");
        }
    }
}
