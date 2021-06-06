package com.llz.houtai.service.impl;

import com.llz.houtai.mapper.CustomerMapper;
import com.llz.houtai.pojo.Customer;
import com.llz.houtai.pojo.CustomerExample;
import com.llz.houtai.pojo.Vo.CustomerVO;
import com.llz.houtai.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class CustomerImpl implements CustomerService {

    @Autowired
    CustomerMapper customerMapper;

    @Override
    public List<Customer> customerLogin(String password, String name) {
        CustomerExample customerExample = new CustomerExample();
        CustomerExample.Criteria criteria = customerExample.createCriteria();
        criteria.andNameLike(name);
        criteria.andPasswordLike(password);
        List<Customer> customers = customerMapper.selectByExample(customerExample);
        return customers;
    }

    @Override
    public Customer customerMsg(int id) {
        Customer customer = customerMapper.selectByPrimaryKey(id);
        return customer;
    }

    @Override
    public String customerUpdatePwd(Customer customer) {
        int result = customerMapper.updateByPrimaryKey(customer);
        if(result==0){
            return "更新失败";
        }else {
            return "更新成功";
        }
    }

    @Override
    public String customerAdd(Customer customer) {
        int result = customerMapper.insert(customer);
        if(result==0){
            return "注册失败";
        }else {
            return "注册成功";
        }
    }


}
