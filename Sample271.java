import java.io.*;
public class Sample271 {
    public static void main(String[] args) {
        File file1 = new File("sample.txt");
        System.out.println("ファイル" + file1.getPath() + "を削除");

        // ファイルを削除します
        if (file1.delete()) {
            System.out.println("ファイルを削除しました");
        } else {
            System.out.println("ファイルを削除できませんでした");
        }

        File file2 = new File("dirsample");
        System.out.println("ディレクトリ" + file2.getPath() + "を削除");

        // ディレクトリを削除します
        if (file2.delete()) {
            System.out.println("ディレクトリを削除しました");
        } else {
            System.out.println("ディレクトリを削除できませんでした");
        }
    }
}
