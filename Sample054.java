public class Sample054 {
    public static void main(String[] args) {
        StringBuffer sb =
            new StringBuffer("Hello Java StringBuffer!");
        int len = sb.length();
        System.out.print(sb + "の長さは");
        System.out.println(len + "文字です");
        int cap = sb.capacity();
        System.out.println(sb + "の容量は" + cap + "です");
    }
}
