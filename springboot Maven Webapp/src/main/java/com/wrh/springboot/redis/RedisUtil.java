package com.wrh.springboot.redis;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public class RedisUtil {
	@Resource
	private RedisTemplate<String, Object> redisTemplate;
	
	 public RedisUtil() {
		System.out.println("redis启动");
	}
	
	 public void set(String key, Object value) {
		 try {
			redisTemplate.opsForValue().set(key, value);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
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

	public void addAllList(String key, List<Object> list) {
		try {
			redisTemplate.opsForList().leftPushAll(key,list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public void addList(String key, Object obj) {
		try {
			redisTemplate.opsForList().leftPush(key,obj);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public List<Object> getList(String key,int size){
		try {
			return redisTemplate.opsForList().range(key,0,size-1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public void INCR(String key) {
		try {
			redisTemplate.opsForValue().increment(key,1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public void addSet(String key, Object obj) {
		try {
			redisTemplate.opsForSet().add(key,obj);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public Set<Object> getSet(String key) {
		try {
			return redisTemplate.opsForSet().members(key);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
