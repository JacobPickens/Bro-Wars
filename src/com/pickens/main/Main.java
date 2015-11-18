package com.pickens.main;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class Main extends BasicGame {

	public Main(String title) {
		super(title);
	}

	@Override
	public void init(GameContainer gc) throws SlickException {
		
	}
	
	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
		
	}

	@Override
	public void update(GameContainer gc, int delta) throws SlickException {
		
	}
	
	public static void main(String[] args) {
		AppGameContainer appgc;
		try {
			appgc = new AppGameContainer(new Main("Bro Wars"));
			appgc.setDisplayMode(640, 480, false);
			appgc.setVSync(true);
			appgc.setTargetFrameRate(60);
			appgc.start();
		} catch(SlickException e) {
			e.printStackTrace();
		}
	}

}
