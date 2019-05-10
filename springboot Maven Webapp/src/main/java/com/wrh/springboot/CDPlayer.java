package com.wrh.springboot;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

/**
 * @ClassName:       CDPlayer
 * @Description:    TODO
 * @author:            王荣豪
 * @date:            2018年7月6日        下午10:03:12
 */
@Component
public class CDPlayer implements Player{
public CDPlayer(Sgtpeppers sp) {
	System.out.println(sp.toString());
}
public CDPlayer(){
	System.out.println("1115555666");
	System.out.println("222");
	System.out.println("222");
	System.out.println("222");
	System.out.println("222");
}
@Override
public void play() {
	// TODO Auto-generated method stub
	System.out.println(" this is cdplayer ");
}
}
