package com.mzd.multipledatasources.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mzd.multipledatasources.entity.User;
import com.mzd.multipledatasources.service.MoredataService;

/**
 * Created by pure on 2018-05-06.
 */
//@CrossOrigin
@RestController
@RequestMapping("/moredata")
public class MoredataController {
    @Autowired
    private MoredataService moredataService;

    @RequestMapping(value = "/getDb1AllUser")
    public List<Map> getDb1AllUser() {
        List<Map> list = moredataService.getAllUser1();
        return list;
    }

    @RequestMapping(value = "/getDb2AllUser")
    public List<Map> getDb2AllUser() {
        List<Map> list = moredataService.getAllUser2();
        return list;
    }

    @RequestMapping(value = "/addDb1User")
    public String addDb1User(String name) {
        User user = new User(name,new Date());
        Long rows = moredataService.addUserGetID1(user);//返回的是结果行数
        return "{id:"+user.getId()+"}";
    }
    @RequestMapping(value = "/addDb2User")
    public String addDb2User(String name) {
        User user = new User(name,new Date());
        Long rows = moredataService.addUserGetID2(user);
        return "{id:"+user.getId()+"}";
    }
    
    @RequestMapping(value = "/addDb22User")
    public String addDb22User(String name) {
        User user = new User(name,new Date());
        Long rows = moredataService.addUserGetID2(user);
        return "{id:"+user.getId()+"}";
    }

}
