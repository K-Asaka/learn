public class Sample060 {
    public static void main(String[] args) {
        // Stringクラスの文字列を作成
        String s1 = "StringBufferに変換";
        // Stringクラス→StringBufferクラスの変換
        StringBuffer sb1 = new StringBuffer(s1);
        System.out.println(sb1);

        // StringBufferクラスの文字列を作成
        StringBuffer sb2 = new StringBuffer("Stringに変換");
        // StringBufferクラス→Stringクラスの変換
        String s2 = sb2.toString();
        System.out.println(s2);
    }
}
