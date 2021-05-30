public class Sample061 {
    public static void main(String[] args) {
        // 配列を宣言
        int a[];
        // 排列要素を格納するためのメモリ領域を確保
        a = new int[3];
        // 配列要素に値を代入
        a[0] = 10;
        a[1] = 20;
        a[2] = 30;
        // 排列要素を表示
        for (int i = 0; i < 3; i++) {
            System.out.print("配列の" + (i + 1) + "番目の配列の値は");
            System.out.println(a[i] + "です");
        }
    }
}
