public class Sample065 {
    public static void main(String[] args) {
        int a[] = {10, 20, 30, 40, 50};

        // 要素10の配列での位置を検索する
        System.out.print("10は配列の");
        System.out.println(arraysearch(a, 10) + "番目です");

        // 要素40の配列での位置を検索する
        System.out.print("40は配列の");
        System.out.println(arraysearch(a, 40) + "番目です");

        // 要素60の配列での位置を検索するが、
        // 見つからないため-1が返される
        System.out.print("60は配列の");
        System.out.println(arraysearch(a, 60) + "番目です");
    }

    public static int arraysearch(int array[], int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                // 配列での位置を返す
                return (i + 1);
            }
        }
        // 見つからない場合は-1を返す
        return (-1);
    }
}
