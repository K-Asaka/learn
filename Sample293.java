import java.net.*;
public class Sample293 {
    public static void main(String[] args) {
        try {
            InetAddress maddresses[] = InetAddress.getAllByName("localhost");
            for (int i = 0; i < maddresses.length; i++) {
                System.out.println(maddresses[i]);
            }
        } catch (UnknownHostException e) {
            System.out.println("IPアドレスを取得");
        }
    }
}
