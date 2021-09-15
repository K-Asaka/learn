class Common {
    private int value = 0;

    // スレッドの同期を意識していない
    public void add(int num) {
        int tmp = value;
        System.out.print(Thread.currentThread());
        System.out.println("を実行中" + value);
        value = tmp + num;
        System.out.print(Thread.currentThread());
        System.out.println("が実行中" + value);
    }
}

class mThread3 extends Thread {
    Common comm;

    public mThread3(Common comm) {
        this.comm = comm;
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            comm.add(10);
        }
    }
}

class Sample253_1 {
    public static void main(String args[]) {
        Common comm = new Common();

        mThread3 th1 = new mThread3(comm);
        th1.setName("1番目のスレッド");
        th1.start();

        mThread3 th2 = new mThread3(comm);
        th2.setName("2番目のスレッド");
        th2.start();
    }
}
