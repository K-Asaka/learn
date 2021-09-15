class mThread extends Thread {
    public void run() {
        for (int i = 0; i < 5; i++) {
            // 現在実行中のスレッドオブジェクトの参照
            System.out.println(Thread.currentThread() + "を実行しています");
        }
    }
}

public class Sample251 {
    public static void main(String[] args) {
        mThread thread = new mThread();
        // スレッドの名前を取得
        System.out.println("スレッドの名前は " + thread.getName() + " です。");
        System.out.println("スレッドの名前を設定します");
        // スレッドの名前を設定
        thread.setName("1番目のスレッド");
        System.out.println(thread.getName() + "を実行します");
        thread.start();
    }
}
