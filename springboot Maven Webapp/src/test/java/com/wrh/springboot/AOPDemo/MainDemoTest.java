package com.wrh.springboot.AOPDemo;

import com.wrh.springboot.model.UserEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.ModelMap;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MainDemoTest {

    @Autowired
    MainDemo mainDemo;
    @Test
    public void sayhello() {
        System.out.println("111"+mainDemo.sayhello("wh",new UserEntity(),new ModelMap()));
    }
}