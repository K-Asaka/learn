public class Sample018 {
    public static void main(String[] args) {
        // 変数を宣言し初期値を設定する
        // この「=」が基本的な代入演算子
        int a = 20;
        int b = 20;
        int c = 20;
        int d = 20;
        int e = 20;
        int f = 4;

        // 演算を行う
        System.out.println("a += f は" + (a += f) + " です");
        System.out.println("b -= f は" + (b -= f) + " です");
        System.out.println("c *= f は" + (c *= f) + " です");
        System.out.println("d /= f は" + (d /= f) + " です");
        System.out.println("e %= f は" + (e %= f) + " です");
    }
}
