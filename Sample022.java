public class Sample022 {
    public static void main(String[] args) {
        int a = 10;

        if (a == 10) {
            // 条件に一致しているので実行される
            System.out.println("aは10です");
        }

        if (a == 20) {
            System.out.println("aは20です");
        } else {
            // 条件に一致しているので実行される
            System.out.println("aは20ではありません");
        }

        if (a == 20) {
            System.out.println("aは20です");
        } else if (a == 30) {
            System.out.println("aは30です");
        } else {
            // 条件に一致しているので実行される
            System.out.println("aは20でも30でもありません");
        }
    }
}
