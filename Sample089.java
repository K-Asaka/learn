// class airplane {
//     private double fuel;
//     private String iro;
//     public void dataset(double num, String str) {
//         fuel = num;
//         iro = str;
//     }
//     public void dataset(double num) {
//         fuel = num;
//     }
//     public void dataset(String str) {
//         iro = str;
//     }
//     public void display() {
//         System.out.print("飛行機の燃料は" + fuel + "です");
//         System.out.println("色は" + iro + "です");
//     }
// }

public class Sample089 {
    public static void main(String[] args) {
        airplane plane = new airplane();
        plane.dataset(100, "赤");
        plane.display();

        plane.dataset(200);
        plane.display();

        plane.dataset("青");
        plane.display();
    }    
}
