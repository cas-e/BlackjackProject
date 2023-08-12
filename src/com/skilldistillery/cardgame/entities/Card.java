package com.skilldistillery.cardgame.entities;

public class Card {

	private Suit suit;
	private Rank rank;
	
	public Card(Suit s, Rank r) {
		suit = s;
		rank = r;
	}
	
	public boolean isAce() {
		return this.rank == Rank.A;
	}
	
	public int getValue() {
		return rank.getValue();
	}
	
	@Override
	public String toString() {
		
		return "[" + rank + " " + suit + "]";
	}
}
