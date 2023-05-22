package tcpsample;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MTCPServer implements Runnable {
    private ServerSocket serverSocket;

    public MTCPServer(int port) throws IOException {
        this.serverSocket = new ServerSocket(port);
    }

    public void run() {
        for (;;) {
            System.out.println("#Listen");
            try {
                Socket socket = serverSocket.accept();
                System.out.println(" #Connect");
                new Thread(new ConnectionHandler(socket)).start();
            } catch (IOException e) {
            }
            System.out.println(" #Disconnect");
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Server Start");
        new Thread(new MTCPServer(8080)).start();
    }
}
