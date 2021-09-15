class mThread6 extends Thread {
    public void run() {
        System.out.println("スレッドの実行を2秒待ちます");
        try {
            sleep(2000);
        } catch (InterruptedException e) {
        }
    }
}

class Sample255 {
    public static void main(String[] args) {
        System.out.println("メインスレッドを実行しています(中断前)");

        // スレッドを作成します
        mThread6 thread = new mThread6();
        // スレッドを起動します
        thread.start();

        System.out.println("メインスレッドが終了待ちに入ります");

        try {
            // スレッドの終了を待ちます
            thread.join();
        } catch (InterruptedException e) {
        }

        System.out.println("メインスレッドが処理を再開します");

        System.out.println("メインスレッドを実行しています(中断後)");
    }
}