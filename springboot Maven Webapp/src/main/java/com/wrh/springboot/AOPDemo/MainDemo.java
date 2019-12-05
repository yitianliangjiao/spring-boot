package com.wrh.springboot.AOPDemo;

import com.wrh.springboot.model.UserEntity;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;

@Component
public class MainDemo {

    @Id
    public String sayhello(String name, UserEntity user, ModelMap modelMap){
        modelMap.addAttribute("aa","bbbb");
        user.setName("wwwww");
        System.out.println("hello fuck "+name+" fuck the "+user.getName());
        return "aa";
    }

    public void saybye(){
        System.out.println("bye fuck you");
    }
}
