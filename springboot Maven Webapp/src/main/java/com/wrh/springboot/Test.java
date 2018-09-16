package com.wrh.springboot;

import static org.junit.Assert.*;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @ClassName:       Test
 * @Description:    TODO
 * @author:            王荣豪
 * @date:            2018年7月5日        下午10:47:02
 */
public class Test {
	final Logger logger = LoggerFactory.getLogger(Test.class);
	@org.junit.Test
	public void test() {
		logger.info("111");
	}
	
}
