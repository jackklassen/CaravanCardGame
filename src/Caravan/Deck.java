package Caravan;

import java.util.Collections;
import java.util.Stack;

public class Deck {
//stack of randomly generated cards
	public Stack<Card> Deck = new Stack<>();
	private final String Suit[] = { "hearts", "diamonds", "clubs", "spades" };


	/**
	 * 
	 * @param n Create random Cards and fill the deck with the number of n
	 * 
	 */
	public void FillDeck(int n) {
		Stack<Card> realdeck = FillRealDeck();

		Collections.shuffle(realdeck);
		for (int i = 0; i < (n); i++) {
			Deck.add(realdeck.pop());
		}
	}

	/**
	 * Build a real deck of 52 cards plus two jokers
	 */
	public Stack<Card> FillRealDeck(){
		Stack<Card> realdeck = new Stack<>();
		for(String s : Suit){
			for(int i = 1; i < 14; i++){
				Card card = new Card(s, i);
				realdeck.add(card);
			}

		}
		Card joker = new Card("joker",14);
		realdeck.add(joker);
		realdeck.add(joker);
		return realdeck;
	}
}
