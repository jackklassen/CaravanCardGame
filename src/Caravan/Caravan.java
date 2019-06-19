package Caravan;

import java.util.Stack;

public class Caravan {
	private Stack<Card> CaravanStack = new Stack<Card>();
	private Card LastCardPlayed;
	private int MinWinValue = 21;
	private int MinLossValue = 27;
	private int TotalValue = 0;
	public boolean CaravanWon = false;
	public boolean CaravanLost = false;
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
		if (TotalValue > MinWinValue && TotalValue < MinLossValue) {
			CaravanWon = true;
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @return true if the player has Lost
	 */
	public boolean CheckLoss() {
		if (TotalValue >= MinLossValue) {
			CaravanLost = true;	
			return true;
		}
		return false;
	}

	/**
	 * Method to Add the Card Given to the Caravan Selected
	 * 
	 * @param NewCard
	 * 
	 */
	public Boolean AddToCaravan(Card NewCard) {
		Boolean AddSuccess = false;

		if (CaravanStack.size() == 0) {
			if (!CheckFace(NewCard)) {
				CaravanStack.add(NewCard);
				TotalValue += NewCard.GetCardValue();
				LastCardPlayed = NewCard;
				AddSuccess = true;
			} else if (CheckFace(NewCard)) {
				AddFace(NewCard);
			}
		}

		if (CaravanStack.size() == 1) {
			if (CaravanStack.peek().GetCardValue() > NewCard.GetCardValue()) {
				Direction = "DSC";

			}
			if (CaravanStack.peek().GetCardValue() < NewCard.GetCardValue()) {
				Direction = "ASC";
			}
			// System.out.println(Direction);
		}

		if (CheckPlayable(NewCard)) {
			CaravanStack.add(NewCard);
			TotalValue += NewCard.GetCardValue();
			LastCardPlayed = NewCard;
			AddSuccess = true;
		}
		return AddSuccess;
	}

	/**
	 * check if the newcard is an ace or any other face card
	 * 
	 * @param NewCard
	 * @return
	 */

	public boolean CheckFace(Card NewCard) {
		if (NewCard.getCardType() != "A" && NewCard.GetCardValue() > 10)
			return true;
		else
			return false;
	}

	public void AddFace(Card NewCard) {
		switch (NewCard.getCardType()) {
		case "JO":
			PlayJoker(NewCard);
			break;
		case "J":
			PlayJack(NewCard);
			break;
		case "Q":
			PlayQueen(NewCard);
			break;
		case "K":
			PlayKing(NewCard);
			break;

		}
	}

	/**
	 * double add the same value as the last value card played
	 * 
	 * @param newCard
	 */
	private void PlayKing(Card newCard) {
		// TODO Auto-generated method stub
		int HighestCardValue = 0;
		for (Card c : CaravanStack) {
			if (!CheckFace(c)) {
				HighestCardValue = c.GetCardValue();
			}

			TotalValue += HighestCardValue;

			LastCardPlayed = newCard;
			CaravanStack.add(newCard);
			// check if last valuecard played
			// possibly add a new variable lastvaluecard played and mabye store its location
			// in the stack
		}
	}

	/**
	 * swap the direction of the caravan
	 * 
	 * @param newCard
	 */
	private void PlayQueen(Card newCard) {
		if (Direction == "ASC") {
			Direction = "DSC";
		} else if (Direction == "DSC") {
			Direction = "ASC";
		}

		LastCardPlayed = newCard;
		CaravanStack.add(newCard);
	}

	/**
	 * remove the top Value card and any face cards attached to it
	 * 
	 * @param newCard
	 */
	private void PlayJack(Card newCard) {
		while (CheckFace(CaravanStack.peek())) {
			CaravanStack.pop();
			if (!CheckFace(CaravanStack.peek())) {
				TotalValue = TotalValue - CaravanStack.pop().GetCardValue();
			}
		}
		LastCardPlayed = newCard;
		CaravanStack.add(newCard);
	}

	private void PlayJoker(Card newCard) {
		if (LastCardPlayed.getCardType() == "A") {
			for (Card c : CaravanStack) {
				if (c.getSuit() == LastCardPlayed.getSuit()) {
					CaravanStack.remove(c);
				}
			}
		} else if (!CheckFace(LastCardPlayed)) {
			for (Card c : CaravanStack) {
				if (c.equals(LastCardPlayed))
					break;

				else if (c.equals(LastCardPlayed.GetCardValue()))
					CaravanStack.remove(c);

			}
		}

		LastCardPlayed = newCard;
		CaravanStack.add(newCard);

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

	/**
	 * Overloaded toString Method.
	 */
	public String toString() {
		String ReturnString = null;
		Integer NewTotalValue = TotalValue;

		ReturnString = NewTotalValue.toString() + " " + LastCardPlayed + " " + Direction;

		return ReturnString;
	}

}
