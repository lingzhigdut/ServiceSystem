package com.llz.houtai.service;

import com.llz.houtai.pojo.Project;
import com.llz.houtai.pojo.ProjectInfo;
import com.llz.houtai.pojo.Schedule;
import com.llz.houtai.pojo.Server;

import java.util.List;

public interface ProjectService {


    //客户
    //创建新任务
    String projectAdd(Project project);
    //客户查看已发布任务
    List<Project> projectMsg(int customerId);
    //客户查看未承接任务


    //自由职业者
    //自由职业者查看已接受的任务
    List<Project> projectAccepted(int serverId);
    //查询所有未承接的任务
    List<Project> projectAllNotAccepted();
    //查询所有未承接的任务
    List<Project> projectAllNotAcceptedByTy(int type);
    //查看所有完成任务
    List<Project> projectFinished(int serverId);
    //查看所有未完成任务
    List<Project> projectNotFinished(int serverId);
    //接受新任务
    ProjectInfo projectAccept(ProjectInfo projectInfo);
}
