package com.llz.houtai.mapper;

import com.llz.houtai.pojo.Server;
import com.llz.houtai.pojo.ServerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ServerMapper {
    long countByExample(ServerExample example);

    int deleteByExample(ServerExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Server record);

    int insertSelective(Server record);

    List<Server> selectByExample(ServerExample example);

    Server selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Server record, @Param("example") ServerExample example);

    int updateByExample(@Param("record") Server record, @Param("example") ServerExample example);

    int updateByPrimaryKeySelective(Server record);

    int updateByPrimaryKey(Server record);
}