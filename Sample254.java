class mThread5 extends Thread {
    public void run() {
        for (int i = 0; i < 3; i++) {
            try {
                sleep(2000);
                System.out.println("スレッドを2秒おきに3回実行します");
            } catch (InterruptedException e) {
            }
        }
    }
}

public class Sample254 {
    public static void main(String[] args) {
        mThread5 thread = new mThread5();
        // スレッドを起動します
        thread.start();
    }
}
