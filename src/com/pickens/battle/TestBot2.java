package com.pickens.battle;

public class TestBot2 extends Bot {

	public TestBot2(int index, Bot[] bots) {
		super(index, bots);
	}

	@Override
	public void update(int delta) {
		Battle.attack(index);
	}

}
