package Caravan;

public class Card {
	/**
	 * TODO: make the card be only numbers and suits no colour, add jokers in a normal way i.e. only two
	 * */
	private String Suit;
	private int CardType;

	public Card(String suit, int cardType) {
		Suit = suit;
		CardType = cardType;
	}

	public String getSuit() {
		return Suit;
	}

	public void setSuit(String suit) {
		Suit = suit;
	}

	public int getCardType() {
		return CardType;
	}

	public void setCardType(int cardType) {
		CardType = cardType;
	}

	/**
	 * Overloaded toString Method.
	 */
	
	public String toString() {
		String ReturnString = null;
		
		ReturnString = CardType +" "+ Suit + " ";
		
		
		return ReturnString;
		
	}
}
