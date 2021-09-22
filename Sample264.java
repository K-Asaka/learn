import java.io.*;

public class Sample264 {
    public static void main(String[] args) {
        File file1 = new File("sample.txt");
        // ファイルの存在をチェックする
        if (file1.exists()) {
            System.out.println("sample.txtは存在します");
        } else {
            System.out.println("sample.txtは存在しません");
        }

        File file2 = new File("xxxx.txt");
        // ファイルの存在をチェックする
        if (file2.exists()) {
            System.out.println("xxxx.txtは存在します");
        } else {
            System.out.println("xxxx.txtは存在しません");
        }
    }    
}
