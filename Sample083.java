// class airplane {
//     double fuel;
//     String iro;
//     // 引数を持つメソッドを宣言
//     void dataset(double num, String str) {
//         fuel = num;
//         iro = str;
//     }
// }

public class Sample083 {
    public static void main(String[] args) {
        airplane plane = new airplane();

        // 引数を持つメソッドを呼び出す
        plane.dataset(100, "赤");

        System.out.println("飛行機の燃料は" + plane.fuel + "です");
        System.out.println("飛行機の色は" + plane.iro + "です");
    }
}
