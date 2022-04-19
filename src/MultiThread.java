class MultiThread extends Thread {
    String str;
    int time;

    MultiThread(String s, int t) {
        str = s;
        time = t;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("No. " + i + " : " + str);
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {}
        }
    }
}
