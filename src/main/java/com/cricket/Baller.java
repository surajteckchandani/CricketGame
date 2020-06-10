package com.cricket;

/**
 * 
 * @author suraj
 *
 */
public class Baller {

	private String name;
	private int run = 0;
	private int wicket = 0;
	private int balls = 0;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRun() {
		return run;
	}
	public void setRun(int run) {
		this.run = run;
	}
	public int getWicket() {
		return wicket;
	}
	public void setWicket(int wicket) {
		this.wicket = wicket;
	}
	public int getBalls() {
		return balls;
	}
	public void setBalls(int balls) {
		this.balls = balls;
	}
	
	
	public Baller(String name) {
		super();
		this.name = name;
	}
	@Override
	public String toString() {
		return "Baller [name=" + name + ", run=" + run + ", wicket=" + wicket + ", balls=" + balls + "]";
	}
	
	
}
