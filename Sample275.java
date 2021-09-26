import java.io.*;
class mThread extends Thread {
    public void run() {
        try {
            System.out.println("スレッドを10秒停止します");
            System.out.println("この間にファイルの存在を確認できます");
            sleep(10000);
        } catch (InterruptedException e) {
        }
    }
}
public class Sample275 {
    public static void main(String[] args) {
        try {
            File file1 = new File(".\\");
            File file2 = File.createTempFile("temp", "java", file1);

            // プログラム終了時に自動的に削除する
            file2.deleteOnExit();

            if (file2.exists()) {
                System.out.println(file2.getPath() + "が作成されました");
            } else {
                System.out.println("ファイルを作成できませんでした");
            }
        } catch (IOException e) {
        }

        // 10秒間スレッドを起動します
        mThread thread = new mThread();
        thread.start();
    }
}
