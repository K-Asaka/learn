class compute {
    public void add(int data[]) {
        // オブジェクトのメンバであるフィールドにアクセスしている
        System.out.print("計算結果は");
        System.out.print((data[0] + data[1] + data[2]));
        System.out.println("です");
    }
}
public class Sample099 {
    public static void main(String[] args) {
        int array[] = {1, 2, 3};
        compute comp = new compute();
        // 配列を渡している
        comp.add(array);
    }
}
