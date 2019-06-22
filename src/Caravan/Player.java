package Caravan;

import java.util.ArrayList;
import java.util.List;

public class Player {
	public List<Card> Hand = new ArrayList<Card>();
	public Deck PlayerDeck = new Deck();
	public boolean PlayerHasWon = false;
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
	 * use The PlayerDeck to fill a hand
	 */
	public void FillHand() {

		for (int i = 0; i < 5; i++) {
			Hand.add(PlayerDeck.Deck.pop());
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

}
