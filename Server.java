import java.net.*;
import java.io.*;
public class Server {
    public static void main(String[] ar) {
        try {
            ServerSocket ss = new ServerSocket(5562); // Creating server socket with specified port
            while (!ss.isClosed()) {
                Socket socket = ss.accept(); // Waiting while client will be connect
                MonoClient client_prepare = new MonoClient(socket);
                Thread client = new Thread(client_prepare);
                client.start();
                System.out.println("User connected to server. IP:" + socket.getRemoteSocketAddress().toString().replace("/", "")); // Get user IP and print text about he connected
            }
        } catch (Exception x) {
            x.printStackTrace();
        }
    }
}