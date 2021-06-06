package com.llz.houtai.service.impl;

import com.llz.houtai.mapper.ProjectMapper;
import com.llz.houtai.mapper.ScheduleMapper;
import com.llz.houtai.pojo.*;
import com.llz.houtai.service.ProjectService;
import com.llz.houtai.utils.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectImpl implements ProjectService {

    @Autowired
    ProjectMapper  projectMapper;
    @Autowired
    ScheduleMapper scheduleMapper;

    @Override
    public String projectAdd(Project project) {
        int result = projectMapper.insert(project);
        if(result==0){
            return "任务发布失败";
        }else {
            return  "任务发布成功";
        }
    }

    @Override
    public ProjectInfo projectAccept(ProjectInfo projectInfo) {
        //应该先查询，修改会要匹配
        //往时间表添加任务ID


        //Schedule schedule = scheduleMapper.selectByPrimaryKey(projectInfo.getScheduleId());
        projectInfo. getSchedule().setProjectId(projectInfo.getProject().getId());
        Project project = projectInfo.getProject();
        project.setTaskcondition(1);
        projectMapper.updateByPrimaryKey(project);
        if(scheduleMapper.updateByPrimaryKeySelective(projectInfo.getSchedule())==0){
            return null;
        }
        return projectInfo;

    }

    @Override
    public List<Project> projectMsg(int customerId) {
        //客户查看发布的任务
        ProjectExample projectExample = new ProjectExample();
        ProjectExample.Criteria criteria = projectExample.createCriteria();
        criteria.andIdcustomerEqualTo(customerId);
        List<Project> projects = projectMapper.selectByExample(projectExample);
        return projects;
    }




    //自由职业者
    @Override
    //查看所有承接项目
    public List<Project> projectAccepted(int serverId) {
        ProjectExample projectExample = new ProjectExample();
        ProjectExample.Criteria criteria = projectExample.createCriteria();
        criteria.andIdcustomerEqualTo(serverId);
        List<Project> projects = projectMapper.selectByExample(projectExample);
        return projects;
    }

    @Override
    //查所有未承接项目
    public List<Project> projectAllNotAccepted() {
        ProjectExample projectExample = new ProjectExample();
        ProjectExample.Criteria criteria = projectExample.createCriteria();
        //criteria.andTaskconditionEqualTo(0);
        List<Project> projects = projectMapper.selectByExample(projectExample);
        return projects;
    }

    @Override
    public List<Project> projectAllNotAcceptedByTy(int type) {
        ProjectExample projectExample = new ProjectExample();
        ProjectExample.Criteria criteria = projectExample.createCriteria();
        criteria.andTaskconditionEqualTo(0);
        criteria.andTypeEqualTo(type);
        List<Project> projects = projectMapper.selectByExample(projectExample);
        return projects;
    }

    @Override
    public List<Project> projectFinished(int serverId) {
        ProjectExample projectExample = new ProjectExample();
        ProjectExample.Criteria criteria = projectExample.createCriteria();
        criteria.andIdcustomerEqualTo(serverId);
        criteria.andTaskconditionEqualTo(2);
        List<Project> projects = projectMapper.selectByExample(projectExample);
        return projects;
    }

    @Override
    public List<Project> projectNotFinished(int serverId) {
        ProjectExample projectExample = new ProjectExample();
        ProjectExample.Criteria criteria = projectExample.createCriteria();
        criteria.andIdcustomerEqualTo(serverId);
        criteria.andTaskconditionEqualTo(1);
        List<Project> projects = projectMapper.selectByExample(projectExample);
        return projects;
    }
}
