class mThread extends Thread {
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("スレッドを実行しています");
        }
    }
}

public class Sample249 {
    public static void main(String[] args) {
        // スレッドを作成します
        mThread thread = new mThread();
        // スレッドを起動します
        thread.start();

        for (int i = 0; i < 5; i++) {
            System.out.println("メインスレッドを実行しています");
        }
    }  
}
