package com.llz.houtai.service;

import com.llz.houtai.pojo.Schedule;

import java.util.List;

public  interface ScheduleService {

    //查看时间表
    List<Schedule> scheduleMsg(int serverId);

    //插入新空闲时间端
    String insertScheduleMsg(Schedule schedule);

    //更新时间表
    String scheduleUpdate(Schedule schedule);
}
