public class Exception2 {
    public static void main(String[] args) {
        int num1 = 5;
        try {
            int num2 = num1 / 0;
            System.out.println(num2);
        } catch (ArithmeticException e) {
            System.out.println("例外: " + e);
        }
        System.out.println("プログラムの最後です");
    }
}
