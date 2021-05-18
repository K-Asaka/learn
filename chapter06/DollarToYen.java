import java.util.Scanner;

public class DollarToYen {
    public static void main(String[] args) {
        double dollar;
        final double RATE = 110.0;
        Scanner scan = new Scanner(System.in);
        while(true) {
            System.out.print("ドル? > ");
            String str = scan.nextLine();
            if (str.isEmpty()) break;
            try {
                dollar = Double.parseDouble(str);
            } catch (Exception e) {
                System.out.println("数値を入力してください");
                continue;
            }
            System.out.println((dollar * RATE) + "円");
        }
        scan.close();
    }
}
