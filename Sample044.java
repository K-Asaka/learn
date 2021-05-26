public class Sample044 {
    public static void main(String[] args) {
        String s = "Hello Java String!";
        
        // 最初に現れる'o'の位置を検索する
        System.out.println(s.indexOf('o'));
        // 9文字目以降の最初に現れる'a'の位置を検索する
        System.out.println(s.indexOf('a', 8));
        // 存在しない文字を指定すると-1が返される
        System.out.println(s.indexOf('z'));
    }
}
