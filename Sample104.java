// // 飛行機クラス(スーパークラス)
// class airplane {
//     protected double fuel;
//     protected String iro;

//     public void setdata(double num, String str) {
//         fuel = num;
//         iro = str;
//     }
// }

// // ジャンボジェット機クラス(サブクラス)
// class jumbojet extends airplane {
//     private int runway;

//     public void setrunway(int way) {
//         runway = way;
//     }

//     public void display() {
//         System.out.print("飛行機の燃料は" + fuel + "です ");
//         System.out.print("色は" + iro + "です ");
//         System.out.println("滑走路は" + runway + "番です");
//     }
// }

public class Sample104 {
    public static void main(String[] args) {
        jumbojet jumbo = new jumbojet();
        jumbo.setdata(100, "赤");
        jumbo.setrunway(1);
        jumbo.display();
    }
}
