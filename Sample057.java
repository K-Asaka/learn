public class Sample057 {
    public static void main(String[] args) {
        StringBuffer sb =
            new StringBuffer("Hello Java StringBuffer!");
        sb.delete(6, 10);
        System.out.println(sb);
    }
}
