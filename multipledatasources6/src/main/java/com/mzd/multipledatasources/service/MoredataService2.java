package com.mzd.multipledatasources.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mzd.multipledatasources.config.DS;
import com.mzd.multipledatasources.config.DatabaseType;
import com.mzd.multipledatasources.dao.MoredataDao;

/**
 * service层
 * Created by pure on 2018-05-06.
 */
@DS(DatabaseType.datasource2)
@Service
public class MoredataService2 {
    @Autowired
    private MoredataDao moredataDao;

    //使用数据源2插入数据
    public void addUser2(String name){
        moredataDao.addUser(name);
    }
}
