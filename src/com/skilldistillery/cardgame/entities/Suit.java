package com.skilldistillery.cardgame.entities;

public enum Suit {
	HEARTS("Hearts"),
	SPADES("Spades"),
	CLUBS("Clubs"),
	DIAMONDS("Diamonds");
	
	private String name;
	
	Suit(String s) {
		name = s;
	}
	
	@Override
	public String toString() {
		return name;
	}
}
