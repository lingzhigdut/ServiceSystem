package com.llz.houtai.service.impl;

import com.llz.houtai.mapper.ScheduleMapper;
import com.llz.houtai.pojo.*;
import com.llz.houtai.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleImpl implements ScheduleService {


    @Autowired
    ScheduleMapper scheduleMapper;

    @Override
    public List<Schedule> scheduleMsg(int serverId) {
        ScheduleExample scheduleExample = new ScheduleExample();
        ScheduleExample.Criteria criteria = scheduleExample.createCriteria();
        criteria.andServerIdEqualTo(serverId);
        List<Schedule> schedules = scheduleMapper.selectByExample(scheduleExample);
        return schedules;
    }

    @Override
    public String insertScheduleMsg(Schedule schedule) {
        int result = scheduleMapper.insertSelective(schedule);
        if(result==0){
            return "添加失败";
        }else {
            return "添加成功";
        }
    }

    @Override
    public String scheduleUpdate(Schedule schedule) {
        int result = scheduleMapper.updateByPrimaryKey(schedule);
        if(result==0){
            return "添加失败";
        }else {
            return "添加成功";
        }
    }
}
