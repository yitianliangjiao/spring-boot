package com.wrh.springboot.redis; 

import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.beans.factory.annotation.Autowired;

/** 
* RedisUtil Tester. 
* 
* @author <Authors name> 
* @since <pre>8�� 8, 2019</pre> 
* @version 1.0 
*/
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class RedisUtilTest {

    @Autowired
RedisUtil RedisUtil;



@Before
public void before() throws Exception {
    RedisUtil.set("score","100");
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
    RedisUtil.set("wrh","100分");
}

/** 
* 
* Method: get(String key) 
* 
*/ 
@Test
public void testGet() throws Exception { 
//TODO: Test goes here...
    System.out.println(RedisUtil.get("wrh"));
} 


} 
