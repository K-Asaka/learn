class airplane {
    private double fuel;
    private String iro;
    void dataset(double num, String str) {
        fuel = num;
        iro = str;
    }
    double getfuel() {
        return fuel;
    }
    String getiro() {
        return iro;
    }
}

public class Sample087_2 {
    public static void main(String[] args) {
        airplane plane = new airplane();
        plane.dataset(100, "赤");
        double num = plane.getfuel();
        System.out.println("飛行機の燃料は" + num + "です");
        String str = plane.getiro();
        System.out.println("飛行機の色は" + str + "です");
    }
}
