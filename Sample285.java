import java.io.*;
public class Sample285 {
    public static void main(String[] args) {
        try {
            int data[] = {1, 2, 3, 4, 5};
            RandomAccessFile ra = new RandomAccessFile("sample.dat", "rw");

            // ファイルに書き込む
            for (int i = 0; i < data.length; i++) {
                ra.writeInt(data[i]);
            }
            // 2バイト目を読み込む
            ra.seek(4);
            System.out.println("2バイト目は" + (int)ra.readInt() + "です");
            // 4バイト目を読み込む
            ra.seek(12);
            System.out.println("4バイト目は" + (int)ra.readInt() + "です");
            ra.close();
        } catch (Exception e) {
            System.out.println("例外" + e + "が発生しました");
        }
    }
}
