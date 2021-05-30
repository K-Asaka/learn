// class airplane {
//     private double fuel;
//     private String iro;
//     void dataset(double num, String str) {
//         fuel = num;
//         iro = str;
//     }
// }

public class Sample087_1 {
    public static void main(String[] args) {
        airplane plane = new airplane();
        plane.dataset(100, "赤");

        System.out.print("飛行機の燃料は");
        System.out.println(plane.fuel + "です");
        System.out.print("飛行機の色は");
        System.out.println(plane.iro + "です");
    }
}
