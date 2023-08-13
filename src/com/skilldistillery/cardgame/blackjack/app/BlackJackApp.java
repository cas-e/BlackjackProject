package com.skilldistillery.cardgame.blackjack.app;

import java.util.Scanner;

public class BlackJackApp {
	
	Game game = new Game();
	
	Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) { 
		(new BlackJackApp()).run(); 
	}
	
	private void run() {
		System.out.println("~~ Welcome to the Blackjack Table ~~\n");
		
		game.dealerShuffles();
		
		boolean keepPlaying;
		do {
			keepPlaying = gameLoop();
		} while (keepPlaying);
		
		System.out.println("\n~~ Thank you for playing Blackjack. Goodbye ~~");
		scan.close();
	}
	
	private boolean gameLoop() {
		System.out.println("\n~~ The Round Begins ~~\n");
		initialDeal();
		game.displayTable();
			
		if (playerBlackjacks()) {
			endRound();
			return playerContinues();
		} 
		
		playerHitLoop();
		dealersTurn();
		results();
		endRound();
		return playerContinues();
	}
	
	
	private void initialDeal() {
		for (int i = 0; i < 2; i++) {
			game.playerDraws();
			game.dealerDraws();
		}
	}
		
	private boolean playerBlackjacks() {
		boolean player21 = game.playerScore() == 21;
		boolean dealer21 = game.dealerScore() == 21;
		
		if (player21 && dealer21) {
			System.out.println("\nPlayer gets Blackjack!\n");
			game.dealerReveals();
			game.displayTable();
			System.out.println("\nDealer also has Blackjack...\nThe game is a tie");
		}
		
		if (player21) {
			System.out.println("\nPlayer gets a Blackjack!\n");
			game.dealerReveals();
			game.displayTable();
			System.out.println("\nThe player wins!!!");
		}
		return player21;
	}

	
	private void playerHitLoop() {
		System.out.println("\n~~ Player's Turn ~~");
		boolean hits;
		boolean under21 = true;
		do {
			if (hits = playerHits()) {
				game.playerDraws();
				game.displayTable();
				under21 = game.playerScore() < 21;
			}
		} while (hits && under21);
		
		if (game.playerScore() > 21) {
			System.out.println("\nBust...");
		}
		
		if (game.playerScore() == 21) {
			System.out.println("\nThat's 21!!!");
		}
		
		System.out.println("\nIt's now the dealer's turn. Press return to continue...");
		scan.nextLine();
	}
	
	private boolean playerHits() {
		for (;;) {
			System.out.println("\nPlease enter \"hit\" to hit or \"stand\" to stand");
			String response = scan.nextLine().trim().toLowerCase();
			if (response.equals("hit") || response.equals("\"hit\"")) {
				return true;
			}
			if (response.equals("stand") || response.equals("\"stand\"")) {
				return false;
			}
			System.out.println("\nOops. Didn't quite catch that...");
		}
		
	}
	
	private void dealersTurn() {
		System.out.println("\n~~ Dealer's Turn ~~\n");
		while (game.dealerScore() < 17) {
			game.dealerDraws();
		}
		game.dealerReveals();
		game.displayTable();
	}
	
	private void results() {
		int player = game.playerScore();
		int dealer = game.dealerScore();
		
		System.out.println("\n~~ Results ~~\n");
		if (player > 21 && dealer > 21) {
			System.out.println("Push. Everybody busts.");
		} else if (dealer > 21) {
			System.out.println("Dealer busts. Player wins!!!");
		} else if (player > 21) {
			System.out.println("Player busts. Dealer wins.");
		} else if (player == dealer) {
			System.out.println("Push. It's a tie game.");
		} else {
			int better = Math.max(player, dealer);
			
			if (player == better) {
				System.out.println("Player wins!!!!");
			} else {
				System.out.println("Dealer wins.");
			}
		}
	}
	
	private boolean playerContinues() {
		System.out.println("\nWould you like to play again?");
		System.out.println("Enter [y] for yes or enter anthing else to quit");
		return scan.nextLine().trim().toLowerCase().equals("y");
	}
	
	private void endRound() {
		game.discardCurrentCards();
		game.reset();
		game.shuffleIfNeeded();
	}
	
}
