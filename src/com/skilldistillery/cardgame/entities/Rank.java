package com.skilldistillery.cardgame.entities;

public enum Rank {
	TWO,
	THREE,
	FOUR,
	FIVE,
	SIX,
	SEVEN,
	EIGHT,
	NINE,
	TEN,
	JACK(10),
	QUEEN(10),
	KING(10),
	ACE(11);
	
	private int value;
	
	Rank() {
		value = this.ordinal() + 2;
	}
	Rank(int r) {
		value = r;
	}
	
	public int getValue() {
		return value;
	}
}
