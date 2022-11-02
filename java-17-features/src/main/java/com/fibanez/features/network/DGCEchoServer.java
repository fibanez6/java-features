package com.fibanez.features.network;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

/**
 * An instance of the java.nio.channels.DatagramChannel class represents a datagram channel. By default, it is blocking.
 * You can configure it to be non-blocking by using the configureBlocking(false) method.
 * <p>
 * To create a DatagramChannel, you need to invoke one of its open() static methods. If you want to use it for IP multicasting,
 * you need to specify the address type (or protocol family) of the multicast group as an argument to its open() method.
 * The open() method creates a DatagramChannel, which is not connected. If you want your datagram channel to send and receive
 * datagrams only to a specific remote host, you need to use its connect() method to connect the channel to that specific host.
 * A datagram channel that is not connected may send datagrams to and receive datagrams from any remote host. The following
 * sections outline the steps that are typically needed to send/receive datagrams using a datagram channel.
 */
public class DGCEchoServer {

    public static void main(String[] args) {
        // Create a datagram channel and bind it to
        // localhost at port 8989
        try (DatagramChannel server = DatagramChannel.open()) {
            InetSocketAddress sAddr = new InetSocketAddress("localhost", 8989);
            server.bind(sAddr);
            ByteBuffer buffer = ByteBuffer.allocate(1024);

            // Wait in an infinite loop for a client to
            // send data
            while (true) {
                System.out.println("Waiting for a message from a remote host at " + sAddr);

                // Wait for a client to send a message
                SocketAddress remoteAddr = server.receive(buffer);

                // Prepare the buffer to read the message
                buffer.flip();

                // Convert the buffer data into a String
                int limits = buffer.limit();
                byte bytes[] = new byte[limits];
                buffer.get(bytes, 0, limits);
                String msg = new String(bytes);
                System.out.println("Client at " + remoteAddr + " says: " + msg);

                // Reuse the buffer to echo the message to
                // the client
                buffer.rewind();

                // Send the message back to the client
                server.send(buffer, remoteAddr);

                // Prepare the buffer to receive the next
                // message
                buffer.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}