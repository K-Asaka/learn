package tcpsample;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ConnectionHandler implements Runnable {
    private Socket socket;
    public ConnectionHandler(Socket socket) {
        this.socket = socket;
    }
    public void run() {
        handleConversation(socket);
    }
    public void handleConversation(Socket socket) {
        try {
            String msg = "Server Message\n";
            InputStream in = socket.getInputStream();
            OutputStream out = socket.getOutputStream();
            while (true) {
                for (int i = 0; i < msg.length(); i++) {
                    out.write((byte)msg.charAt(i));
                }
                out.flush();
            }
        } catch (IOException e) {
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
            }
        }
    }
}
