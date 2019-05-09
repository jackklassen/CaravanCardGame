package Caravan;

import java.util.Stack;

public class Caravan {
	private Stack<Card> CaravanStack = new Stack<Card>();
	private Card LastCardPlayed;
	private int TotalValue = 0;
	private String Direction; // caravan must be going up in value or down in value the second card played in
								// a caravan determines this

	public Card getLastCardPlayed() {
		return LastCardPlayed;
	}

	public void setLastCardPlayed(Card lastCardPlayed) {
		LastCardPlayed = lastCardPlayed;
	}

	public int getTotalValue() {
		return TotalValue;
	}

	/**
	 * 
	 * @param NextCard
	 * @return true if card can be played false if it can't.
	 * 
	 *         use sub playable methods to check if the Card works based on
	 *         direction and colour
	 */
	public boolean CheckPlayable(Card NextCard) {
		if (CheckDirection(NextCard)) {
			System.out.println("Direction Passed");
			if (CheckColour(NextCard)) {
				System.out.println("Colour Passed");
				return true;
			}
		}
		return false;
	}

	/**
	 * 
	 * @param NextCard
	 * @return true if NextCard works with the Caravans Direction
	 * 
	 */
	public boolean CheckDirection(Card NextCard) {
		if (Direction == "DSC") {
			if (NextCard.GetCardValue() <= LastCardPlayed.GetCardValue()) {
				return true;
			} else if (Direction == "ASC") {
				if (NextCard.GetCardValue() >= LastCardPlayed.GetCardValue()) {
					return true;
				}
			}

		}
		return false;
	}

	/**
	 * 
	 * @param NextCard
	 * @return true if Color of the NextCard is different form the LastCardPlayed
	 *         Color.
	 */
	public boolean CheckColour(Card NextCard) {
		if (NextCard.getColour() == LastCardPlayed.getColour())
			return false;
		return true;
	}

	/**
	 * 
	 * @return true if the Player has won
	 */
	public boolean CheckWin() {
		if (TotalValue == 30)
			return true;
		return false;
	}

	/**
	 * 
	 * @return true if the player has Lost
	 */
	public boolean CheckLoss() {
		if (TotalValue > 30)
			return true;
		return false;
	}

	/**
	 * 
	 * @param NewCard
	 * 
	 */
	public void AddToCaravan(Card NewCard) {
		if (CaravanStack.size() == 0) {
			CaravanStack.add(NewCard);
			TotalValue += NewCard.GetCardValue();
			LastCardPlayed = NewCard;
		}

		if (CaravanStack.size() == 1) {
			if (CaravanStack.peek().GetCardValue() > NewCard.GetCardValue()) {
				Direction = "DSC";

			}
			if (CaravanStack.peek().GetCardValue() < NewCard.GetCardValue()) {
				Direction = "ASC";
			}
			System.out.println(Direction);

		}
		if (CheckPlayable(NewCard)) {
			CaravanStack.add(NewCard);
			TotalValue += NewCard.GetCardValue();
			LastCardPlayed = NewCard;
		}

	}

	/**
	 * @return a Peek at the CaravanStack
	 */
	public Card PeekCarvan() {
		return CaravanStack.peek();
	}

	/**
	 * 
	 * @return A pop of the Caravan Stack
	 */
	public Card PopCaravan() {
		return CaravanStack.pop();
	}

	/**
	 * Empty the CaravanStack
	 */
	public void EmptyCaravan() {
		CaravanStack.empty();
	}

}
