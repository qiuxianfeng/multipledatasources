package com.mzd.multipledatasources.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.mzd.multipledatasources.entity.User;

/**
 * dao层
 * Created by pure on 2018-05-06.
 */
@Mapper
public interface MoredataDao {
    //使用xml配置形式查询
    public List<Map> getAllUser();
    public Long addUserGetID(User user);
    public void addUser(@Param("name") String name);
}
