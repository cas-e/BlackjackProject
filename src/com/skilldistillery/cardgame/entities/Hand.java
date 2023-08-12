package com.skilldistillery.cardgame.entities;

import java.util.ArrayList;
import java.util.List;

public abstract class Hand {

	protected List<Card> hand = new ArrayList<>();
	
	public void addCard(Card c) {
		hand.add(c);
	}
	
	public void clear() {
		hand.clear();
	}
	
	
	public abstract int getHandValue();
	
	// dealer needs different representation
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Card c : this.hand) {
			sb.append(c.toString());
			sb.append(" ");
		}
		return sb.toString();
	}
}
