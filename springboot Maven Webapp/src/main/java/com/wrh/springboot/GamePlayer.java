package com.wrh.springboot;

import org.springframework.stereotype.Component;

@Component
public class GamePlayer implements Player{
	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println(" this is GamePlayer ");
	}
}
