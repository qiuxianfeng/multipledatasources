package com.mzd.multipledatasources.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.mzd.multipledatasources.bean.TestBean;

@Mapper
public interface TransactionMapping1 {

	void save(TestBean t);
	
	void update(TestBean t);

}
