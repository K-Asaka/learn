class mThread2 extends Thread {
    private String strNo;

    // スレッドの起動順番をインスタンスフィールドに設定
    public mThread2(String str) {
        strNo = str;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(strNo + "のスレッドを実行しています");
        }
    }
}

public class Sample252 {
    public static void main(String[] args) {
        mThread2 th1 = new mThread2("1番目");
        // 1つ目のスレッドを起動します
        th1.start();

        mThread2 th2 = new mThread2("2番目");
        // 2つ目のスレッドを起動します
        th2.start();

        for (int i = 0; i < 5; i++) {
            System.out.println("メインスレッドを実行しています");
        }
    }
}
