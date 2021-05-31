// class hensu {
//     // クラス変数を宣言
//     public static int num = 0;
// }

public class Sample095 {
    public static void main(String[] args) {
        hensu hen1 = new hensu();
        hensu hen2 = new hensu();
        hen1.num = hen1.num + 1;
        hen2.num = hen2.num + 2;
        System.out.println("クラス変数の値は" + hen1.num + "です");
    }
}
