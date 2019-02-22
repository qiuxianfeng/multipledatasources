package com.mzd.multipledatasources.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mzd.multipledatasources.bean.TeachersBean;
import com.mzd.multipledatasources.bean.TestBean;
import com.mzd.multipledatasources.service.TransactionService1;
import com.mzd.multipledatasources.service.TransactionService2;

/**
 * 多数据源事务测试
 * 
 * @author acer
 *
 */
@RestController
public class TransactionController {
	@Autowired
	private TransactionService1 ts1;
	@Autowired
	private TransactionService2 ts2;

	@RequestMapping("/savetest.do")
	public String savetest() {
		TestBean tb = new TestBean();
		tb.setId(UUID.randomUUID().toString().replaceAll("-", ""));
		tb.setScore(70);
		tb.setClassid("1");
		tb.setUserid("a");
		ts1.test01_saveTestBean(tb);
		return "success";
	}
	
	@RequestMapping("/updatetest.do")
	public String updatetest() {
		TestBean tb = new TestBean();
		tb.setId("98ed2516b5be44e0acc8a2fb5a3aae95");
		tb.setScore(70);
		tb.setClassid("1");
		tb.setUserid("aa");
		ts1.test01_updateTestBean(tb);
		return "success";
	}
	
	@RequestMapping("/save2test.do")
	public String save2test() {
		TestBean tb = new TestBean();
		tb.setId(UUID.randomUUID().toString().replaceAll("-", ""));
		tb.setScore(80);
		tb.setClassid("1");
		tb.setUserid("b");
		ts1.test01_save2TestBean(tb);
		return "success";
	}

	@RequestMapping("/saveteacher.do")
	public String saveteacher() {
		TeachersBean tb = new TeachersBean();
		tb.setId(UUID.randomUUID().toString().replaceAll("-", ""));
		tb.setTeachername("王老师");
		tb.setClassid("1");
		ts2.test02_saveTeachersBean(tb);
		return "success";
	}

	
}
