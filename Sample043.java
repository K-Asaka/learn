public class Sample043 {
    public static void main(String[] args) {
        String s1 = "Hello Java String!";
        // 7文字目以降を取り出す
        String s2 = s1.substring(6);
        System.out.println(s2);
        // 7文字目～10文字目を取り出す
        String s3 = s1.substring(6, 10);
        System.out.println(s3);
    }
}
