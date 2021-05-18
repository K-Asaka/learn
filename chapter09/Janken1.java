import java.util.Random;
import java.util.Scanner;

public class Janken1 {
    public static void main(String[] args) {
        System.out.println("じゃんけん： 0:グー、1:チョキ、2:パー ?");
        Random r = new Random();
        int pc = r.nextInt(3);
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int you = Integer.parseInt(s);
        scan.close();
        System.out.println("あなた:" + you + "、コンピュータ:" + pc);
    }
}
