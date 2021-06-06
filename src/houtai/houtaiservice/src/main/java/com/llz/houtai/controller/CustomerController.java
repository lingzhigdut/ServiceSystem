package com.llz.houtai.controller;

import com.llz.houtai.pojo.Customer;
import com.llz.houtai.pojo.Vo.CustomerVO;
import com.llz.houtai.service.CustomerService;
import com.llz.houtai.utils.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @RequestMapping("/customerLogin")
    @ResponseBody
    public JSONResult customerLogin(@RequestBody Customer customer,HttpServletRequest request) {
        List<Customer> list =customerService.customerLogin(customer.getPassword(),customer.getName());
        if (list.size()==0){
            return JSONResult.errorMsg("登录失败");
        }else{
            request.getSession().setAttribute("customerId",list.get(0).getId());
            return JSONResult.ok("登录成功");
        }
    }

    @RequestMapping("/customerMsg")
    @ResponseBody
    public JSONResult customerGetMsg(HttpServletRequest request){
        String customerId = request.getSession().getAttribute("customerId").toString();
        if(customerId==null){
            return  JSONResult.errorMsg("请先登录");
        }
        //int id = (int)(request.getSession().getAttribute("customerId"));
       // int id = Integer.getInteger(request.getSession().getAttribute("customerId").toString());
        Customer customer = customerService.customerMsg(Integer.parseInt(customerId));
        if(customer==null){
            return JSONResult.errorMsg("查询信息失败");
        } else {
            return JSONResult.ok(customer);
        }
    }

    @RequestMapping("/customerUpdate")
    @ResponseBody
    public  JSONResult customerUpdate(@RequestBody Customer customer,HttpServletRequest request){
        String customerId = request.getSession().getAttribute("customerId").toString();
        if(customerId==null){
            return  JSONResult.errorMsg("请先登录");
        }

        if(customer.getId()==null){
            return JSONResult.errorMsg("id不可以为空");
        }
        if (customer.getPassword()==null){
            return JSONResult.errorMsg("密码不可以为空");
        }
        if (customer.getName()==null){
            return JSONResult.errorMsg("名字不可以为空");
        }
        if (customer.getPhone()==null){
            return JSONResult.errorMsg("电话不可以为空");
        }
        if (customer.getWechat()==null){
            return JSONResult.errorMsg("微信不可以为空");
        }

        String msg = customerService.customerUpdatePwd(customer);
        if(msg.contains("成功")){
            JSONResult.ok(msg);
        }
        return JSONResult.errorMsg(msg);
    }


    @RequestMapping("/customerAdd")
    @ResponseBody
    public JSONResult customerAdd(@RequestBody Customer customer){

        if(customer.getId()==null){
            return JSONResult.errorMsg("id不可以为空");
        }
        if (customer.getPassword()==null){
            return JSONResult.errorMsg("密码不可以为空");
        }
        if (customer.getName()==null){
            return JSONResult.errorMsg("名字不可以为空");
        }
        if (customer.getPhone()==null){
            return JSONResult.errorMsg("电话不可以为空");
        }
        if (customer.getWechat()==null){
            return JSONResult.errorMsg("微信不可以为空");
        }

        String msg = customerService.customerUpdatePwd(customer);
        if(msg.contains("成功")){
            JSONResult.ok(msg);
        }
        return JSONResult.errorMsg(msg);
    }
}
