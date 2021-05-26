public class Sample058 {
    public static void main(String[] args) {
        StringBuffer sb =
            new StringBuffer("Hello Java StringBuffer!");
        sb.replace(7, 10, "AVA");
        System.out.println(sb);
    }
}
