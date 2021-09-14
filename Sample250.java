class mThread implements Runnable {
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("スレッドを実行しています");
        }
    }
}

public class Sample250 {
    public static void main(String[] args) {
        // スレッドを作成します
        mThread thread = new mThread();
        // Threadクラスのオブジェクトを作成する
        Thread th = new Thread(thread);
        // スレッドを起動します
        th.start();

        for (int i = 0; i < 5; i++) {
            System.out.println("メインスレッドを実行しています");
        }
    }
}
