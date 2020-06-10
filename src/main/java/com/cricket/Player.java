package com.cricket;

/**
 * 
 * @author suraj
 *
 */
public class Player {
	private String name;
	private int score = 0;
	private int balls = 0;
	
	private boolean out;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getBalls() {
		return balls;
	}
	public void setBalls(int balls) {
		this.balls = balls;
	}
	
	public boolean isOut() {
		return out;
	}
	public void setOut(boolean out) {
		this.out = out;
	}
	public Player(String name) {
		super();
		this.name = name;
	}
	public Player() {
		
	}
	@Override
	public String toString() {
		return "Player [name=" + name + ", score=" + score + ", balls=" + balls + ",  out=" + out + "]";
	}
	
	

}
