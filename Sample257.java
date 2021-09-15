class Common3 {
    int data = 0;
    synchronized void dataWrite() {
        System.out.println("書き込み処理実行 data = " + data);
        try {
            // 書き込み処理を3秒間停止し、処理に時間をかけます
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }
        data = 123456789;
        System.out.println("書き込み処理終了 data = " + data);
        // 最初にwaitを呼び出したスレッドを開始する
        notify();
    }
    synchronized int dataRead() {
        System.out.println("読み取り処理待機");
        try {
            // notifyが呼び出されるまでスレッドをスリープさせる
            wait();
        } catch (InterruptedException e) {
        }
        System.out.println("読み取り処理再開");
        return data;
    }
}

// 読み取りスレッド
class mThread8 extends Thread {
    Common3 comm;
    public mThread8 (Common3 comm) {
        this.comm = comm;
    }
    public void run() {
        System.out.println("読み取り処理終了 data = " + comm.dataRead());
    }
}
// 書き込みスレッド
class mThread9 extends Thread {
    Common3 comm;
    public mThread9(Common3 comm) {
        this.comm = comm;
    }
    public void run() {
        comm.dataWrite();
    }
}

public class Sample257 {
    public static void main(String[] args) {
        Common3 comm = new Common3();

        mThread8 th1 = new mThread8(comm);
        th1.start();

        mThread9 th2 = new mThread9(comm);
        th2.start();
    }    
}
