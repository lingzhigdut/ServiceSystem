package com.llz.houtai.service.impl;

import com.llz.houtai.mapper.EmployeeMapper;
import com.llz.houtai.mapper.ServerMapper;
import com.llz.houtai.pojo.Employee;
import com.llz.houtai.pojo.EmployeeExample;
import com.llz.houtai.pojo.Server;
import com.llz.houtai.pojo.ServerExample;
import com.llz.houtai.service.EmployeeService;
import com.llz.houtai.service.ServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ServerImpl implements ServerService {

    @Autowired
    ServerMapper serverMapper;

    @Override
    public List<Server> serverLogin(String password, String name) {
        ServerExample serverExample = new ServerExample();
        ServerExample.Criteria criteria = serverExample.createCriteria();
        criteria.andNameLike(name);
        criteria.andPasswordLike(password);
        List<Server> servers = serverMapper.selectByExample(serverExample);
        return servers;
    }

    @Override
    public Server serverMsg(int id) {
        Server server = serverMapper.selectByPrimaryKey(id);
        return server;
    }

    @Override
    public String serverUpdatePwd(Server server) {
        int result = serverMapper.updateByPrimaryKey(server);
        if(result==0){
            return "更新失败";
        }else {
            return "更新成功";
        }
    }

    @Override
    public String serverAdd(Server server) {
        int result = serverMapper.insert(server);
        if(result==0){
            return "更新失败";
        }else {
            return "更新成功";
        }
    }


}