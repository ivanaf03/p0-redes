package es.udc.redes.tutorial.tcp.server;
import java.net.*;
import java.io.*;

/** Thread that processes an echo server connection. */

public class ServerThread extends Thread {

  private final Socket socket;

  public ServerThread(Socket s) {
    this.socket=s;
  }

  public void run() {
    PrintWriter out;
    BufferedReader in;
    try {
      in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      // Set the input channel
      out = new PrintWriter(socket.getOutputStream(), true);
      // Set the output channel
      String mensaje;
      // Receive the message from the client
      while ((mensaje = in.readLine()) != null) {
        System.out.println("Server received: " + mensaje + ". Sending to client");
        out.println(mensaje);
      }
      // Sent the echo message to the client
      in.close();
      out.close();
      // Close the streams
    // Uncomment next catch clause after implementing the logic
     } catch (SocketTimeoutException e) {
      System.err.println("Nothing received in 300 secs");
    } catch (Exception e) {
      System.err.println("Error: " + e.getMessage());
      } finally{
      try {
        socket.close();
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }
  }
}
