import java.util.Scanner;

public class Scanner2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("データは？ > ");
        String s = scan.next();
        System.out.println("入力1: " + s);
        String s2 = scan.next();
        System.out.println("入力2: " + s2);
        scan.close();
    }
}
