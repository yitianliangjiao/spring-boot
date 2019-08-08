package com.wrh.springboot.redis;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisUtil {
	@Resource
	private RedisTemplate<String, Object> redisTemplate;
	
	 public RedisUtil() {
		System.out.println("redis启动");
	}
	
	 public boolean set(String key, Object value) {
		 try {
			redisTemplate.opsForValue().set(key, value);
			 return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	 }
	 
	 public Object get(String key) {
		 try {
			 return redisTemplate.opsForValue().get(key);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	 }
}
