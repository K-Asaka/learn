import java.io.*;

public class Sample265 {
    public static void main(String[] args) {
        File file1 = new File("C:\\JAVA\\SAMPLE\\265", "sample.txt");
        System.out.println("ファイル名：" + file1.getName());
        System.out.println("パス名：" + file1.getParent());
        System.out.println("フルパス名：" + file1.getPath());
    }    
}
