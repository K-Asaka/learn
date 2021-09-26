import java.io.*;
public class Sample274 {
    public static void main(String[] args) {
        try {
            File file1 = new File(".\\");

            // テンポラリーファイルを作成する
            File file2 = File.createTempFile("sample", "java", file1);

            if (file2.exists()) {
                System.out.println(file2.getPath() + "が作成されました");
            } else {
                System.out.println("ファイルを作成できませんでした");
            }
        } catch (IOException e) {
        }
    }
}
