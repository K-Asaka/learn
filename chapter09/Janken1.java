import java.util.Random;
import java.util.Scanner;

public class Janken1 {
    public static void main(String[] args) {
        System.out.println("じゃんけん： 0:グー、1:チョキ、2:パー ?");
        Random r = new Random();
        int pc = r.nextInt(3);
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        scan.close();
        int you = Integer.parseInt(s);
        String[] janken = {"グー", "チョキ", "パー"};
        System.out.println("あなた:" + janken[you] + "、コンピュータ:" + janken[pc]);
    }
}
