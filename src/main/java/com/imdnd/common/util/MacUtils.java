package com.imdnd.common.util;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * Get the client mac address and local ip
 * <p>
 * Created by adam on 2017/7/4.
 */
public class MacUtils {

    public static String getMacAddress() {

        try {
            InetAddress ip = InetAddress.getLocalHost();

            NetworkInterface network = NetworkInterface.getByInetAddress(ip);
            byte[] mac = network.getHardwareAddress();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < mac.length; i++) {
                sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
            }
            return sb.toString();
        } catch (UnknownHostException | SocketException e) {
            e.printStackTrace();
        }

        return "00-00-00-00-00-00";
    }

    // 这个只能获得内网ip 外网使用时 IpUtils.getIpAddr
    public static String getIpAddress() {

        try {
            InetAddress ip = InetAddress.getLocalHost();
            return ip.getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        return "127.0.0.1";
    }
}
