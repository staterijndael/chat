import java.net.*;
import java.io.*;
public class Client {
    public static void main(String[] ar) {
        int port = 5565;
        String adr = "127.0.0.1";
        try {
            InetAddress adress = InetAddress.getByName(adr);
            Socket socket = new Socket(adress,port);

            System.out.println("You successfully connected to the server");

            InputStream sin = socket.getInputStream();
            OutputStream sout = socket.getOutputStream();

            DataInputStream in = new DataInputStream(sin);
            DataOutputStream out = new DataOutputStream(sout);
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Waiting message to sending it to the server: ");
            while(true){
                String line = reader.readLine();
                System.out.println("Sending message to the server");
                out.writeUTF(line);
                out.flush();
            }
        }
        catch(Exception x){x.printStackTrace();}
    }
}
