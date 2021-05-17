import java.util.Scanner;

public class HeiseiToSeireki3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("平成年? > ");
        String s = scan.next();
        try {
            int heisei = Integer.parseInt(s);
            int seireki = heisei - 1988;
            System.out.println("西暦: " + seireki + "年");
        } catch (Exception e) {
            System.out.println("整数値を入力してください");
        }
        scan.close();
    }
}
