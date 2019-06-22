package Caravan;

import java.util.ArrayList;
import java.util.List;

public class Player {
	public List<Card> Hand = new ArrayList<Card>();
	public Deck PlayerDeck = new Deck();

	public boolean PlayerHasWon = false;
	public boolean PlayerHasLost = false;

	public int TotalPlayerValue = 0;

	public Caravan PlayerCaravan1 = new Caravan();
	public Caravan PlayerCaravan2 = new Caravan();
	public Caravan PlayerCaravan3 = new Caravan();

	// list of cards popped from deck
	/**
	 * 
	 * @param n
	 * 
	 *          Call the Fill Deck Method For the Current PlayerDeck
	 */
	public void CreateDeck(int n) {
		PlayerDeck.FillDeck(n);
	}
	/**
	 * Draws a New Card From the Deck
	 * @param SpentCard
	 */
	public void DrawACard(Card SpentCard){
		if(PlayerDeck.Deck.size() > 5) {
		Hand.remove(SpentCard);
		Hand.add(PlayerDeck.Deck.pop());
		} //need to add a way of putting in "null"or dud cards when deck is empty
	}

	/**
	 * use The PlayerDeck to fill a hand
	 */
	public void FillHand() {
		if(PlayerDeck.Deck.size() > 5) {
		for (int i = 0; i < 5; i++) {
			Hand.add(PlayerDeck.Deck.pop());
		}
		}
	}

	public void RedrawHand() {
		if(PlayerDeck.Deck.size() > 5) {
			//for(Card c: Hand) {
				//PlayerDeck.Deck.add(PlayerDeck.Deck.size(), c);
				
		//	}
		Hand.clear();
		FillHand();
		} 
	}

	/**
	 * Handle Finding a card in the hand removing it and getting a new card.
	 */
	public Card PlayCard(String CardType) {

		Card PlayedCard = null;
		int HandSize = Hand.size();
		Card CurrentCard = null;

		for (int i = 0; i < HandSize; i++) {
			CurrentCard = Hand.get(i);
			if (CurrentCard.getCardType().equals(CardType)) {
				PlayedCard = Hand.get(i);
				Hand.remove(i);
				break;
			}
		}
		Hand.add(PlayerDeck.Deck.pop());

		return PlayedCard;
	}

	public void SetGameUp() {
		CreateDeck(30);
		FillHand();
	}

	/**
	 * Checks if the player has won or lost and if any caravan is complete and sets
	 * values according to that
	 * 
	 * @return
	 */
	public int CheckWinLoss() {

		int WinNeutralLoss = 0; // -1 means lost, 0 means fine, 1 means won

		if (PlayerCaravan1.CheckWin()) {
			WinNeutralLoss = 1;
			TotalPlayerValue += PlayerCaravan1.getTotalValue();

		} else if (PlayerCaravan2.CheckWin()) {
			TotalPlayerValue += PlayerCaravan2.getTotalValue();
			WinNeutralLoss = 1;

		} else if (PlayerCaravan3.CheckWin()) {
			TotalPlayerValue += PlayerCaravan2.getTotalValue();
			WinNeutralLoss = 1;

			WinNeutralLoss = 1;

		} else if (PlayerCaravan1.CheckLoss() || PlayerCaravan2.CheckLoss() || PlayerCaravan3.CheckLoss()) {
			PlayerHasLost = true;
			WinNeutralLoss = -1;
		} else if (PlayerCaravan1.CheckWin() && PlayerCaravan2.CheckWin() && PlayerCaravan3.CheckWin()) {
			PlayerHasWon = true;
		} else {
			WinNeutralLoss = 0;
		}

		return WinNeutralLoss;

	}

}
