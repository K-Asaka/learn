public class Sample021_1 {
    public static void main(String[] args) {
        double a = 7.5;
        short b;
        // 変数の代入部分でコンパイルエラーになる
        b = a;
        System.out.println("bは" + (b) + "です");
    }
}
