import java.net.*;
public class Sample291 {
    public static void main(String[] args) {
        try {
            InetAddress shuwaaddress = InetAddress.getByName("www.google.com");
            System.out.println(shuwaaddress);
        } catch (UnknownHostException e) {
            System.out.println("IPアドレスを取得できませんでした");
        }
    }
}
