import java.io.*;
public class Sample272 {
    public static void main(String[] args) {
        File file1 = new File("sample.txt");

        System.out.println(file1.getPath() + "を作成します");

        try {
            // ファイルを作成します
            if (file1.createNewFile()) {
                System.out.println("ファイルを作成しました");
            } else {
                System.out.println("ファイルを作成できませんでした");
            }
        } catch (IOException e) {
        }
    }
}
