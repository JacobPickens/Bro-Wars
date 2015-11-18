package com.pickens.battle;

import org.newdawn.slick.Graphics;

public class Battle {

	private static Bot[] bots = new Bot[2];
	
	private int step, index = 0, check = 30;
	
	public Battle() {
		bots[0] = new TestBot(0, bots.clone());
		bots[1] = new TestBot2(1, bots.clone());
	}
	
	public void render(Graphics g) {
		
	}
	
	public void update(int delta) {
		step++;
		if(step == check) {
			step = 0;
			bots[index].bots = bots.clone();
			bots[index].update(delta);
			index++;
			if(index == bots.length) {
				index = 0;
			}
		}
	}
	
	public static void attack(int yourIndex) {
		if(yourIndex == 0) {
			bots[1].damage(bots[0].getStrength());
		} else {
			bots[0].damage(bots[1].getStrength());
		}
	}
	
}
