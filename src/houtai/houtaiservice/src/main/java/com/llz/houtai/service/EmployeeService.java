package com.llz.houtai.service;

import com.llz.houtai.pojo.Customer;
import com.llz.houtai.pojo.Employee;

import java.util.List;

public interface EmployeeService {

    //登录
    List<Employee> employeeLogin(String password, String name);
    //查看个人信息
    Employee employeeMsg(int id);
    //修改个人信息
    String employeeUpdatePwd(Employee employee);
    //注册
    String employeeAdd(Employee employee);
}
