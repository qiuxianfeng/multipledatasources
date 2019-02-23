package com.mzd.multipledatasources.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mzd.multipledatasources.config.DS;
import com.mzd.multipledatasources.config.DatabaseType;
import com.mzd.multipledatasources.dao.MoredataDao;
import com.mzd.multipledatasources.entity.User;

/**
 * service层
 * Created by pure on 2018-05-06.
 */
@Service
public class MoredataService {
    @Autowired
    private MoredataDao moredataDao;

    //使用数据源1查询
   @DS(DatabaseType.datasource1)
    public List<Map> getAllUser1(){
        return moredataDao.getAllUser();
    }
    //使用数据源2查询
    @DS(DatabaseType.datasource2)
    public List<Map> getAllUser2(){
        return moredataDao.getAllUser();
    }

    //使用数据源1插入数据
    @DS(DatabaseType.datasource1)
    public Long addUserGetID1(User user){
        return moredataDao.addUserGetID(user);
    }
    //使用数据源1插入数据
    @DS(DatabaseType.datasource2)
    public Long addUserGetID2(User user){
        return moredataDao.addUserGetID(user);
    }

    //使用数据源1插入数据
    @DS(DatabaseType.datasource1)
    public void addUser1(String name){
        moredataDao.addUser(name);
    }
    //使用数据源2插入数据
    @DS(DatabaseType.datasource2)
    public void addUser2(String name){
        moredataDao.addUser(name);
    }
}
