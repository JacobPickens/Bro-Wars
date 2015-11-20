package com.pickens.battle;

public abstract class Bot {

	protected String name;
	
	public int index = 0;
	
	public Bot[] bots;
	
	public Bot(int index, Bot[] bots) {
		this.index = index;
		this.bots = bots;
	}
	
	public abstract void update(int delta);
	
}
