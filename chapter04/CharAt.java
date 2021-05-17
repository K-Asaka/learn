public class CharAt {
    public static void main(String[] args) {
        String s1 = "こんにちはJava";
        char c1 = s1.charAt(0);
        System.out.println("最初の文字: " + c1);
        int len = s1.length();
        char c2 = s1.charAt(len - 1);
        System.out.println("最後の文字: " + c2);
    }
}
