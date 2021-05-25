public class Sample039 {
    public static void main(String[] args) {
        System.out.print("コマンドラインパラメータを");
        System.out.println("表示します");

        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }
    }
}
