class airplane {
    double fuel;
    String iro;

    // メソッドを宣言する
    void dataset() {
        fuel = 100;
        iro = "赤";
    }
}

public class Sample082 {
    public static void main(String[] args) {
        airplane plane = new airplane();

        // メソッドを呼び出す
        plane.dataset();

        System.out.println("飛行機の燃料は" + plane.fuel + "です");
        System.out.println("飛行機の色は" + plane.iro + "です");
    }
}
