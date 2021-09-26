import java.io.*;
public class Sample270 {
    public static void main(String[] args) {
        File file1 = new File("sample.txt");
        File file2 = new File("newsample.txt");

        System.out.print(file1.getPath() + "のファイル名を");
        System.out.println(file2.getPath() + "に変更します");

        // ファイル名を変更します
        if (file1.renameTo(file2)) {
            System.out.print("ファイル名を変更しました");
        } else {
            System.out.print("ファイル名を変更できませんでした");
        }
    }
}
