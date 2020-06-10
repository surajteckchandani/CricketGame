package com.cricket;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * 
 * @author suraj
 *
 */
public class CricketGame {

	
	private List<Player> batsman = new ArrayList<Player>();
	private Baller faster;
	private Baller spinner;

	public void startGame(int numberOfOver) {
		String baller;
		Integer totalScore = 0;
		Integer over = 0;
		List<Player> playing = new ArrayList<Player>();
		
		Player stricker;
		Player nonStricker;
		
		baller = "faster";
		CricketGame cricketGame = new CricketGame();
		stricker = batsman.get(0);
		nonStricker = batsman.get(1);
		int nextPlayer = 2;
		int noOfWicket = 0;
		// this for loop is used for over
		for (int i = 0; i < numberOfOver; i++) {
			over = i;
			// this for loop is used for number of balls
			for (int j = 1; j < 7; j++) {
				int second = baller.equalsIgnoreCase("faster") ? 1 : 2;
				throwBall(second);
				String run = getRun();
				System.out.println("run ==" + run);
				int ball = stricker.getBalls() + 1;
				stricker.setBalls(ball);
				int score = 0;
				switch (run) {
				case "1":
					totalScore = totalScore + 1;
					score = stricker.getScore() + 1;
					stricker.setScore(score);
					Player temp = stricker;
					stricker = nonStricker;
					nonStricker = temp;
					break;
				case "2":
					totalScore = totalScore + 2;
					score = stricker.getScore() + 2;
					stricker.setScore(score);
					break;
				case "3":
					totalScore = totalScore + 3;
					score = stricker.getScore() + 3;
					stricker.setScore(score);
					Player temp2 = stricker;
					stricker = nonStricker;
					nonStricker = temp2;
					break;
				case "4":
					totalScore = totalScore + 4;
					score = stricker.getScore() + 4;
					stricker.setScore(score);
					break;
				case "6":
					totalScore = totalScore + 6;
					score = stricker.getScore() + 6;
					stricker.setScore(score);
					break;
				case "wicket":
					stricker.setOut(true);
					playing.add(stricker);
					noOfWicket ++;
					stricker = batsman.get(nextPlayer);
					break;
				default:
					break;
				}
				
				cricketGame.updateBallerScore(baller, run, faster, spinner);
				cricketGame.printScore(stricker, nonStricker, i, j, totalScore, noOfWicket);
				
			}
			String tBaller = baller;
			baller = tBaller.equalsIgnoreCase("faster") ? "spinner" : "faster";	
		}
		playing.add(stricker);
		playing.add(nonStricker);
		System.out.println("Print Final Score");
		playing.stream().distinct().forEach(System.out::println);
		System.out.println(faster);
		System.out.println(spinner);
		over++;
		System.out.println("Total " + totalScore + " Runs / " + noOfWicket + " Wicket /" + over + " Overs");

	}

	private void updateBallerScore(String baller, String run, Baller faster, Baller spinner) {
		if (baller.equalsIgnoreCase("faster")) {
			int tball = faster.getBalls() +1;
			faster.setBalls(tball);
			int tscore = 0;
			if(!run.equalsIgnoreCase("wicket")) {
				tscore = faster.getRun() + Integer.parseInt(run);
				faster.setRun(tscore);
			} else {
				int twic = faster.getWicket() +1;
				faster.setWicket(twic);
			}
			
		} else {
			int tball = spinner.getBalls() +1;
			spinner.setBalls(tball);
			int tscore = 0;
			if(!run.equalsIgnoreCase("wicket")) {
				tscore = spinner.getRun() + Integer.parseInt(run);
				spinner.setRun(tscore);
			} else {
				int twic = spinner.getWicket() +1;
				spinner.setWicket(twic);
			}
		}
	}
	
	private String getRun() {
		String[] runs = { "1", "2", "3", "4", "6", "wicket" };
		Random r = new Random();
		return runs[r.nextInt(runs.length)];
	}

	private void throwBall(int second) {
		try {
			Thread.sleep(second * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void printScore(Player stri, Player nonStri, int over, int ball, int tScore, int wic) {
		System.out.println(stri.toString());
		System.out.println(nonStri.toString());
		System.out.println(stri.getName() + " * -" + stri.getScore() + "Runs ( " + stri.getBalls() + " ) ");
		System.out.println(nonStri.getName() + "-" + nonStri.getScore() + "Runs ( " + nonStri.getBalls() + " ) ");
		if (ball == 6) {
			++over;
			ball = 0 ;
		}
		System.out.println("Total - " + tScore + " / " + wic + " Wicket /" + over + "." + ball + "overs");
	}

	public static void main(String[] args) {
		CricketGame play = new CricketGame();
		@SuppressWarnings("resource")
		Scanner myObj = new Scanner(System.in);  // Create a Scanner object
	    System.out.println("Enter number of over:");

	    Integer numberOfOver = myObj.nextInt();
		play.addBatsman();
		play.startGame(numberOfOver);
	}

	private void addBatsman() {
		faster = new Baller("Faster");
		spinner = new Baller("Spinner");
		batsman.add(new Player("test1"));
		batsman.add(new Player("test2"));
		batsman.add(new Player("test3"));
		batsman.add(new Player("test4"));
		batsman.add(new Player("test5"));
		batsman.add(new Player("test6"));
		batsman.add(new Player("test7"));
		batsman.add(new Player("test8"));
		batsman.add(new Player("test9"));
		batsman.add(new Player("test10"));
		batsman.add(new Player("test11"));
	}

}
