package com.llz.houtai.controller;

import com.llz.houtai.pojo.Customer;
import com.llz.houtai.pojo.Server;
import com.llz.houtai.pojo.Vo.CustomerVO;
import com.llz.houtai.service.CustomerService;
import com.llz.houtai.service.ServerService;
import com.llz.houtai.utils.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/server")
public class ServerController {

    @Autowired
    ServerService serverService;

    @RequestMapping("/serverLogin")
    @ResponseBody
    public JSONResult serverLogin(@RequestBody Server server, HttpServletRequest request) {
        List<Server> list =serverService.serverLogin(server.getPassword(),server.getName());
        if (list.size()==0){
            return JSONResult.errorMsg("登录失败");
        }else{
            request.getSession().setAttribute("serverId",list.get(0).getId());
            return JSONResult.ok("登录成功");
        }
    }

    @RequestMapping("/serverMsg")
    @ResponseBody
    public JSONResult serverGetMsg(HttpServletRequest request){
        String serverId = request.getSession().getAttribute("serverId").toString();
        if(serverId==null){
            return  JSONResult.errorMsg("请先登录");
        }
        //int id = (int)(request.getSession().getAttribute("customerId"));
        // int id = Integer.getInteger(request.getSession().getAttribute("customerId").toString());
        Server server = serverService.serverMsg(Integer.parseInt(serverId));
        if(server==null){
            return JSONResult.errorMsg("查询信息失败");
        } else {
            return JSONResult.ok(server);
        }
    }

    @RequestMapping("/serverUpdate")
    @ResponseBody
    public  JSONResult serverUpdate(@RequestBody Server server,HttpServletRequest request){
        String serverId = request.getSession().getAttribute("serverId").toString();
        if(serverId==null){
            return  JSONResult.errorMsg("请先登录");
        }
        if(server.getId()==null){
            return JSONResult.errorMsg("id不可以为空");
        }
        if (server.getPassword()==null){
            return JSONResult.errorMsg("密码不可以为空");
        }
        if (server.getName()==null){
            return JSONResult.errorMsg("名字不可以为空");
        }
        if (server.getPhone()==null){
            return JSONResult.errorMsg("电话不可以为空");
        }
        if (server.getWechat()==null){
            return JSONResult.errorMsg("微信不可以为空");
        }

        String msg = serverService.serverUpdatePwd(server);
        if(msg.contains("成功")){
            JSONResult.ok(msg);
        }
        return JSONResult.errorMsg(msg);
    }

    @RequestMapping("/serverAdd")
    @ResponseBody
    public  JSONResult serverAdd(@RequestBody Server server){
        if(server.getId()==null){
            return JSONResult.errorMsg("id不可以为空");
        }
        if (server.getPassword()==null){
            return JSONResult.errorMsg("密码不可以为空");
        }
        if (server.getName()==null){
            return JSONResult.errorMsg("名字不可以为空");
        }
        if (server.getPhone()==null){
            return JSONResult.errorMsg("电话不可以为空");
        }
        if (server.getWechat()==null){
            return JSONResult.errorMsg("微信不可以为空");
        }

        String msg = serverService.serverAdd(server);
        if(msg.contains("成功")){
            JSONResult.ok(msg);
        }
        return JSONResult.errorMsg(msg);
    }
}
