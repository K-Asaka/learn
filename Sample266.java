import java.io.*;

public class Sample266 {
    public static void main(String[] args) {
        File file1 = new File("C:\\Program Files\\AdoptOpenJDK\\jdk-11.0.10.9-hotspot\\bin");
        // ディレクトリ中に存在するファイル、ディレクトリを取得
        String list1[] = file1.list();

        for (int i = 0; i < list1.length; i++) {
            System.out.println((i + 1) + ":" + list1[i]);
        }
    }    
}
