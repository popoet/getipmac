package com.zxk.utils;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class MACTest01 {
    public static void main(String[] args) throws SocketException {
        /**
         * mac
         */
        StringBuilder sb = new StringBuilder();
        Enumeration<NetworkInterface> allNetInterfaces = NetworkInterface.getNetworkInterfaces();
        byte[] mac = null;
        while (allNetInterfaces.hasMoreElements()) {
            NetworkInterface netInterface = allNetInterfaces.nextElement();
            if (netInterface.isLoopback() || netInterface.isVirtual() || netInterface.isPointToPoint() || !netInterface.isUp()) {
                continue;
            } else {
                mac = netInterface.getHardwareAddress();
                if (mac != null) {
                    for (int i = 0; i < mac.length; i++) {
                        sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : "\n"));
                    }
                }
            }
        }
        //System.out.println("mac地址是："+sb.toString());

        /**
         * ip
         */
        List<String> ipList = new ArrayList<String>();
        InetAddress ip = null;
        try {
            Enumeration<NetworkInterface> netInterfaces = (Enumeration<NetworkInterface>) NetworkInterface.getNetworkInterfaces();
            while (netInterfaces.hasMoreElements()) {
                NetworkInterface ni = (NetworkInterface) netInterfaces.nextElement();
                // 遍历所有ip
                Enumeration<InetAddress> ips = ni.getInetAddresses();
                while (ips.hasMoreElements()) {
                    ip = (InetAddress) ips.nextElement();
                    if (null == ip || "".equals(ip)) {
                        continue;
                    }
                    String sIP = ip.getHostAddress();
                    if (sIP == null || sIP.indexOf(":") > -1) {
                        continue;
                    }
                    ipList.add(sIP);
                    //System.out.println("IP地址是："+sIP);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        String str = "mac地址是："+sb.toString()+"IP地址是："+ipList.toString();
        System.out.println(str);
    }
}
