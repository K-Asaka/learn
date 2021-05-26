public class Sample049 {
    public static void main(String[] args) {
        String s1 = "Hello Java String!";
        String s2 = "hello java string!";

        // equalsメソッドでは違う文字列と判断される
        System.out.print(s1 + "と" + s2);
        if (s1.equals(s2)) {
            System.out.println("は同じ文字列です");
        } else {
            System.out.println("は違う文字列です");
        }

        // equalsIgnoreCaseメソッドでは同じ文字列と判断される
        System.out.print(s1 + "と" + s2);
        if (s1.equalsIgnoreCase(s2)) {
            System.out.println("は同じ文字列です");
        } else {
            System.out.println("は違う文字列です");
        }
    }
}
