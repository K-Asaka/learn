// class airplane {
//     private double fuel;
//     private String iro;

//     // 引数のないコンストラクタを宣言
//     public airplane() {
//         fuel = 0;
//         iro = "未指定";
//     }

//     // 引数のあるコンストラクタを宣言
//     public airplane(double num, String str) {
//         fuel = num;
//         iro = str;
//     }
    
//     public void display() {
//         System.out.print("飛行機の燃料は" + fuel + "です");
//         System.out.println("色は" + iro + "です");
//     }
// }

public class Sample091 {
    public static void main(String[] args) {
        // 引数のないコンストラクタが呼び出される
        airplane plane1 = new airplane();
        plane1.display();

        // 引数のあるコンストラクタが呼び出される
        airplane plane2 = new airplane(100, "赤");
        plane2.display();
    }
}
