class Common2 {
    private int value = 0;

    // スレッドの同期
    public synchronized void add(int num) {
        int tmp = value;
        System.out.print(Thread.currentThread());
        System.out.println("を実行中" + value);
        value = tmp + num;
        System.out.print(Thread.currentThread());
        System.out.println("が実行中" + value);
    }
}

class mThread4 extends Thread {
    Common2 comm;

    public mThread4(Common2 comm) {
        this.comm = comm;
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            comm.add(10);
        }
    }
}

class Sample253_2 {
    public static void main(String args[]) {
        Common2 comm = new Common2();

        mThread4 th1 = new mThread4(comm);
        th1.setName("1番目のスレッド");
        th1.start();

        mThread4 th2 = new mThread4(comm);
        th2.setName("2番目のスレッド");
        th2.start();
    }
}
