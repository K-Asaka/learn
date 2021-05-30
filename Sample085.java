public class Sample085 {
    public static void main(String[] args) {
        airplane plane = new airplane();
        plane.fuel = 100;
        plane.iro = "赤";
        System.out.println("飛行機の燃料は" + plane.fuel + "です");
        System.out.println("飛行機の色は" + plane.iro + "です");
    }
}
