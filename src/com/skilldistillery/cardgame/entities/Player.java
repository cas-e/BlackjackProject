package com.skilldistillery.cardgame.entities;

import java.util.ArrayList;
import java.util.List;

public class Player {
	protected Hand hand;

	public Player(BlackJackHand h) {
		this.hand = h;
	}
	
	public int score() {
		return this.hand.getHandValue();
	}
	public void recieveCard(Card c) {
		this.hand.addCard(c);
	}
	
	public List<Card> returnCards() {
		List<Card> hand = new ArrayList<>(this.hand.hand);
		this.hand.hand.clear();
		return hand;
		
	}
	public String showHand() {
		return hand.toString();
	}
}
