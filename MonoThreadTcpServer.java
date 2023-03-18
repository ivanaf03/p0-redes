package es.udc.redes.tutorial.tcp.server;

import java.net.*;
import java.io.*;

/**
 * MonoThread TCP echo server.
 */
public class MonoThreadTcpServer {

    public static void main(String[] argv) throws IOException {
        Socket socket=null;
        if (argv.length != 1) {
            System.err.println("Format: es.udc.redes.tutorial.tcp.server.MonoThreadTcpServer <port>");
            System.exit(-1);
        }
        try {
            ServerSocket serverSocket = new ServerSocket(Integer.parseInt(argv[0]));
            // Create a server socket
            serverSocket.setSoTimeout(300000);
            // Set a timeout of 300 secs
            
            while (true) {
                socket=serverSocket.accept();
                // Wait for connections
                InputStreamReader isr = new InputStreamReader(socket.getInputStream());
                BufferedReader in = new BufferedReader(isr);
                // Set the input channel
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                // Set the output channel
                String mensaje;
                while ((mensaje=in.readLine()) != null) {
                    System.out.println("Server received: " + mensaje + ". Sending to client");
                    // Receive the client message
                    // Send response to the client
                    out.println(mensaje);
                }
                // Close the streams
                in.close();
                out.close();
            }
        // Uncomment next catch clause after implementing the logic
        } catch (SocketTimeoutException e) {
            System.err.println("Nothing received in 300 secs ");
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        } finally{
            assert socket != null;
            socket.close();
        }
    }
}
