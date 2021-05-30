public class Sample062 {
    public static void main(String[] args) {
        // 配列を宣言
        int a[][];
        // 配列要素を確保
        a = new int[2][3];
        // 配列要素に値を代入
        a[0][0] = 10;
        a[0][1] = 20;
        a[0][2] = 30;
        a[1][0] = 40;
        a[1][1] = 50;
        a[1][2] = 60;
        // 配列要素を表示
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("配列の" + (i + 1) + "行、");
                System.out.print((j + 1) + "列目の配列の値は");
                System.out.println(a[i][j] + "です");
            }
        }
    }
}
