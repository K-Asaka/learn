public class Sample048 {
    public static void main(String[] args) {
        String s1 = "Hello Java String!";
        String s2 = "Hello World!";

        // Stringオブジェクトと比較
        System.out.print(s1 + "と" + s2);
        if (s1.equals(s2)) {
            System.out.println("は同じ文字列です");
        } else {
            System.out.println("は違う文字列です");
        }

        // 引用符で囲まれた文字列と比較
        System.out.print("Hello World!" + "と" + s2);
        if ("Hello World!".equals(s2)) {
            System.out.println("は同じ文字列です");
        } else {
            System.out.println("は違う文字列です");
        }
    }
}
