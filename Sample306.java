import java.net.*;
public class Sample306 {
    public static void main(String[] args) {
        System.out.print("http://www.moug.net/cgi?param=aaa & bbb");
        System.out.println("をエンコードします");
        String en = "http://www.moug.net/cgi?param=";
        en += URLEncoder.encode("aaa & bbb");
        System.out.println(en);
    }
}
