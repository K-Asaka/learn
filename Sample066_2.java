public class Sample066_2 {
    public static void main(String[] args) {
        int a[] = {20, 50, 10, 30, 40};
        System.out.println("ソート前の配列");
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
        
        // 配列を降順にソートする
        sort(a, 0, a.length - 1);

        System.out.println("ソート後の配列");
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    static void sort(int array[], int start, int end) {
        int low = start;
        int high = end;
        if (start >= end) {
            return;
        }
        int mid = array[(start + end) / 2];
        do {
            while (array[low] > mid) {
                low++;
            }
            while (array[high] < mid) {
                high--;
            }
            if (low <= high) {
                int temp = array[low];
                array[low++] = array[high];
                array[high--] = temp;
            }
        } while (low <= high);
        sort(array, start, high);
        sort(array, low, end);
    }
}
