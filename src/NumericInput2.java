import java.util.Scanner;

class NumericInput2 {
    public static void main(String[] args) {
        Scanner sin = new Scanner(System.in);
        int price = sin.nextInt();
        double taxRate = sin.nextDouble();
        System.out.println("税込価格は " + price * (1 + taxRate) + "円です。");
    }
}
