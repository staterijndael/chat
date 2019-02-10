import java.net.*;
import java.io.*;
public class Server {
    public static void main(String[] ar) {
        try {
            ServerSocket ss = new ServerSocket(5565); // Creating server socket with specified port
            Socket socket = ss.accept(); // Waiting while client will be connect

            System.out.println("User connected to server. IP:" + socket.getRemoteSocketAddress().toString()); // Get user IP and print text about he connected

            InputStream sin = socket.getInputStream();
            OutputStream sout = socket.getOutputStream();

            DataInputStream in = new DataInputStream(sin);
            DataOutputStream out = new DataOutputStream(sout);

            while(true) { // Creating main stream
                String line = in.readUTF();
                System.out.println("User printed(" + socket.getRemoteSocketAddress().toString() + "):" + line);
                out.writeUTF("Your message successfully sent");
                out.flush(); // Stop data sending
            }
        } catch (Exception x) {x.printStackTrace();}
    }
}
