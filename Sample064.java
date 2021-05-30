public class Sample064 {
    public static void main(String[] args) {
        // 1次元配列を初期化
        int a[] = {10, 20, 30};
        System.out.println("1次元配列要素を表示");
        for (int i = 0; i < a.length; i++) {
            System.out.print((i + 1) + "番目の配列の値は");
            System.out.println(a[i] + "です");
        }

        // 2次元配列を初期化
        int b[][] = {{10, 20, 30}, {40, 50, 60}};
        System.out.println("2次元配列要素を表示");
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                System.out.print((i + 1) + "行、");
                System.out.print((j + 1) + "列目の配列の値は");
                System.out.println(b[i][j] + "です");
            }
        }
    }
}
