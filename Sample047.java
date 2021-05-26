public class Sample047 {
    public static void main(String[] args) {
        String s = "   Hello Java String!   ";
        System.out.println(s + " : " + s.length() + "文字です");
        // 前後のスペースを取り除く
        s = s.trim();
        System.out.println(s + " : " + s.length() + "文字です");
    }
}
