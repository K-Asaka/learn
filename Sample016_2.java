public class Sample016_2 {
    public static void main(String[] args) {
        // 定数を定義する
        final int teisu = 715;

        System.out.println("teisuの値は" + teisu + "です");

        // 定数に値を代入すると、エラーになる
        teisu = 610;
    }
}