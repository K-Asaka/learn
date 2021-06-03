// // 飛行機クラス(スーパークラス)
// class airplane {
//     private double fuel;
//     private String iro;

//     public void setdata(double num, String str) {
//         fuel = num;
//         iro = str;
//     }

//     public void display() {
//         System.out.print("飛行機の燃料は" + fuel + "です");
//         System.out.println("色は" + iro + "です");
//     }
// }

// // ジャンボジェット機クラス(サブクラス)
// class jumbojet extends airplane {
//     private int runway;

//     public void setrunway(int way) {
//         runway = way;
//     }

//     public void displayrunway() {
//         System.out.println("滑走路は" + runway + "番です");
//     }
// }
public class Sample103 {
    public static void main(String[] args) {
        jumbojet jumbo = new jumbojet();
        jumbo.setdata(100, "赤");
        jumbo.display();
        jumbo.setrunway(1);
        jumbo.displayrunway();
    }
}
