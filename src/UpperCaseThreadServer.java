import java.net.ServerSocket;
import java.net.Socket;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.IOException;

class UpperCaseHandler extends Thread {
    Socket client;
    int number;

    public UpperCaseHandler(Socket s, int n) {
        client = s;
        number = n;
    }

    public void run() {
        try (
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);
            Scanner sc = new Scanner(client.getInputStream());
        ) {
            out.println("Hello, client No. " + number + "! Enter bye to exit.");
            while (sc.hasNextLine()) {
                String message = sc.nextLine();
                System.out.println("(client No. " + number + "):" + message);
                if (message.equals("bye")) {
                    break;
                }
                out.println(message.toUpperCase());
            }
            out.println("Good bye!");
            client.close();
        } catch (Exception e) {
            System.err.println("エラーが発生しました: " + e);
        }
    }
}

class UpperCaseThreadServer {
    public static void main(String[] args) {
        int n = 1;
        try (ServerSocket server = new ServerSocket(49152);) {
            while (true) {
                Socket client = server.accept();
                System.out.println("accept client No. " + n);
                new UpperCaseHandler(client, n).start();
                n++;
            }
        } catch (IOException e) {
            System.err.println("エラーが発生しました: " + e);
        }
    }
}