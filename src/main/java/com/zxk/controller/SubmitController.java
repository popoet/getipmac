package com.zxk.controller;

import com.zxk.entity.UserBean;
import com.zxk.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.net.SocketException;
import java.net.UnknownHostException;

@Slf4j
@Controller
public class SubmitController {

    //将Service注入Web层
    @Resource
    UserService userService;

    //实现验证
    @RequestMapping("/valid")
    public String show(){
        return "valid";
    }

    @RequestMapping(value = "/Valid",method = RequestMethod.POST)
    public String valid(String bi_name,String bi_department,String bi_ip,String bi_mac){
        UserBean userBean = userService.Valid(bi_name,bi_department,bi_ip,bi_mac);
        log.info("bi_name:{}",bi_name);
        log.info("bi_department:{}",bi_department);
        log.info("bi_ip:{}",bi_ip);
        log.info("bi_mac:{}",bi_mac);
        if(userBean!=null){
            return "success";
        }else {
            return "error";
        }
    }
    @RequestMapping("/submit")
    public String disp(Model model) throws SocketException, UnknownHostException {
        UserService userService=new UserService();
        model.addAttribute("macmsg",userService.GetMac());
        model.addAttribute("ipmsg",userService.GetIp());
        model.addAttribute("namemsg",userService.GetName());
        return "submit";
    }

    //实现提交信息到数据库功能
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String signUp(String bi_name,String bi_department,String bi_ip,String bi_mac){
        userService.Insert(bi_name,bi_department,bi_ip,bi_mac);
        return "success";
    }




}