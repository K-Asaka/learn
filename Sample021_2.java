public class Sample021_2 {
    public static void main(String[] args) {
        double a = 7.5;
        short b;
        // キャストしているのでコンパイルエラーにならない
        b = (short)a;
        System.out.println("bは" + (b) + "です");
    }
}
