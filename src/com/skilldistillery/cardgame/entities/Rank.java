package com.skilldistillery.cardgame.entities;

public enum Rank {
	A, R2, R3, R4, R5, R6, R7, R8, R9, R10, J, Q, K;
		
	public int getValue() {
		boolean isFace = this.compareTo(J) >= 0;
		return isFace ? 10 : this.ordinal() + 1;
	}
	
	@Override
	public String toString() {
		boolean isNum = this.compareTo(J) < 0 && this != A;
		return isNum ? Integer.toString(this.getValue()) : this.name();
	}
}
