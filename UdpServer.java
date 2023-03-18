package es.udc.redes.tutorial.udp.server;

import java.net.*;
import java.util.Arrays;

/**
 * Implements a UDP echo server.
 */
public class UdpServer {

    public static void main(String[] argv) {
        if (argv.length != 1) {
            System.err.println("Format: es.udc.redes.tutorial.udp.server.UdpServer <port_number>");
            System.exit(-1);
        }
        DatagramSocket socket=null;
        DatagramPacket respuesta=null;
        byte[] buffer=new byte[1024];
        try {
            socket=new DatagramSocket(Integer.parseInt(argv[0]));
            // Create a server socket
            socket.setSoTimeout(300000);
            // Set maximum timeout to 300 secs
            DatagramPacket petition=new DatagramPacket(buffer, buffer.length);
                // Prepare datagram for reception
            socket.receive(petition);
            buffer="Hola desde el server".getBytes();
                // Receive the message
             respuesta=new DatagramPacket(buffer, 0, buffer.length, petition.getAddress(), petition.getPort());
                // Prepare datagram to send response
              socket.send(respuesta);
                // Send response
            } catch (SocketTimeoutException e) {
                System.err.println("No requests received in 300 secs ");
            } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        } finally{
            assert socket != null;
            socket.close();
        }
    }
}
