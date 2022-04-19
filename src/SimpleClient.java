import java.net.Socket;
import java.net.UnknownHostException;
import java.io.IOException;
import java.util.Scanner;

class SimpleClient {
    public static void main(String[] args) {
        try (Socket soc = new Socket("localhost", 49152);) {
            Scanner sc = new Scanner(soc.getInputStream());

            while (sc.hasNext()) {
                String message = sc.nextLine();
                System.out.println("Server: " + message);
                if (message.equals("bye!")) {
                    break;
                }
            }
        } catch (UnknownHostException e) {
            System.err.println("ホストのIPアドレスが判定できません: " + e);
        } catch (IOException e) {
            System.err.println("エラーが発生しました: " + e);
        }
    }
}
