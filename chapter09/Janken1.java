import java.util.Random;
import java.util.Scanner;

public class Janken1 {
    public static void main(String[] args) {
        System.out.print("じゃんけん： 0:グー、1:チョキ、2:パー ?");
        Random r = new Random();
        int pc = r.nextInt(3);
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        scan.close();
        int you = Integer.parseInt(s);
        String[] janken = {"グー", "チョキ", "パー"};
        System.out.println("あなた:" + janken[you] + "、コンピュータ:" + janken[pc]);
        if (you == 0) {
            if (pc == 0) {
                System.out.println("あいこ");
            } else if (pc == 1) {
                System.out.println("勝ち！");
            } else {
                System.out.println("負け");
            }
        } else if (you == 1) {
            if (pc == 0) {
                System.out.println("負け");
            } else if (pc == 1) {
                System.out.println("あいこ");
            } else {
                System.out.println("勝ち！");
            }
        } else {
            if (pc == 0) {
                System.out.println("勝ち！");
            } else if (pc == 1) {
                System.out.println("負け");
            } else {
                System.out.println("あいこ");
            }
        }
    }
}
