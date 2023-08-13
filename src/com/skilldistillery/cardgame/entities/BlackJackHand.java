package com.skilldistillery.cardgame.entities;

public class BlackJackHand extends Hand {
	
	/* getHandValue:
	 * Aces are sometimes 1, sometimes 11-- whichever is best for that hand.
	 * The key property this method relies on is:
     * ~ 2 Aces, each counted as 11, will always be greater than 21  ~
     * So we don't need to consider every combination of 1's and 11's,
     * most are ruled out as "always busts".
     * There are only two types of cases that are "sometimes not busts":
     *   case1 = 11 + 1 + 1 + ... + sumOfTheRest
     *   case2 = 1  + 1 + 1 + ... + sumOftheRest
     * Return the better of those two.
     */
	public int getHandValue() {
		int aceCount = 0;
		int sumOfTheRest = 0;
		
		for (Card c : this.hand) {
			if (c.isAce()) {
				aceCount++;
			} else {
				sumOfTheRest += c.getValue();
			}
		}
		
		if (aceCount == 0) {
			return sumOfTheRest;
		}
		
		int case1 = 11 + (aceCount-1) + sumOfTheRest;
		int case2 = aceCount + sumOfTheRest;

		return case1 > 21 ? case2 :
		       case2 > 21 ? case1 : Math.max(case1, case2);
	}
	
	
	public boolean isBlackJack() {
		return this.getHandValue() == 21;
	}
	
	public boolean isBust() {
		return this.getHandValue() > 21;
	}
}
