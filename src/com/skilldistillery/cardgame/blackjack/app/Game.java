package com.skilldistillery.cardgame.blackjack.app;

import com.skilldistillery.cardgame.entities.BlackJackHand;
import com.skilldistillery.cardgame.entities.Card;
import com.skilldistillery.cardgame.entities.Dealer;
import com.skilldistillery.cardgame.entities.Deck;
import com.skilldistillery.cardgame.entities.Player;

public class Game {
	private Dealer dealer;
	private Player player;
	
	private int dealerScore;
	private int playerScore;
	
	private boolean dealerRevealed = false;
	
	public Game() {
		Deck deck = new Deck();
		deck.shuffle();
		BlackJackHand dealerHand = new BlackJackHand();
		BlackJackHand playerHand = new BlackJackHand();
		dealer = new Dealer(deck, dealerHand);
		player = new Player(playerHand);
	}
	
	public void dealerDraws() {
		String card = dealer.dealToSelf();
		dealerScore = dealer.score();
		System.out.println("Dealer draws " + card);
	}
	
	public void playerDraws() {
		Card card = dealer.dealCard();
		player.recieveCard(card);
		playerScore = player.score();
		System.out.println("Player draws " + card.toString());
	}
	
	public int playerScore() {
		return this.playerScore;
	}
	
	public int dealerScore() {
		return this.dealerScore;
	}
	
	public void dealerReveals() {
		dealerRevealed = true;
		System.out.println("Dealer reveals the hidden card " + dealer.revealCard());
	}
	
	public void displayTable() {

		String pHand = player.showHand();
		String dHand = dealerRevealed ? dealer.showRevealedHand() : dealer.showHand();
		
		System.out.println("\n~~ Dealer ~~");
		System.out.println(dHand + "\n");
		System.out.println("~~ Player ~~");
		System.out.println(pHand);
	}
	
	

}
