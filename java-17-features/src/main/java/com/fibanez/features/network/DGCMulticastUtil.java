package com.fibanez.features.network;

public class DGCMulticastUtil {

    public static final String MULTICAST_IP = "239.1.1.1";
    public static final int MULTICAST_PORT = 8989;

    /* You need to change the following network interface
       name "eth2" to the network interface name that
       supports multicast and is up on your machine.
       Please run the ListNetworkInterfaces class to
       get the list of all available network interface on
       your machine.
     */
    public static final String MULTICAST_INTERFACE_NAME = "eth2";
}
