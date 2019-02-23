package com.mzd.multipledatasources.entity;

import java.util.Date;

/**
 * user实体类
 * Created by pure on 2018-05-06.
 */
public class User {
    private Long id;
    private String name;
    private Date createTime;

    public User(){}
    public User(String name,Date createTime){
        this.name=name;
        this.createTime=createTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
