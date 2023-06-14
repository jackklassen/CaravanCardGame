package Caravan;

import java.util.Stack;

public class Caravan {
	private Stack<Card> CaravanStack = new Stack<>();
	private Card LastCardPlayed;
	private Card LastValueCardPlayed;
	private int TotalValue = 0;
	public boolean CaravanWon = false;
	public boolean CaravanLost = false;
	private String Direction = ""; // caravan must be going up in value or down in value the second card played in
									// a caravan determines this

	private String Suit = ""; // use to set suit so that if a joker is played its not checking the suit of a joker

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
	 *         direction and suit
	 */
	public boolean CheckPlayable(Card NextCard) {
		if(((TotalValue + NextCard.getCardType()) < 26)){
			//if the next card would put the caravan over the upper limt
			// and it isn't a jack or a joker then don't allow it to be played
			if (CheckDirection(NextCard)) {
				System.out.println("Direction Passed");
				return true;
			} else if (CheckSuit(NextCard)) {
				System.out.println("Suit Passed");
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
			if (NextCard.getCardType() <= LastValueCardPlayed.getCardType()) {
				return true;
			}
		} else if (Direction == "ASC") {
			if (NextCard.getCardType() >= LastValueCardPlayed.getCardType()) {
				return true;
			}

		}
		return false;
	}

	/**
	 * 
	 * @param NextCard
	 * @return true if Suit of the NextCard is the same as the LastCardPlayed.
	 */
	public boolean CheckSuit(Card NextCard) {
		if (NextCard.getSuit() == LastValueCardPlayed.getSuit())
			return true;
		return false;
	}

	/**
	 * sets a cravan as sold or sellable.
	 * @return True if the caravan is sold/sellable, false if not
 	 */
	public boolean CheckSold() {
		if (TotalValue > 20 && TotalValue < 27) {
			CaravanWon = true;
			return true;
		}
		return false;
	}



	/**
	 * Method to Add the Card Given to the Caravan Selected
	 * overbloated, not very functional.
	 * @param NewCard
	 * 
	 */
	public Boolean AddToCaravan(Card NewCard) {


		if (CaravanStack.size() == 0) {
			if (!CheckFace(NewCard)) {
				CaravanStack.add(NewCard);
				TotalValue += NewCard.getCardType();
				LastCardPlayed = NewCard;
				LastValueCardPlayed = NewCard;
				return true;
			} else if (CheckFace(NewCard))
				return false;
		}

		if (CaravanStack.size() == 1) {
			if (CaravanStack.peek().getCardType() > NewCard.getCardType()) {
				Direction = "DSC";
				CaravanStack.add(NewCard);
				TotalValue += NewCard.getCardType();
				LastCardPlayed = NewCard;
				LastValueCardPlayed = NewCard;
				return true;
			}
			if (CaravanStack.peek().getCardType() < NewCard.getCardType()) {
				Direction = "ASC";
				CaravanStack.add(NewCard);
				TotalValue += NewCard.getCardType();
				LastCardPlayed = NewCard;
				LastValueCardPlayed = NewCard;
				return true;
			}
			return false; //something went wrong return false.
		}
		if (CaravanStack.size() > 1) {
			if (CheckFace(NewCard)) {
				AddFace(NewCard);
			} else{
				if (CheckPlayable(NewCard)) {
					CaravanStack.add(NewCard);
					TotalValue += NewCard.getCardType();
					LastCardPlayed = NewCard;
					LastValueCardPlayed = NewCard;
					return true;
				}
			}

		}
		return false;
	}

	/**
	 * check if the newcard is an ace or any other face card
	 * 
	 * @param NewCard
	 * @return
	 */

	public boolean CheckFace(Card NewCard) {
		if (NewCard.getCardType() > 10)
			return true;
		else
			return false;
	}

	private void AddFace(Card NewCard) {
		switch (NewCard.getCardType()) {
		case 14:
			PlayJoker(NewCard);
			break;
		case 11:
			PlayJack(NewCard);
			break;
		case 12:
			PlayQueen(NewCard);
			break;
		case 13:
			PlayKing(NewCard);
			break;
		}
	}

	/**
	 * double add the same value as the last value card played
	 * 
	 * @param newCard
	 */
	/*
	 * private void PlayKing(Card newCard) {
	 * 
	 * int HighestCardValue = 0; for (Card c : CaravanStack) { if (!CheckFace(c)) {
	 * HighestCardValue = c.GetCardValue(); }
	 * 
	 * TotalValue += HighestCardValue;
	 * 
	 * LastCardPlayed = newCard; CaravanStack.add(newCard); // check if last
	 * valuecard played // possibly add a new variable lastvaluecard played and
	 * mabye store its location // in the stack } }
	 */

	private boolean PlayKing(Card newCard) {

		if (!CheckFace(LastCardPlayed)) {
			TotalValue += LastCardPlayed.getCardType();
			CaravanStack.add(newCard);
			return true;
		}
		return false;
	}

	/**
	 * swap the direction of the caravan
	 * 
	 * @param newCard
	 */
	private boolean PlayQueen(Card newCard) {
		if (Direction == "ASC") {
			Direction = "DSC";
		} else if (Direction == "DSC") {
			Direction = "ASC";
		}

		//keep last card played as the last non-face card
		CaravanStack.add(newCard);
		return true;
	}

	/**
	 * remove the top Value card and any face cards attached to it
	 * 
	 * @param newCard
	 */
	private void PlayJack(Card newCard) {
		TotalValue =- LastValueCardPlayed.getCardType();
		
		
		while (CheckFace(CaravanStack.peek())) {
			CaravanStack.pop();
			if (!CheckFace(CaravanStack.peek())) {
				TotalValue = TotalValue - CaravanStack.pop().getCardType();
				break;
			}
		}
		LastCardPlayed = CaravanStack.peek(); //whatever is just below the Jack
		CaravanStack.add(newCard);

	}

	/**
	 * Joker is messy put some thought into making this work
	 * @param newCard
	 * @return
	 */
	private boolean PlayJoker(Card newCard) {
		if (LastCardPlayed.getCardType() == 1) {
			for (Card c : CaravanStack) {
				if (c.getSuit() == LastCardPlayed.getSuit()) {
					CaravanStack.remove(c);
				}
			}
		} else if (!CheckFace(LastCardPlayed)) {
			for (Card c : CaravanStack) {
				if (c.equals(LastCardPlayed))
					break;

				else if (c.equals(LastCardPlayed.getCardType()))
					CaravanStack.remove(c);

			}
		} else if (CheckFace(LastCardPlayed)) {
			return false;
		}

		LastCardPlayed = newCard;
		CaravanStack.add(newCard);
		return true;
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
		String returnstring = "No Card";
		if (!(LastCardPlayed == null)){
			returnstring = LastCardPlayed.toString();
		}

		return returnstring;
	}

	/**
	 * 
	 * @return Total Value in String form
	 */
	public String GetTotalValueStr() {
		String ReturnString = null;
		Integer NewTotalValue = TotalValue;

		ReturnString = NewTotalValue.toString();

		return ReturnString;
	}

	/**
	 * Methods to return the information needed to the GUI
	 * 
	 * @return
	 */
	public String GetDirection() {
		return Direction;
	}

	public Card GetLastCardPlayed() {
		return LastCardPlayed;
	}

	public Card GetLastValueCardPlayed() {
		return LastValueCardPlayed;

	}

	public int GetTotalValue() {
		return TotalValue;
	}

}
