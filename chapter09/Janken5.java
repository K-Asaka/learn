import java.util.Random;
import java.util.Scanner;

public class Janken5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(true) {
            System.out.println("じゃんけん： 0:グー、1:チョキ、2:パー、e:終了 ?");
            Random r = new Random();
            int pc = r.nextInt(3);
            String s = scan.next();
            if (s.equals("e")) {
                break;
            }
            int you = -1;
            try {
                you = Integer.parseInt(s);
            } catch (Exception e) { }
            if (you < 0 || you > 2) {
                System.out.println("入力値が不正です");
                continue;
            }
            String[] janken = {"グー", "チョキ", "パー"};
            System.out.println("あなた:" + janken[you] + "、コンピュータ:" + janken[pc]);
            
            int winlose = (you + 3 - pc) % 3;
            if (winlose == 0) {
                System.out.println("あいこ");
            } else if (winlose == 1) {
                System.out.println("負け");
            } else {
                System.out.println("勝ち！");
            }
        }
        scan.close();
    }
}
