package com.llz.houtai.service;

import com.llz.houtai.pojo.Customer;

import java.util.List;

public interface CustomerService {
    //登录
   List<Customer> customerLogin(String password,String name);
    //查看个人信息
    Customer customerMsg(int id);
    //修改个人信息
    String customerUpdatePwd(Customer customer);
    //注册
    String customerAdd(Customer customer);
}
