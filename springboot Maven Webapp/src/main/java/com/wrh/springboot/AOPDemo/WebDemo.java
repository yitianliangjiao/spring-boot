package com.wrh.springboot.AOPDemo;

import com.wrh.springboot.model.UserEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/aop")
public class WebDemo {
    @RequestMapping("/demo")
   // @ResponseBody
    public String sayhello(String name, UserEntity user, ModelMap modelMap){
        modelMap.addAttribute("aa","bbbb");
        user.setName("wwwww");
        System.out.println("hello fuck "+name+" fuck the "+user.getName());
        return "index";
    }
}
