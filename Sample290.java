import java.net.*;
public class Sample290 {
    public static void main(String[] args) {
        try {
            InetAddress myaddress = InetAddress.getLocalHost();
            System.out.println(myaddress);
        } catch (UnknownHostException e) {
            System.out.println("IPアドレスを取得できませんでした");
        }
    }
}
