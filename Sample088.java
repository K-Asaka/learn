// class airplane {
//     private double fuel;
//     private String iro;
//     public void dataset(double num, String str) {
//         fuel = num;
//         iro = str;
//     }
//     public double getfuel() {
//         return fuel;
//     }
//     public String getiro() {
//         return iro;
//     }
// }

class Sample088 {
    public static void main(String[] args) {
        airplane plane = new airplane();
        plane.dataset(100, "赤");
        double num = plane.getfuel();
        System.out.println("飛行機の燃料は" + num + "です");
        String str = plane.getiro();
        System.out.println("飛行機の色は" + str + "です");
    }
}
