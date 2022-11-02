package com.fibanez.features.network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/**
 * Java supports UDP multicast sockets that can receive datagram packets sent to a multicast IP address. An object of
 * the MulticastSocket class represents a multicast socket. Working with a MulticastSocket socket is similar to working
 * with a DatagramSocket with one difference—a multicast socket is based on a group membership. After you have created
 * and bound a multicast socket, you need to call its joinGroup(InetAddress multiCastIPAddress) method to make this socket
 * a member of the multicast group defined by the specified multicast IP address, multiCastIpAddress. Once it becomes a
 * member of a multicast group, any datagram packet sent to that group will be delivered to this socket. There can be
 * multiple members in a multicast group. A multicast socket can be a member of multiple multicast groups. If a member
 * decides not to receive a multicast packet from a group, it can leave the group by calling the leaveGroup(InetAddress
 * multiCastIPAddress) method.
 */
public class UDPMultiCastReceiver {

    public static void main(String[] args) {
        int mcPort = 18777;
        String mcIPStr = "230.1.1.1";
        MulticastSocket mcSocket = null;
        InetAddress mcIPAddress = null;

        try {
            mcIPAddress = InetAddress.getByName(mcIPStr);
            mcSocket = new MulticastSocket(mcPort);
            System.out.println("Multicast Receiver running at:" + mcSocket.getLocalSocketAddress());

            // Join the group
            mcSocket.joinGroup(mcIPAddress);
            DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);

            while (true) {
                System.out.println("Waiting for a multicast message...");
                mcSocket.receive(packet);

                String msg = new String(
                        packet.getData(),
                        packet.getOffset(),
                        packet.getLength());
                System.out.println("[Multicast Receiver] Received:" + msg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (mcSocket != null) {
                try {
                    mcSocket.leaveGroup(mcIPAddress);
                    mcSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
