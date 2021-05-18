import java.util.Random;
import java.util.Scanner;

public class Janken4 {
    public static void main(String[] args) {
        int win = 0, lose = 0, even = 0;
        Scanner scan = new Scanner(System.in);
        for (int i = 1; i <= 10; i++) {
            System.out.println("\n" + i + "回戦");
            System.out.println("じゃんけん： 0:グー、1:チョキ、2:パー ?");
            Random r = new Random();
            int pc = r.nextInt(3);
            String s = scan.next();
            int you = Integer.parseInt(s);
            String[] janken = {"グー", "チョキ", "パー"};
            System.out.println("あなた:" + janken[you] + "、コンピュータ:" + janken[pc]);
            
            int winlose = (you + 3 - pc) % 3;
            if (winlose == 0) {
                System.out.println("あいこ");
                even++;
            } else if (winlose == 1) {
                System.out.println("負け");
                lose++;
            } else {
                System.out.println("勝ち！");
                win++;
            }
        }
        scan.close();
        System.out.println("対戦成績:" + win + "勝、" + lose + "負、" + even + "分け");
    }
}
