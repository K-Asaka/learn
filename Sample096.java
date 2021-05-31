class hensu {
    private static int num = 10;

    // クラスメソッドを宣言
    static int display() {
        return num;
    }
}

public class Sample096 {
    public static void main(String[] args) {
        // クラスメソッドを呼び出す
        int hen = hensu.display();

        System.out.println("クラス変数の値は" + hen + "です");
    }
}
