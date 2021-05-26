public class Sample053 {
    public static void main(String[] args) {
        StringBuffer sb =
            new StringBuffer("Hello Java StringBuffer!");
        int len = sb.length();
        System.out.print(sb + "の長さは");
        System.out.println(len + "文字です");
        sb.setLength(len - 7);
        System.out.println("末尾の7文字を切り捨てました " + sb);
    }
}
