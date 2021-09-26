import java.io.*;
public class Sample273 {
    public static void main(String[] args) {
        File file1 = new File("dirsample");

        System.out.println(file1.getPath() + "を作成します");

        // ディレクトリを作成します
        if (file1.mkdir()) {
            System.out.println("ディレクトリを作成しました");
        } else {
            System.out.println("ディレクトリを作成できませんでした");
        }
    }
}
