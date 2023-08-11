package com.skilldistillery.cardgame.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	List<Card> cards;
	
	public Deck() {
		cards = new ArrayList<>(52); 
		for (Suit s : Suit.values()) {
			for (Rank r : Rank.values()) {
				cards.add( new Card(s, r) );
			}
		}
		
		// start in a shuffled state:
		this.shuffle();
	}
	
	public int checkDeckSize() {
		return cards.size();
	}

	public Card dealCard() {
		return cards.remove(cards.size()-1);
	}
	
	public void shuffle() {
		Collections.shuffle(cards);
	}
}
