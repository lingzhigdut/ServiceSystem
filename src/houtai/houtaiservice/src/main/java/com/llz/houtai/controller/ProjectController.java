package com.llz.houtai.controller;

import com.llz.houtai.pojo.Project;
import com.llz.houtai.pojo.ProjectInfo;
import com.llz.houtai.pojo.Schedule;
import com.llz.houtai.service.ProjectService;
import com.llz.houtai.service.ScheduleService;
import com.llz.houtai.utils.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequestMapping("/project")
@Controller
public class ProjectController {

    @Autowired
    ProjectService projectService;
    @Autowired
    ScheduleService scheduleService;

    //客户模块
    //任务发布
    @RequestMapping("/customer/projectAdd")
    @ResponseBody
    public JSONResult projectAdd(@RequestBody Project project, HttpServletRequest request){
        if(request.getSession().getAttribute("customerId")==null){
            return  JSONResult.errorMsg("请先登录");
        }
        String msg = projectService.projectAdd(project);
        if(msg.contains("成功")){
            return JSONResult.ok(msg);
        } else {
            return JSONResult.errorMsg(msg);
        }
    }

    //任务查看
    @RequestMapping("/customer/projectMsg")
    @ResponseBody
    public JSONResult projectMsg(HttpServletRequest request){
        if(request.getSession().getAttribute("customerId")==null){
            return  JSONResult.errorMsg("请先登录");
        }
        int customerId = Integer.parseInt(request.getSession().getAttribute("customerId").toString());
        List<Project> projects = projectService.projectMsg(customerId);
        return JSONResult.ok(projects);
    }


    //自由职业者模块
    @RequestMapping("/server/projectAccept")
    @ResponseBody
    public JSONResult projectAccept(@RequestBody ProjectInfo projectInfo,HttpServletRequest request){
        if(request.getSession().getAttribute("serverId")==null){
            return  JSONResult.errorMsg("请先登录");
        }
        ProjectInfo result = projectService.projectAccept(projectInfo);
        if(result==null){
           return   JSONResult.errorMsg("接受任务失败");
        }
        return JSONResult.ok(result);
    }

    //查看未被承接的任务
    @RequestMapping("/server/projectAllNotAccepted")
    @ResponseBody
    public JSONResult projectAllNotAccepted(HttpServletRequest request){
        if(request.getSession().getAttribute("serverId")==null){
            return  JSONResult.errorMsg("请先登录");
        }
        int serverId = Integer.parseInt(request.getSession().getAttribute("serverId").toString());
        List<Project> projects = projectService.projectAllNotAccepted();
        return JSONResult.ok(projects);
    }

    //根据分类查看未被承接任务模块
    @RequestMapping("/server/projectAllNotAcceptedByType")
    @ResponseBody
    public JSONResult projectAllNotAcceptedByType(@RequestParam(value = "type", required = true, defaultValue = "-1") int type,HttpServletRequest request){
        if(request.getSession().getAttribute("serverId")==null){
            return  JSONResult.errorMsg("请先登录");
        }
        List<Project> projects = projectService.projectAllNotAcceptedByTy(type);
        return JSONResult.ok(projects);
    }

    //查看所有已完成的任务
    @RequestMapping("/server/projectFinished")
    @ResponseBody
    public JSONResult projectFinished(HttpServletRequest request){
        if(request.getSession().getAttribute("serverId")==null){
            return  JSONResult.errorMsg("请先登录");
        }
        int serverId = Integer.parseInt(request.getSession().getAttribute("serverId").toString());
        List<Project> projects = projectService.projectFinished(serverId);
        return JSONResult.ok(projects);
    }

    //查看所有未完成的任务
    @RequestMapping("/server/projectNotFinished")
    @ResponseBody
    public JSONResult projectNotFinished(HttpServletRequest request){
        if(request.getSession().getAttribute("serverId")==null){
            return  JSONResult.errorMsg("请先登录");
        }
        int serverId = Integer.parseInt(request.getSession().getAttribute("serverId").toString());
        List<Project> projects = projectService.projectNotFinished(serverId);
        return JSONResult.ok(projects);
    }

    //查看所有已接受的任务
    @RequestMapping("/server/projectAccepted")
    @ResponseBody
    public JSONResult projectAccepted(HttpServletRequest request){
        if(request.getSession().getAttribute("serverId")==null){
            return  JSONResult.errorMsg("请先登录");
        }
        int serverId = Integer.parseInt(request.getSession().getAttribute("serverId").toString());
        List<Project> projects = projectService.projectAccepted(serverId);
        return JSONResult.ok(projects);
    }
}
