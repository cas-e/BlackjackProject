package com.skilldistillery.enums.drills.cards;

import java.util.Scanner;

import com.skilldistillery.cardgame.entities.Deck;

public class Dealing {

	Scanner scan;
	
	public static void main(String[] args) {
		(new Dealing()).run();
	}
	
	public void run() {
		scan = new Scanner(System.in);
		
		int howMany;
		do {
			howMany = getUserNum();
		} while (howMany == -1);
		
		dealCards(howMany);
		
		System.out.println("How many was : " + howMany);
		scan.close();
	}
	
	public void dealCards(int howMany) {
		Deck deck = new Deck();
		for (int i = 0; i < howMany; i++) {
			System.out.println(deck.dealCard());
		}
	}
	public int getUserNum() {
		System.out.println("Please enter a number of cards to draw: ");
		String line = scan.nextLine().trim();
		try {
			int num = Integer.parseInt(line);
			if (num <= 52 && num >= 1) {
				return num;
			}
			throw new NumberFormatException();
		} catch (NumberFormatException e) {
			System.out.println("Oops! We need a single number, 52 or under...");
			return -1;
		}
	}
	
}
