package com.skilldistillery.cardgame.entities;

public enum Suit {
	HEARTS("♥"), SPADES("♠"), CLUBS("♣"), DIAMONDS("♦");
	
	private String name;
	
	Suit(String n) { 
		name = n; 
	}
	
	@Override
	public String toString() { 
		return name; 
	}
}