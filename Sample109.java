// // 飛行機クラス
// class airplane {
//     private double fuel;
//     private String iro;

//     public airplane() {
//         fuel = 100;
//         iro = "赤";
//         System.out.print("飛行機の燃料は" + fuel + "です ");
//         System.out.println("色は" + iro + "です");
//     }
// }

// 自動車クラス
class car {
    private double fuel;
    private String iro;

    public car() {
        fuel = 10;
        iro = "青";
        System.out.print("自動車の燃料は" + fuel + "です ");
        System.out.println("色は" + iro + "です");
    }
}

public class Sample109 {
    public static void main(String[] args) {
        airplane a = new airplane();
        // オブジェクトaのクラスの情報を取得
        System.out.print("このオブジェクトのクラスは");
        System.out.println(a.getClass() + "です");

        car b = new car();
        // オブジェクトbのクラスの情報を取得
        System.out.print("このオブジェクトのクラスは");
        System.out.println(b.getClass() + "です");
    }
}
