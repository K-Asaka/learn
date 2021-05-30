class airplane {
    double fuel;
    String iro;
    // 引数を持つメソッドを宣言
    void dataset(double num, String str) {
        fuel = num;
        iro = str;
    }
    // double型を返すメソッドを宣言
    double getfuel() {
        return fuel;
    }    
    // String型を返すメソッドを宣言
    String getiro() {
        return iro;
    }
}

public class Sample084 {
    public static void main(String[] args) {
        airplane plane = new airplane();
        plane.dataset(100, "赤");

        // double型を返すメソッドを呼び出す
        double num = plane.getfuel();
        System.out.println("飛行機の燃料は" + num + "です");

        // String型を返すメソッドを呼び出す
        String str = plane.getiro();
        System.out.println("飛行機の色は" + str + "です");
    }
}
