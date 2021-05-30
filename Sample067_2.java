public class Sample067_2 {
    public static void main(String[] args) {
        StringBuffer a1[] = new StringBuffer[3];
        StringBuffer a2[] = new StringBuffer[3];

        // a1の配列に値をセットする
        for (int i = 0; i < a1.length; i++) {
            a1[i] = new StringBuffer(Integer.toString(i));
        }

        // 配列をコピーする
        System.arraycopy(a1, 0, a2, 0, a1.length);

        // 配列a1を表示
        System.out.print("配列a2の要素を変更する前の");
        System.out.print("配列a1の要素:");

        for (int i = 0; i < a1.length; i++) {
            System.out.print(a1[i] + " ");
        }
        System.out.println();

        // 配列a2の2番目の要素を変更
        a2[1].replace(0, 1, "9");

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
