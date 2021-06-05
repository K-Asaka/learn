public class Sample114 {
    public static void main(String[] args) {
        System.out.print("利用可能メモリ:");
        System.out.println(Runtime.getRuntime().freeMemory());
        String str = "Hello World!";
        System.out.print("利用可能メモリ:");
        System.out.println(Runtime.getRuntime().freeMemory());
    }
}
