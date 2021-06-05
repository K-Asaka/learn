// インターフェースを宣言
interface display {
    // フィールドを宣言(定数)
    int num1 = 100;
    int num2 = 10;
    // メソッドを宣言(抽象メソッド)
    void disp();
}
// インターフェースを実装
class plus implements display {
    public void disp() {
        System.out.print(num1 + " + " + num2 + " = ");
        System.out.println((num1 + num2) + "です");
    }
}
// インターフェースを実装
class minus implements display {
    public void disp() {
        System.out.print(num1 + " - " + num2 + " = ");
        System.out.println((num1 - num2) + "です");
    }
}

public class Sample112 {
    public static void main(String[] args) {
        plus obj1 = new plus();
        obj1.disp();
        minus obj2 = new minus();
        obj2.disp();        
    }
}
