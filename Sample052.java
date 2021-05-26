public class Sample052 {
    public static void main(String[] args) {
        StringBuffer sb =
            new StringBuffer("Hello Java StringBuffer!");
        System.out.println(sb);

        // 変更前の文字を取得
        System.out.println("変更前の文字 : " + sb.charAt(6));

        // 文字を変更
        sb.setCharAt(6, 'j');

        System.out.println(sb);
    }
}
