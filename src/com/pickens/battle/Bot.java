package com.pickens.battle;

import org.newdawn.slick.Graphics;

public abstract class Bot {

	protected String name;
	private int health = 10;
	private int strength = 1;
	
	public int index = 0;
	
	public Bot[] bots;
	
	public Bot(int index, Bot[] bots) {
		this.index = index;
		this.bots = bots;
	}
	
	public abstract void update(int delta);
	
	public void damage(int i) {
		this.health -= i;
		System.out.println("ouch from " + index);
	}
	
	public int getStrength() {
		return strength;
	}
	
}
