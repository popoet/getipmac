package com.zxk.service;

import com.zxk.entity.UserBean;
import com.zxk.mapper.UserMapper;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import static com.zxk.utils.GetMacAddress.getMacAddress;

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
     * @param request
     * @return Ip
     * @throws Exception
     */
    public static String GetIp(HttpServletRequest request) throws Exception {
        String Ip = request.getRemoteAddr();
        return Ip;

    }

    /**
     *
     * @param request
     * @return Mac
     * @throws Exception
     */
    public String GetMac(HttpServletRequest request) throws Exception {
        String Mac = getMacAddress(request.getRemoteAddr());
        return Mac;
    }


}