public class Sample067_1 {
    public static void main(String[] args) {
        int a1[] = {1, 2, 3};
        int a2[] = new int[3];

        // 配列をコピーする
        System.arraycopy(a1, 0, a2, 0, a1.length);

        // 配列a2の2番目の要素を変更
        a2[1] = 9;

        // 配列a1を表示
        System.out.print("配列a1の要素:");
        for (int i = 0; i < a1.length; i++) {
            System.out.print(a1[i] + " ");
        }

        // 配列a2を表示
        System.out.print("配列a2の要素:");
        for (int i = 0; i < a2.length; i++) {
            System.out.print(a2[i] + " ");
        }
        System.out.println("");
    }
}
