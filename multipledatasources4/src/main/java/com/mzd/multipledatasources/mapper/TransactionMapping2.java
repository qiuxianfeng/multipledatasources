package com.mzd.multipledatasources.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.mzd.multipledatasources.bean.TeachersBean;

@Mapper
public interface TransactionMapping2 {

	void save(TeachersBean t);

	void update(TeachersBean t);
}
