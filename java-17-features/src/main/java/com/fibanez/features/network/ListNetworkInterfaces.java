package com.fibanez.features.network;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/**
 * Java provides support for IP multicasting using a datagram channel. A datagram channel that is interested in receiving
 * multicast datagrams joins a multicast group. The datagrams that are sent to a multicast group are delivered to all its
 * members. The following sections outline the steps that are typically needed to set up a client application that is
 * interested in receiving a multicast datagram.
 */
public class ListNetworkInterfaces {

    public static void main(String[] args) {
        try {
            Enumeration<NetworkInterface> e = NetworkInterface.getNetworkInterfaces();

            while (e.hasMoreElements()) {
                NetworkInterface nif = e.nextElement();
                System.out.println("Name: " + nif.getName() + ", Supports Multicast: " + nif.supportsMulticast() + ", isUp(): " + nif.isUp());
            }
        } catch (SocketException ex) {
            ex.printStackTrace();
        }
    }

}
