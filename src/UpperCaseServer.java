import java.net.ServerSocket;
import java.net.Socket;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.IOException;

class UpperCaseServer {
    public static void main(String[] args) {
        try (
            ServerSocket server = new ServerSocket(49152);
            Socket client = server.accept();
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);
            Scanner sc = new Scanner(client.getInputStream());
        ) {
            out.println("Hello, client! Enter 'bye' to exit.");
            while (sc.hasNextLine()) {
                String message = sc.nextLine();
                System.out.println("message = " + message);
                if (message.equals("bye")) {
                    break;
                }
                out.println(message.toUpperCase());
            }
            out.println("Good bye!");
            client.close();
        } catch (IOException e) {
            System.err.println("エラーが発生しました: " + e);
        }
    }
}
