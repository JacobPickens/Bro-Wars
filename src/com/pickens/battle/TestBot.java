package com.pickens.battle;

public class TestBot extends Bot {

	public TestBot(int index, Bot[] bots) {
		super(index, bots);
	}

	@Override
	public void update(int delta) {
		Battle.attack(index);
	}

}
