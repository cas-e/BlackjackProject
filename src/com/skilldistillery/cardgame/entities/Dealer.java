package com.skilldistillery.cardgame.entities;

public class Dealer extends Player {
	
	private Deck deck;
	private String hidden = "[? ?]";
	
	public Dealer(Deck d, BlackJackHand h) {
		super(h);
		this.deck = d;
	}
	
	public int score() {
		return this.hand.getHandValue();
	}
	public Card dealCard() {
		return this.deck.dealCard();
	}
	
	public String dealToSelf() {
		Card card = deck.dealCard();
		String side = this.hand.hand.isEmpty() ? hidden : card.toString();
		this.hand.addCard(card);
		return side;
	}
	
	
	public String showHand() {
		StringBuilder sb = new StringBuilder(hidden + " ");
		for (int i = 1; i < this.hand.hand.size(); i++) {
			sb.append(this.hand.hand.get(i));
			sb.append(" ");
		}
		return sb.toString();
	}
	
	public Card revealCard() {
		return this.hand.hand.get(0);
	}
	public String showRevealedHand() {
		return this.hand.toString();
	}
}
