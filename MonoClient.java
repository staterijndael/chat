import java.net.*;
import java.io.*;

public class MonoClient implements  Runnable {
    private static Socket socket;

    public MonoClient(Socket socket) {
        this.socket = socket;
    }
    @Override
    public void run() {
        try {
            InputStream sin = socket.getInputStream();
            OutputStream sout = socket.getOutputStream();

            DataInputStream in = new DataInputStream(sin);
            DataOutputStream out = new DataOutputStream(sout);

            while (!socket.isClosed()) { // Creating main stream
                String line = in.readUTF();
                System.out.println("User printed(" + socket.getRemoteSocketAddress().toString().replace("/", "") + "):" + line);
                out.writeUTF("Your message successfully sent");
                out.flush(); // Stop data sending
            }
            socket.close(); // |
            sin.close();    // | Close all data
            sout.close();   // |
        } catch (Exception x) {
            x.printStackTrace();
        }
    }
}