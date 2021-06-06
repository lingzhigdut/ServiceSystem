package com.llz.houtai.controller;

import com.llz.houtai.pojo.Customer;
import com.llz.houtai.pojo.Employee;
import com.llz.houtai.service.CustomerService;
import com.llz.houtai.service.EmployeeService;
import com.llz.houtai.utils.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController{

    @Autowired
    EmployeeService employeeService;

    @RequestMapping("/employeeLogin")
    @ResponseBody
    public JSONResult employeeLogin(@RequestBody Employee employee, HttpServletRequest request) {
        List<Employee> list =employeeService.employeeLogin(employee.getPassword(),employee.getName());
        if (list.size()==0){
            return JSONResult.errorMsg("登录失败");
        }else{
            request.getSession().setAttribute("employeeId",list.get(0).getId());
            return JSONResult.ok("登录成功");
        }
    }

    @RequestMapping("/employeeMsg")
    @ResponseBody
    public JSONResult customerGetMsg(HttpServletRequest request){
        String employeeId = request.getSession().getAttribute("employeeId").toString();
        if(employeeId==null){
            return  JSONResult.errorMsg("请先登录");
        }
        //int id = (int)(request.getSession().getAttribute("customerId"));
        // int id = Integer.getInteger(request.getSession().getAttribute("customerId").toString());
        Employee employee = employeeService.employeeMsg(Integer.parseInt(employeeId));
        if(employee==null){
            return JSONResult.errorMsg("查询信息失败");
        } else {
            return JSONResult.ok(employee);
        }
    }

    @RequestMapping("/employeeUpdate")
    @ResponseBody
    public  JSONResult customerUpdate(@RequestBody Employee employee){
        if (employee.getId()==null){
            return JSONResult.errorMsg("id不可以为空");
        }
        if (employee.getPassword()==null){
            return JSONResult.errorMsg("密码不可以为空");
        }
        if (employee.getName()==null){
            return JSONResult.errorMsg("名字不可以为空");
        }
        if (employee.getPhone()==null){
            return JSONResult.errorMsg("电话不可以为空");
        }
        if (employee.getWechat()==null){
            return JSONResult.errorMsg("微信不可以为空");
        }

        String msg = employeeService.employeeUpdatePwd(employee);
        if(msg.contains("成功")){
            JSONResult.ok(msg);
        }
        return JSONResult.errorMsg(msg);
    }

    @RequestMapping("/employeeAdd")
    @ResponseBody
    public JSONResult customerAdd(@RequestBody Employee employee){

        if (employee.getId()==null){
            return JSONResult.errorMsg("id不可以为空");
        }
        if (employee.getPassword()==null){
            return JSONResult.errorMsg("密码不可以为空");
        }
        if (employee.getName()==null){
            return JSONResult.errorMsg("名字不可以为空");
        }
        if (employee.getPhone()==null){
            return JSONResult.errorMsg("电话不可以为空");
        }
        if (employee.getWechat()==null){
            return JSONResult.errorMsg("微信不可以为空");
        }

        String msg = employeeService.employeeAdd(employee);
        if(msg.contains("成功")){
            JSONResult.ok(msg);
        }
        return JSONResult.errorMsg(msg);
    }
}