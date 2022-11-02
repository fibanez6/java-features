package com.fibanez.features.network;

import java.io.IOException;
import java.net.InetAddress;

/**
 * An object of the InetAddress class represents an IP address. It has two subclasses, Inet4Address and Inet6Address,
 * which represent IPv4 and IPv6 addresses, respectively. The InetAddress class does not have a public constructor.
 * It provides the following factory methods to create its object. They are as follows—all of them throw a checked
 * UnknownHostException :
 * <p>
 * static InetAddress[] getAllByName(String host)
 * static InetAddress getByAddress(byte[] addr)
 * static InetAddress getByAddress(String host, byte[] addr)
 * static InetAddress getByName(String host)
 * static InetAddress getLocalHost()
 * static InetAddress getLoopbackAddress()
 */
public class InetAddressTest {

    public static void main(String[] args) {
        // Print www.yahoo.com address details
        printAddressDetails("www.yahoo.com");
        // Print the loopback address details
        printAddressDetails(null);
        // Print the loopback address details using IPv6
        // format
        printAddressDetails("::1");
    }

    public static void printAddressDetails(String host) {
        System.out.println("Host name: " + host);
        try {
            InetAddress addr = InetAddress.getByName(host);
            System.out.println("Host IP Address: " + addr.getHostAddress());
            System.out.println("Canonical Host Name: " + addr.getCanonicalHostName());
            int timeOutinMillis = 10000;
            System.out.println("isReachable(): " + addr.isReachable(timeOutinMillis));
            System.out.println("isLoopbackAddress(): " + addr.isLoopbackAddress());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("-------------------------------\n");
        }
    }
}
