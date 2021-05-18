import java.util.Random;

public class Janken1 {
    public static void main(String[] args) {
        System.out.println("じゃんけん： 0:グー、1:チョキ、2:パー ?");
        Random r = new Random();
        int pc = r.nextInt(3);
        System.out.println("コンピューター:" + pc);
    }
}
