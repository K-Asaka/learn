package tcpsample;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer implements Runnable {
    private ServerSocket serverSocket;

    public TCPServer(int port) throws IOException {
        this.serverSocket = new ServerSocket(port);
    }

    public void run() {
        for (;;) {
            System.out.println("#Listen");
            try {
                Socket socket = serverSocket.accept();
                System.out.println(" #Connect");
                new ConnectionHandler(socket).run();
            } catch (IOException e) {
            }
            System.out.println(" #Disconnect");
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Server Start");
        new Thread(new TCPServer(8080)).start();
    }
}
