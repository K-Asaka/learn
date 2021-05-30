public class Sample066_1 {
    public static void main(String[] args) {
        int a[] = {20, 50, 10, 30, 40};
        System.out.println("ソート前の配列");
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
        
        // 配列を昇順にソートする
        sort(a);

        System.out.println("ソート後の配列");
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    public static void sort(int array[]) {
        int i = array.length;
        while (--i >= 0) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    // 値を入れ替える
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
    }
}
