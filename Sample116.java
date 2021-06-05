public class Sample116 {
    public static void main(String[] args) {
        System.out.print("利用可能メモリ:");
        System.out.println(Runtime.getRuntime().freeMemory());
        String str = "Hello World!";
        System.out.print("利用可能メモリ:");
        System.out.println(Runtime.getRuntime().freeMemory());

        System.out.println("ガーベジコレクションを強制的に実行します");
        System.gc();

        System.out.print("利用可能メモリ:");
        System.out.println(Runtime.getRuntime().freeMemory());
    }
}
