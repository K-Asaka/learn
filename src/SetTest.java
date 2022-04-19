import java.util.Set;
import java.util.HashSet;

class SetTest {
    public static void main(String[] args) {
        Set<String> winUser = new HashSet<String>();
        Set<String> macUser = new HashSet<String>();

        winUser.add("Sasaki");
        winUser.add("Ota");
        winUser.add("Kudo");
        winUser.add("Sasaki");

        macUser.add("Asai");
        macUser.add("Sasaki");
        macUser.add("Mizuno");

        System.out.println("Windows User: " + winUser);
        System.out.println("Mac User: " + macUser);
    }
}
