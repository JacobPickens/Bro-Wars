package com.pickens.battle;

import org.newdawn.slick.Graphics;

public class Battle {

	// Test
	
	private static Bot[] bots = new Bot[2];
	private int step;
	private static int index = 0;
	private int check = 30;
	
	public static final int HEALTH = 0;
	private static int[][] stats = {
			{100},
			{100}
	};
	
	public static final int COOLDOWNS = 2;
	public static final int ROUND_COOLDOWN = 0;
	public static final int HEAL_COOLDOWN = 1;
	private static int[][] cooldowns = {
			{0, 0},
			{0, 0}
	};
	
	public Battle() {
		bots[0] = new TestBot(0, bots.clone());
		bots[1] = new TestBot2(1, bots.clone());
	}
	
	public void render(Graphics g) {
		
	}
	
	public void update(int delta) {
		if(checkDeath() == -1) {
			step++;
			if(step == check) {
				step = 0;
				bots[index].update(delta);
				index++;
				if(index == bots.length) {
					index = 0;
					
					cooldown();
				}
			}
		} else {
			System.out.println(checkDeath() + " died");
		}
	}
	
	/** Attacks the opponent, subtracting your DAMAGE from their health.
	 */
	public static void attack() {
		if(cooldowns[index][ROUND_COOLDOWN] == 0) {
			int other = getOther();
			
			stats[other][HEALTH]--;
			System.out.println(index + " attacked");
			cooldowns[index][ROUND_COOLDOWN]++;
		}
	}
	
	/** Heals your AI with the your HEAL amount.
	 */
	public static void heal() {
		if(cooldowns[index][ROUND_COOLDOWN] == 0) {
			if(cooldowns[index][HEAL_COOLDOWN] == 0) {				
				stats[index][HEALTH]++;
				System.out.println(index + " healed");
				cooldowns[index][ROUND_COOLDOWN]++;
				cooldowns[index][HEAL_COOLDOWN] += 2;
			}
		}
	}	
	
	private int checkDeath() {
		if(stats[0][HEALTH] <= 0) {
			return 0;
		}
		if(stats[1][HEALTH] <= 0) {
			return 1;
		}
		return -1;
	}
	
	private void cooldown() {
		for(int y = 0; y < 2; y++) {
			for(int x = 0; x < COOLDOWNS; x++) {
				if(cooldowns[y][x] > 0) {
					cooldowns[y][x]--;
				}
			}
		}
	}
	
	private static int getOther() {
		if(index == 0) {
			return 1;
		} else {
			return 0;
		}
	}
	
	/** Gets a stat from the enemy: example
	 * 		Battle.getEnemyStat(Battle.HEALTH);
	 *  This gets the health of the enemy. This method is extremely useful for AI to be able to gauge decisions off your opponents situation.
	 * 
	 * @param stat This is the stat you'd like to get. EX: Battle.HEALTH or Battle.HEAL
	 * @return Returns the requested stat or -1 if you tried to get a non-existent stat (Just use the constants in the Battle class to avoid this.)
	 */
	public static int getEnemyStat(int stat) {
		try {
			return stats[getOther()][stat];
		} catch(Exception e) {
			System.out.println("error");
			return -1;
		}
	}
	
	/** Gets a stat from your AI: example
	 * 		Battle.getStat(Battle.HEALTH);
	 *  This gets your health. This method is extremely useful for AI to be able to gauge decisions off your situation.
	 * 
	 * @param stat This is the stat you'd like to get. EX: Battle.HEALTH or Battle.HEAL
	 * @return Returns the requested stat or -1 if you tried to get a non-existent stat (Just use the constants in the Battle class to avoid this.)
	 */
	public static int getStat(int stat) {
		try {
			return stats[index][stat];
		} catch(Exception e) {
			System.out.println("error");
			return -1;
		}
	}
	
	/** Gets the current cooldown of an enemy's move. EX:
	 *  Battle.getEnemyCooldown(Battle.HEAL_COOLDOWN);
	 *  This gets the cooldown for the enemy's heal skill.
	 * 
	 * @param stat This is the cooldown you'd like to get. EX: Battle.HEAL_COOLDOWN
	 * @return Returns the requested cooldown or -1 if you tried to get a non-existent cooldown (Just use the constants in the Battle class to avoid this.)
	 */
	public static int getEnemyCooldown(int stat) {
		try {
			return cooldowns[getOther()][stat];
		} catch(Exception e) {
			System.out.println("error");
			return -1;
		}
	}
	
	/** Gets your current cooldown for a move. EX:
	 *  Battle.getCooldown(Battle.HEAL_COOLDOWN);
	 *  This gets the cooldown for your heal skill.
	 * 
	 * @param stat This is the cooldown you'd like to get. EX: Battle.HEAL_COOLDOWN
	 * @return Returns the requested cooldown or -1 if you tried to get a non-existent cooldown (Just use the constants in the Battle class to avoid this.)
	 */
	public static int getCooldown(int stat) {
		try {
			return cooldowns[index][stat];
		} catch(Exception e) {
			System.out.println("error");
			return -1;
		}
	}
	
}
