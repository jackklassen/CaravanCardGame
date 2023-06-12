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
	 * if it returns false then the deck is empty and the player who pulled a new card either loses or at least ends the game.
	 * @param SpentCard
	 */
	public boolean DrawACard(Card SpentCard){
		int index = Hand.indexOf(SpentCard);
		try{
			Card newcard = PlayerDeck.Deck.pop();
			Hand.set(index,newcard);
			return true;
		} catch (Exception E){
			return false;
		}

	}

	/**
	 * use The PlayerDeck to fill a hand.
	 * should really only happen once
	 */
	public void FillHand() {
		if(PlayerDeck.Deck.size() > 8) {
		for (int i = 0; i < 8; i++) {
			Hand.add(PlayerDeck.Deck.pop());
		}
		}
	}
	public void PlayCard(Card currentcard, int caravannum){
		switch (caravannum){
			case 1:
				PlayerCaravan1.AddToCaravan(currentcard);
				DrawACard(currentcard);
				break;
			case 2:
				PlayerCaravan2.AddToCaravan(currentcard);
				DrawACard(currentcard);
				break;
			case 3:
				PlayerCaravan3.AddToCaravan(currentcard);
				DrawACard(currentcard);
				break;
		}

	}

	public void SetGameUp() {
		CreateDeck(30);
		FillHand();
	}

	/**
	 * this is wrong, it is not how caravan works and this should be moved to the caravine pile itself to account for if a pile is sold or under/over burdened
	 * 
	 * @return
	 */
	/**public int CheckWinLoss() {

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

	}*/

}
