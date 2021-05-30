public class Sample071 {
    public static void main(String[] args) {
        try {
            int a[] = new int[3];
            System.out.print("配列aの5番目の要素に");
            System.out.println("値を代入します");

            a[4] = 10;

            System.out.print("配列aの5番目の要素は");
            System.out.print(a[4] + "です");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("配列に値を代入できません");
            System.out.println("例外は" + e + "です");
        }
    }
}
