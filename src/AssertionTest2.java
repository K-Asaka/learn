class AssertionTest2 {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        System.out.print(n + "は");
        if (n % 2 == 1) {
            System.out.println("奇数です。");
        } else {
            assert n % 2 == 0;
            System.out.println("偶数です。");
        }
    }
}
