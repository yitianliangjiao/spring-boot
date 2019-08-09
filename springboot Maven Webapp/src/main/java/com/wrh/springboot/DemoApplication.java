package com.wrh.springboot;

import com.wrh.springboot.redis.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName:       DemoApplication
 * @Description:    TODO
 * @author:            王荣豪
 * @date:            2018年7月5日        下午10:34:41
 */
@Controller
@SpringBootApplication
@ComponentScan(basePackages = {"com.wrh.springboot.*"})
public class DemoApplication {


	/**
	 * @Title:             main
	 * @Description:     TODO
	 * @param:             @param args   
	 * @return:         void   
	 * @throws
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(DemoApplication.class, args);
	}
}
