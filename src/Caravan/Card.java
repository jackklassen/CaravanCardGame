package Caravan;

public class Card {

	private String Colour;
	private String Suit;
	private String CardType;
	private String AceHighLow = "Low";

	public Card(String colour, String suit, String cardType) {
		Colour = colour;
		Suit = suit;
		CardType = cardType;
	}

	public String getColour() {
		return Colour;
	}

	public void setColour(String colour) {
		Colour = colour;
	}

	public String getSuit() {
		return Suit;
	}

	public void setSuit(String suit) {
		Suit = suit;
	}

	public String getCardType() {
		return CardType;
	}

	public void setCardType(String cardType) {
		CardType = cardType;
	}

	public String getAceHighLow() {
		return AceHighLow;
	}

	/**
	 * 
	 * @param aceHighLow Check if the user wants aces to be high or low
	 * 
	 */
	public void setAceHighLow(String aceHighLow) {
		if (!(aceHighLow == "High") && !(aceHighLow == "Low")) // if not an aproved input dont do anything
			System.out.println("Wrong Form of Input Try Low or High");
		else
			AceHighLow = aceHighLow;
	}

	/**
	 * 
	 * @return CardValue
	 * 
	 *         check the card type and return an int value for that card
	 */
	public int GetCardValue() {
		int CardValue = 0;

		switch (CardType) {
		case "2":
		case "3":
		case "4":
		case "5":
		case "6":
		case "7":
		case "8":
		case "9":
		case "10":
			return Integer.parseInt(CardType);

		case "A":
			if (AceHighLow == "High")
				return 14;
			return 1;
		case "J":
			return 11;
		case "Q":
			return 12;
		case "K":
			return 13;

		}
		return CardValue;

	}
}
