package Caravan;

import java.util.Random;
import java.util.Stack;

public class Deck {
//stack of randomly generated cards
	public Stack<Card> Deck = new Stack<Card>();
	private String CardColour[] = { "B", "R" };
	private String Suit[] = { "H", "D", "C", "S" };
	private String CardType[] = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A","JO" };

	/**
	 * 
	 * @param n Create random Cards and fill the deck with the number of n
	 * 
	 */
	public void FillDeck(int n) {
		for (int i = 0; i < n; i++) {
			Deck.push(CreateRandomCardProperColour()); // create a random card and add it to the stack
		
		
		}
	}

	/**
	 * generate a Card of Random Colour, suit, and Length
	 * 
	 */
	public Card CreateRandomCard() {
		Random random = new Random();
		Card NewCard = new Card(CardColour[random.nextInt(CardColour.length)], Suit[random.nextInt(Suit.length)],
				CardType[random.nextInt(CardType.length)]);
		return NewCard;
	}
	
	public Card CreateRandomCardProperColour() {
		Random random = new Random();
		Card NewCard = new Card(CardColour[1], Suit[random.nextInt(Suit.length)],
				CardType[random.nextInt(CardType.length)]);
		
		if(NewCard.getSuit() == "C" || NewCard.getSuit() == "S" ) {
			NewCard.setColour("B");
		}
		
		return NewCard;
	}
	
}
