package com.fibanez.features.network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * n object of the ServerSocket class represents a TCP server socket. A ServerSocket object is used to accept a
 * connection request from a remote client. The ServerSocket class provides many constructors. You can use the
 * no-args constructor to create an unbound server socket and use its bind() method to bind it to a local port
 * and a local IP address.
 * <p>
 * You can combine the create, bind, and listen operations in one step by using any of the following constructors of the
 * ServerSocket class . The default value for the wait queue size is 50. The default value for a local IP address is the
 * wildcard address, which means all IP addresses of the server machine.
 * <p>
 * ServerSocket(int port)
 * ServerSocket(int port, int waitQueueSize)
 * ServerSocket(int port, int waitQueueSize, InetAddress bindAddr)
 */
public class TCPEchoServer {

    public static void main(String[] args) {
        try {
            // Create a Server socket
            ServerSocket serverSocket = new ServerSocket(12900, 100, InetAddress.getByName("localhost"));
            System.out.println("Server started at: " + serverSocket);

            // Keep accepting client connections in an
            // infinite loop
            while (true) {
                System.out.println("Waiting for a connection...");

                // Accept a connection
                final Socket activeSocket = serverSocket.accept();
                System.out.println("Received a connection from " + activeSocket);

                // Create a new thread to handle the new
                // connection
                Runnable runnable = () -> handleClientRequest(activeSocket);
                new Thread(runnable).start();
                // <- start a new thread
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void handleClientRequest(Socket socket) {
        BufferedReader socketReader = null;
        BufferedWriter socketWriter = null;
        try {
            // Create a buffered reader and writer for
            // the socket
            socketReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            socketWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            String inMsg = null;
            while ((inMsg = socketReader.readLine())
                    != null) {
                System.out.println("Received from client: " + inMsg);

                // Echo the received message to the client
                String outMsg = inMsg;
                socketWriter.write(outMsg);
                socketWriter.write("\n");
                socketWriter.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
