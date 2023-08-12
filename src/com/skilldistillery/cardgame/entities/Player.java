package com.skilldistillery.cardgame.entities;

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
	
	public String showHand() {
		return hand.toString();
	}
}
