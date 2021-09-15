class mThread7 extends Thread {
    public void run() {
        try {
            sleep(2000);
        } catch (InterruptedException e) {
        }
    }
}

public class Sample256 {
    public static void main(String[] args) {
        System.out.println("スレッドの状態をチェックします");
        mThread7 thread = new mThread7();

        // 作成直後にチェック
        if (thread.isAlive()) {
            System.out.println("スレッドは生存しています");
        } else {
            System.out.println("スレッドは生存していません");
        }
        thread.start();

        // 起動後にチェック
        if (thread.isAlive()) {
            System.out.println("スレッドは生存しています");
        } else {
            System.out.println("スレッドは生存していません");
        }
    }    
}
