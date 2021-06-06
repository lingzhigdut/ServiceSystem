package com.llz.houtai.service;

import com.llz.houtai.pojo.Employee;
import com.llz.houtai.pojo.Server;

import java.util.List;

public interface  ServerService {


    //登录
    List<Server> serverLogin(String password, String name);
    //查看个人信息
     Server serverMsg(int id);
    //修改个人信息
    String serverUpdatePwd(Server server);
    //注册、
    String serverAdd(Server server);
    //查询所有用户信息
    //List<Server> serverAllMsg();
}
