class airplane {
    private double fuel;
    private String iro;

    public airplane() {
        fuel = 0;
        iro = "未指定";
    }

    public airplane(double num) {
        // 引数のないコンストラクタを呼び出す
        this();
        fuel = num;
    }

    public void display() {
        System.out.print("飛行機の燃料は" + fuel + "です");
        System.out.println("色は" + iro + "です");
    }
}

public class Sample092 {
    public static void main(String[] args) {
        airplane plane = new airplane(100);
        plane.display();
    }
}