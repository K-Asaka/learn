class DataClass {
    public int[] getData() {
        int array[] = {1, 2, 3};
        return array;
    }
}

public class Sample100 {
    public static void main(String[] args) {
        DataClass data = new DataClass();
        // メソッドから配列が返されている
        int array[] = data.getData();
        System.out.print("計算結果は");
        System.out.print((array[0] + array[1] + array[2]));
        System.out.println("です");
    }
}
