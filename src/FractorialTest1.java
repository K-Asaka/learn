class FractorialTest1 {
    static long fractorial(int n) {
        long ans = 1;

        for (int i = n; i > 0; i--) {
            ans *= i;
        }
        return ans;
    }

    public static void main(String[] args) {
        for (int i = 1; i < 10; i++) {
            System.out.println(i + "の階乗は" + fractorial(i) + "です。");
        }
    }
}
