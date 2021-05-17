import java.util.Random;

public class Dice3 {
    public static void main(String[] args) {
        Random r1 = new Random();
        int randomNum = r1.nextInt(6) + 1;
        System.out.println(randomNum);
    }
}
