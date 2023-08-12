package com.skilldistillery.cardgame.entities;

public enum Suit {
	HEART("♥"), SPADE("♠"), CLUBS("♣"), DIAMONDS("♦");
	
	private String name;
	
	Suit(String n) { 
		name = n; 
	}
	
	@Override
	public String toString() { 
		return name; 
	}
}