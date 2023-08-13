# BlackjackProject

## Description

Blackjack! According to [Wikipedia](https://en.wikipedia.org/wiki/Blackjack), "It is the most widely played casino banking game in the world." And seeing as a search on Github for "blackjack" returns 53.5k results, I would guess its the most widely implemented casino game as well. (The second most popular I could find, Poker, clocks in at a mere 36.3k results.)

This is a simple terminal based implementation, focusing on getting the core logic of the game right rather than making the representation pretty. A user interaction looks like this:

~~~
~~ Welcome to the Blackjack Table ~~

The dealer shuffles the deck.

~~ The Round Begins ~~

Player draws [8 ♣]
Dealer draws [? ?]
Player draws [A ♠]
Dealer draws [7 ♠]

-- Dealer at ? --
[? ?] [7 ♠] 

-- Player at 19 --
[8 ♣] [A ♠] 

~~ Player's Turn ~~

Please enter "hit" to hit or "stand" to stand
~~~

This implementation finds the best value for a hand, given Aces can be valued 1 or 11, whichever is best. The game also plays rounds in a loop, and special care was taken to announce when the dealer rejoins the discard pile and reshuffles the deck, so that any card-counting player knows the correct probabilities at any point in the game. 

## Technologies Used

- Java
- Eclipse
- Git

## Lessons Learned

This lesson was my first time using Java enums. Enums were introduced to Java in version five, and before that time, it seems it was typical to declare groups of constants as integers to and "enumerate by hand". For example something like,

~~~
public static final int foo = 1;
public static final int bar = 2;
public static final int baz = 3;
// ...
~~~

Enums have a pre-defined natural order associated with their elements, based on the order they are declared. Even beyond that, enums are also classes in their own right, so it's easy to define methods that extend their properties. For example, here is a definition for Rank to get card rankings:

~~~
// Rank.java
public enum Rank {
	A, R2, R3, R4, R5, R6, R7, R8, R9, R10, J, Q, K;
		
	public int getValue() {
		boolean isFace = this.compareTo(J) >= 0;
		return isFace ? 10 : this.ordinal() + 1;  // (1)
	}
	
	@Override
	public String toString() {
		boolean isNum = this.compareTo(J) < 0 && this != A;
		return isNum ? Integer.toString(this.getValue()) : this.name();
	}
}
~~~

Blackjack cards have the irregular property that the number cards have distinct values, while all face cards have the same value of ten. The logic at (1) cleanly expresses this fact. Of course, if we ever expected our playing card orderings to change, or for new cards to be added, it would be a bad idea to derive these values from their ordinal property. Or as Bloch puts it, it would be "a maintenance nightmare" [1]. But playing cards haven't changed in hundreds of years, and this is more illustrative of the properties of enums. 

An alternative would be to use constructors for values, or for any other pertinent properties, as in this definition for Suit:

~~~
// Suit.java
public enum Suit {
	HEARTS("♥"), SPADES("♠"), CLUBS("♣"), DIAMONDS("♦");
	
	private String name;
	
	Suit(String n) { 
		name = n; 
	}
	
	@Override
	public String toString() { 
		return name; 
	}
}
~~~

Which easily allows us to declare a representation for each enumerated value that differs from its defined name. 

Finally enums also have proper types, so when we combine these into Card objects, we have some safety guarantees that when we call the Card constructor on (Suit, Rank), we are passing values in the right order. This would not be the case if we had instead used integers or strings for both. 


## References

[1] Bloch, Joshua. Effective Java, 3rd Edition.


