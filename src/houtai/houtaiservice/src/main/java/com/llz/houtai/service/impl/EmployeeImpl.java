package com.llz.houtai.service.impl;


import com.llz.houtai.mapper.EmployeeMapper;
import com.llz.houtai.pojo.Employee;
import com.llz.houtai.pojo.EmployeeExample;
import com.llz.houtai.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployeeImpl implements EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    @Override
    public List<Employee> employeeLogin(String password, String name) {
        EmployeeExample employeeExample= new EmployeeExample();
        EmployeeExample.Criteria criteria = employeeExample.createCriteria();
        criteria.andNameLike(name);
        criteria.andPasswordLike(password);
        List<Employee> employees = employeeMapper.selectByExample(employeeExample);
        return employees;
    }

    @Override
    public Employee employeeMsg(int id) {
        Employee employee= employeeMapper.selectByPrimaryKey(id);
        return employee;
    }

    @Override
    public String employeeUpdatePwd(Employee employee) {
        int result = employeeMapper.updateByPrimaryKey(employee);
        if(result==0){
            return "更新失败";
        }else {
            return "更新成功";
        }
    }

    @Override
    public String employeeAdd(Employee employee) {
        int result = employeeMapper.insert(employee);
        if(result==0){
            return "注册失败";
        }else {
            return "注册成功";
        }
    }

}
