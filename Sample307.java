import java.net.*;
public class Sample307 {
    public static void main(String[] args) {
        System.out.print("http://www.moug.net/cgi?param=aaa+%26+bbb");
        System.out.println("をデコードします");
        String de = URLDecoder.decode("http://www.moug.net/cgi?param=aaa+%26+bbb");
        System.out.println(de);
    }
}
