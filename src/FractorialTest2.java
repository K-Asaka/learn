class FractorialTest2 {
    static long fractorial(int n) {
        if (n < 2) {
            return 1;
        }
        return n * fractorial(n - 1);
    }

    public static void main(String[] args) {
        for (int i = 1; i < 10; i++) {
            System.out.println(i + "の階乗は" + fractorial(i) + "です。");
        }
    }
}
