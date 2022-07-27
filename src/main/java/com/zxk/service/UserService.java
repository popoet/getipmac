package com.zxk.service;


import com.zxk.entity.UserBean;
import com.zxk.mapper.UserMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

@Service
public class UserService {
    //将dao层属性注入service层
    @Resource
    private UserMapper userMapper;

    public UserBean Valid(String bi_name, String bi_department, String bi_ip, String bi_mac) {
        return userMapper.getInfo(bi_name,bi_department,bi_ip,bi_mac);
    }

    public void Insert(String bi_name, String bi_department, String bi_ip, String bi_mac){
        userMapper.saveInfo(bi_name,bi_department,bi_ip,bi_mac);
    }




    /**
     *
     * @return MAC
     */
    public String GetMac() throws SocketException {
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
        String str_mac = sb.toString();
        return str_mac;
//        System.out.println("mac地址是："+sb.toString());

//        String str = "mac地址是："+sb.toString()+"IP地址是："+ipList.toString();
//        return str;
    }

    /**
     *
     * @return 网卡IP
     */
    public String GetIp(){

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
                    //System.out.println(StringUtils.strip(list.toString(),"[]"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        String str_ip1 = StringUtils.strip(ipList.toString(),"[]");
        String str_ip = StringUtils.substringAfter(str_ip1, "127.0.0.1, ");
        return str_ip;
    }


    /**
     *
     * @return 主机名和本地ip
     * @throws UnknownHostException
     */
    public String GetName() throws UnknownHostException {
        InetAddress address = InetAddress.getLocalHost();
        String hostname=address.getHostName();
//        String hostip=address.getHostAddress();
        return hostname;
    }

}