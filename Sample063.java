public class Sample063 {
    public static void main(String[] args) {
        // 1次元配列を宣言
        int a[] = new int[3];
        // 1次元配列の要素数を取得
        System.out.print("配列aの素数は");
        System.out.println(a.length + "です");

        // 2次元配列を宣言
        int b[][] = new int[2][3];
        // 2次元配列の要素数を取得
        System.out.print("配列bの要素数(行数)は");
        System.out.println(b.length + "です");
        System.out.print("配列bの要素数(列数)は");
        System.out.println(b[0].length + "です");
    }
}
