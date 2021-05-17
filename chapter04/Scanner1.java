import java.util.Scanner;

public class Scanner1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("データは？ > ");
        String s = scan.nextLine();
        System.out.println("入力: " + s);
        scan.close();
    }
}
