public class IfObj1 {
    public static void main(String[] args) {
        String s1 = new String("java");
        String s2 = s1;
        if (s1 == s2) {
            System.out.println("s1はs2と同じ");
        } else {
            System.out.println("s1とs2は異なる");
        }
    }
}
