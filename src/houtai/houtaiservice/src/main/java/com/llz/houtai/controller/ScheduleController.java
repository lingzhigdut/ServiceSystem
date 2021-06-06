package com.llz.houtai.controller;


import com.llz.houtai.mapper.ScheduleMapper;
import com.llz.houtai.pojo.Customer;
import com.llz.houtai.pojo.Schedule;
import com.llz.houtai.service.ScheduleService;
import com.llz.houtai.utils.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/server/schedule")
public class ScheduleController {

    @Autowired
    ScheduleService scheduleService;

    @RequestMapping("/scheduleMsg")
    @ResponseBody
    public JSONResult scheduleGetMsg(HttpServletRequest request){
        String serverId = request.getSession().getAttribute("serverId").toString();
        if(serverId==null){
            return  JSONResult.errorMsg("请先登录");
        }
        List<Schedule> schedules = scheduleService.scheduleMsg(Integer.parseInt(serverId));
        if(schedules.size()==0){
            return JSONResult.errorMsg("查询信息失败");
        } else {
            return JSONResult.ok(schedules);
        }
    }
}
