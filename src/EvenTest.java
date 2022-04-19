class EvenTest {
    static boolean isEven(int n) {
        if (n % 2 == 0) {
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        int a = 3, b = 4;

        System.out.print(a + "は");
        if (isEven(a)) {
            System.out.println("偶数です。");
        } else {
            System.out.println("奇数です。");
        }

        System.out.print(b + "は");
        if (isEven(b)) {
            System.out.println("偶数です。");
        } else {
            System.out.println("奇数です。");
        }
    }
}
