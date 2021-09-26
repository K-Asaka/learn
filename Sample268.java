import java.io.*;
public class Sample268 {
    public static void main(String[] args) {
        File file1 = new File("readonly.txt");

        // 読み取り可否を判定する
        if (file1.canRead()) {
            System.out.println(file1.getName() + "は読み取り可能です");
        } else {
            System.out.println(file1.getName() + "は読み取り不可です");
        }

        // 書き換え可否を判定する
        if (file1.canWrite()) {
            System.out.println(file1.getName() + "は書き換え可能です");
        } else {
            System.out.println(file1.getName() + "は書き換え不可です");
        }
    }
}
