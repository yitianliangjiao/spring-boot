package com.wrh.springboot;

import static org.junit.Assert.*;

import org.junit.runner.RunWith;
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
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=ComponentConfig.class)
public class Test {
	@Autowired
	private CDPlayer cd;
	@org.junit.Test
	public void test() {
		assertNotNull(cd);
		System.out.println("测试git-pull request");
		System.out.println("测试git-pull request");
		System.out.println("测试git-pull request");
		System.out.println("测试git-pull request");
	}
	
}
