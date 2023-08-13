package com.skilldistillery.cardgame.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	private int NUM_CARDS = 52;
	private List<Card> cards = new ArrayList<>(NUM_CARDS);
	
	public Deck() {
		for (Suit s : Suit.values()) {
			for (Rank r : Rank.values()) {
				cards.add( new Card(s, r) );
			}
		}
	}
	
	public int totalCardsInDeck() {
		return NUM_CARDS;
	}
	public int cardsLeftInDeck() { 
		return cards.size(); 
	}
	
	public Card dealCard()       { 
		return cards.remove(cards.size()-1);
	}
	
	public void recieveDiscarded(List<Card> cards) {
		this.cards.addAll(cards);
		if (this.cards.size() != NUM_CARDS) {
			System.out.println(this.cards.size());
			System.out.println("BIG EFFIN ERROR");
			System.out.println("BIG EFFIN ERROR");
			System.out.println("BIG EFFIN ERROR");
		}
	}
	public void shuffle() { 
		Collections.shuffle(cards); 
	}
}
