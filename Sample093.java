class airplane {
    private double fuel;
    private String iro;

    // デフォルトコンストラクタを明示的に宣言
    public airplane() {
    }

    public void display() {
        System.out.print("飛行機の燃料は" + fuel + "です");
        System.out.println("色は" + iro + "です");
    }
}

public class Sample093 {
    public static void main(String[] args) {
        // デフォルトコンストラクタが呼び出される
        airplane plane = new airplane();
        plane.display();        
    }
}
