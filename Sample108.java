// 飛行機クラス（スーパークラス)
// 抽象クラス
abstract class airplane {
    protected double fuel;
    protected String iro;

    // 抽象メソッド
    public abstract void display();

    public void setdata(double num, String str) {
        fuel = num;
        iro = str;
    }
}
// ジャンボジェット機クラス(サブクラス)
class jumbojet extends airplane {
    // 抽象メソッドを宣言している
    public void display() {
        System.out.print("飛行機の燃料は" + fuel + "です ");
        System.out.print("色は" + iro + "です ");
    }
}
public class Sample108 {
    public static void main(String[] args) {
        jumbojet jumbo = new jumbojet();
        jumbo.setdata(100, "赤");
        jumbo.display();
    }
}
