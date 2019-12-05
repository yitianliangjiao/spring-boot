package com.wrh.springboot;

import org.springframework.stereotype.Component;

@Component
public class GamePlayer implements Player{
	@Override
	public void play() {
		// TODO Auto-generated method stub
		ClassLoader c = this.getClass().getClassLoader();
		while(c!=null)
		{
			System.out.println(c);
			c = c.getParent();
		}
		System.out.println(" this is GamePlayer ");
	}

	public static void main(String[] args) {
		GamePlayer g = new GamePlayer();
		g.play();
	}
}
