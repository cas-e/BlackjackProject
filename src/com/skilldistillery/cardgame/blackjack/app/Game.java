package com.skilldistillery.cardgame.blackjack.app;

import java.util.List;

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
	
	private int cut;
	
	public Game() {
		Deck deck = new Deck();
		this.cut = deck.totalCardsInDeck() / 52;
		BlackJackHand dealerHand = new BlackJackHand();
		BlackJackHand playerHand = new BlackJackHand();
		dealer = new Dealer(deck, dealerHand);
		player = new Player(playerHand);
	}
	
	public void dealerShuffles() {
		System.out.println("The dealer shuffles the deck.");
		dealer.shuffle();
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

		String playHand = player.showHand();
		String dealHand = dealerRevealed ? dealer.showRevealedHand() : dealer.showHand();
		
		String playScore = Integer.toString(playerScore);
		String dealScore = dealerRevealed ? Integer.toString(dealerScore) : "?";
		
		System.out.println("\n-- Dealer at " + dealScore + " --");
		System.out.println(dealHand + "\n");
		System.out.println("-- Player at " + playScore + " --");
		System.out.println(playHand);
	}
	
	public void discardCurrentCards() {
		dealer.discardOwnCards();
		List<Card> cards = player.returnCards();
		dealer.discardPlayerCards(cards);
	}
	
	public void reset() {
		// return cards
		System.out.println("\nThe dealer collects the cards.");
		dealer.discardOwnCards();
		List<Card> cards = player.returnCards();
		dealer.discardPlayerCards(cards);
		// reset game state
		playerScore = 0;
		dealerScore = 0;
		dealerRevealed = false;
	}
	
	public void shuffleIfNeeded() {
		if (dealer.checkCardsRemaining() <= this.cut) {
			System.out.println("The dealer collects the discard pile back into the deck.");
			dealer.rejoinDiscardPile();
			dealerShuffles();
		}
	}
	

}
