package com.fibanez.features.network;

import java.net.InetSocketAddress;

/**
 * A socket address contains two parts, an IP address and a port number. An object of the InetSocketAddress class
 * represents a socket address. You can use the following constructors to create an object of the InetSocketAddress class:
 *
 * InetSocketAddress(InetAddress addr, int port)
 * InetSocketAddress(int port)
 * InetSocketAddress(String hostname, int port)
 */
public class InetSocketAddressTest {

    public static void main(String[] args) {
        InetSocketAddress addr1 = new InetSocketAddress("::1", 12889);
        printSocketAddress(addr1);
        InetSocketAddress addr2 = InetSocketAddress.createUnresolved("::1", 12881);
        printSocketAddress(addr2);
    }
    public static void
    printSocketAddress(InetSocketAddress sAddr) {
        System.out.println("Socket Address: " + sAddr.getAddress());
        System.out.println("Socket Host Name: " + sAddr.getHostName());
        System.out.println("Socket Port: " + sAddr.getPort());
        System.out.println("isUnresolved(): " + sAddr.isUnresolved());
        System.out.println();
    }
}
