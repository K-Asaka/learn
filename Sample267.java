import java.io.*;

public class Sample267 {
    public static void main(String[] args) {
        File file1 = new File(".\\", "Sample267.java");
        System.out.print(file1.getPath() + "のサイズは");
        // ファイルサイズを取得する
        System.out.println(file1.length() + "バイトです");
    }    
}
