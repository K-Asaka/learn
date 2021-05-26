public class Sample041 {
    public static void main(String[] args) {
        // concatメソッドを使う
        String s1 = "Hello Java ";
        String s2 = "String1!";
        s1 = s1.concat(s2);
        System.out.println(s1);

        // +演算子を使う
        String s3 = "Hello Java ";
        String s4 = "String2!";
        String s5 = s3 + s4;
        System.out.println(s5);
    }
}
