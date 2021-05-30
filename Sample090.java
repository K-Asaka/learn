// class airplane {
//     private double fuel;
//     private String iro;

//     // コンストラクタを宣言する
//     public airplane() {
//         fuel = 0;
//         iro = "未指定";
//     }

//     public void display() {
//         System.out.print("飛行機の燃料は" + fuel + "です");
//         System.out.println("色は" + iro + "です");
//     }
// }

public class Sample090 {
    public static void main(String[] args) {
        // コンストラクタが呼び出される
        airplane plane = new airplane();
        
        plane.display();
        
    }
}
