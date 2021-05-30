public class Sample073 {
    public static void main(String[] args) {
        try {
            throw new TestException();
        } catch (TestException e) {
            System.out.print("例外" + e);
            System.out.println("を受け取りました");
        }
    }
}

class TestException extends Exception {
    TestException() {
        System.out.println("独自の例外クラスのコンストラクタ");
    }
}
