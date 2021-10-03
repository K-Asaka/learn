import java.net.*;
import java.io.*;
public class Sample322 {
    public static void main(String[] args) {
        String hostName = "localhost";
        if (args.length > 0) {
            hostName = args[0];
        }
        // 0～100のポートをスキャンします
        for (int i = 0; i < 100; i++) {
            System.out.print("\r" + i + "番のポートをスキャン中");
            try {
                Socket s = new Socket(hostName, i);
                System.out.println("\r" + i + "番のポートを使用中です");
                s.close();
            } catch (Exception e) {
                continue;
            }
        }
        System.out.print("\r" + "ポートスキャンを終了しました");
    }
}
