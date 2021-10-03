import java.net.*;
public class Sample292 {
    public static void main(String[] args) {
        try {
            InetAddress ia = InetAddress.getByName("127.0.0.1");
            System.out.println(ia.getHostName());
        } catch (Exception e) {
            System.out.println("例外" + e + "が発生しました");
        }
    }
}
