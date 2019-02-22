package com.mzd.multipledatasources.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mzd.multipledatasources.bean.TestBean;
import com.mzd.multipledatasources.dao.TransactionDao1;
import com.mzd.multipledatasources.mapper.TransactionMapping1;

@Service
public class TransactionService1 {
	@Autowired
	private TransactionDao1 ts1;
	
	@Autowired
	private TransactionMapping1 tm1;

	@Transactional
	public void test01_saveTestBean(TestBean t) {
		ts1.save(t);
	}
	
	@Transactional
	public void test01_updateTestBean(TestBean t) {
		ts1.update(t);
	}
	
	@Transactional
	public void test01_save2TestBean(TestBean t) {
		tm1.save(t);
		int i=1/0;
		t.setUserid("aaaaa");
		tm1.update(t);
	}

}
