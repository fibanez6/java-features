package com.fibanez.features.network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * A DatagramPacket contains three things: a destination IP address, a destination port number, and the data. The
 * constructors for the DatagramPacket class fall into two categories. Constructors in one of the categories let
 * you create a DatagramPacket object to receive a packet. They require only the buffer size, offset, and length
 * of data in that buffer. Constructors in the other category let you create a DatagramPacket object to send a packet.
 * They require you to specify the destination address along with the data. If you have created a DatagramPacket without
 * specifying the destination address, you can set the destination address afterward using the setAddress() and setPort()
 * methods .
 * <p>
 * Constructors of the DatagramPacket class to create a packet to receive data are as follows:
 * <p>
 * DatagramPacket(byte[] buffer, int length)
 * DatagramPacket(byte[] buffer, int offset, int length)
 * <p>
 * Constructors of the DatagramPacket class to create a packet to send data are as follows:
 * <p>
 * DatagramPacket(byte[] buffer, int length, InetAddress address, int port)
 * DatagramPacket(byte[] buffer, int offset, int length, InetAddress address, int port)
 * DatagramPacket(byte[] buffer, int length, SocketAddress address)
 * DatagramPacket(byte[] buffer, int offset, int length, SocketAddress address)
 * <p>
 * Creating an echo server using UDP is very easy. It takes only four lines of real code. Use the following steps to create a UDP echo server:
 * <p>
 * - Create a DatagramSocket object to represent a UDP socket.
 * - Create a DatagramPacket object to receive the packet from a remote client.
 * - Call the receive() method of the socket to wait for a packet to arrive.
 * - Call the send() method of the socket passing the same packet that you received.
 */
public class UDPEchoServer {

    public static void main(String[] args) {
        final int LOCAL_PORT = 15900;
        final String SERVER_NAME = "localhost";
        try {
            DatagramSocket udpSocket = new DatagramSocket(LOCAL_PORT, InetAddress.getByName(SERVER_NAME));
            System.out.println("Created UDP server socket at " + udpSocket.getLocalSocketAddress() + "...");

            // Wait for a message in a loop and echo the
            // same message to the sender
            while (true) {
                System.out.println("Waiting for a UDP packet to arrive...");

                // Prepare a packet to hold the received
                // data
                DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);

                // Receive a packet
                udpSocket.receive(packet);

                // Print the packet details
                displayPacketDetails(packet);

                // Echo the same packet to the sender
                udpSocket.send(packet);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void
    displayPacketDetails(DatagramPacket packet) {
        // Get the message
        byte[] msgBuffer = packet.getData();
        int length = packet.getLength();
        int offset = packet.getOffset();
        int remotePort = packet.getPort();
        InetAddress remoteAddr = packet.getAddress();

        String msg = new String(msgBuffer, offset, length);
        System.out.println("Received a packet:[IP Address=" + remoteAddr + ", port=" + remotePort + ", message=" + msg + "]");
    }
}
