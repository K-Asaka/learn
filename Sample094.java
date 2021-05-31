// class airplane {
//     private double fuel;
//     private String iro;

//     // private修飾子を指定したコンストラクタ
//     private airplane() {
//         fuel = 0;
//         iro = "未指定";
//     }

//     // public修飾子をを指定したコンストラクタ
//     public airplane(double num) {
//         // private修飾子を指定したコンストラクタを呼び出す
//         this();
//         fuel = num;
//     }

//     public void display() {
//         System.out.print("飛行機の燃料は" + fuel + "です");
//         System.out.println("色は" + iro + "です");
//     }
// }

public class Sample094 {
    public static void main(String[] args) {
        // public修飾子を指定したコンストラクタを呼び出す
        airplane plane = new airplane(100);
        plane.display();
    }
}
