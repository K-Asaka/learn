public class IfObj2 {
    public static void main(String[] args) {
        String s1 = new String("java");
        String s2 = new String("java");
        if (s1 == s2) {
            System.out.println("s1はs2と同じ");
        } else {
            System.out.println("s1とs2は異なる");
        }
    }
}
