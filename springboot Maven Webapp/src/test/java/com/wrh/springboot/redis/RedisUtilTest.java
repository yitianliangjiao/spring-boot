package com.wrh.springboot.redis; 

import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

/** 
* RedisUtil Tester. 
* 
* @author <Authors name> 
* @since <pre>8�� 9, 2019</pre> 
* @version 1.0 
*/ 
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RedisUtilTest { 

@Autowired
RedisUtil RedisUtil;
@Resource
private RedisTemplate<String, Object> redisTemplate;

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: set(String key, Object value) 
* 
*/ 
@Test
public void testSet() throws Exception { 
//TODO: Test goes here...
    RedisUtil.set("wrr","NB");
} 

/** 
* 
* Method: get(String key) 
* 
*/ 
@Test
public void testGet() throws Exception { 
//TODO: Test goes here...
    System.out.println(RedisUtil.get("wrr"));
} 

/** 
* 
* Method: setList(String key, List<Object> list) 
* 
*/ 
@Test
public void testSetList() throws Exception { 
//TODO: Test goes here...
    /*redisTemplate.opsForSet().add("王","荣昊");
    System.out.printf(redisTemplate.opsForSet().members("111").toString());*/
    RedisUtil.addSet("王","sheng");
    System.out.printf(RedisUtil.getSet("王").toString());
} 

/** 
* 
* Method: getList(String key, int size) 
* 
*/ 
@Test
public void testGetList() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: INCR(String key) 
* 
*/ 
@Test
public void testINCR() throws Exception {
//TODO: Test goes here...
    RedisUtil.INCR("sucess1");
    System.out.println(RedisUtil.get("sucess1"));
} 


} 
