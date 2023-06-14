package Caravan;

import java.util.ArrayList;
import java.util.List;

public class Player {
	public List<Card> Hand = new ArrayList<Card>();
	public Deck PlayerDeck = new Deck();

	public boolean isAI;
	public boolean isCurrent;


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

	/**
	 * part of playing the cards to the caravans that the GUI interacts with.
	 * @param currentcard
	 * @param caravannum
	 * @return
	 */
	public boolean PlayCard(Card currentcard, int caravannum) { //the card check isn't working its not letting me play cards that sould be playable.
		if (!(currentcard == null)) {

			switch (caravannum) {
				case 1:
					if (PlayerCaravan1.AddToCaravan(currentcard)) {
						DrawACard(currentcard);
						return true;
					}
				case 2:
					if (PlayerCaravan2.AddToCaravan(currentcard)) {
						DrawACard(currentcard);
						return true;
					}
				case 3:
					if (PlayerCaravan3.AddToCaravan(currentcard)) {
						DrawACard(currentcard);
						return true;
					}
			}
			return false;
		}
		return false;
	}
	public void SetGameUp() {
		CreateDeck(30);
		FillHand();
	}

	public boolean DumpCaravan(int caravannum){
		switch (caravannum){
			case 1:
				PlayerCaravan1 = new Caravan();
				return true;
			case 2:
				PlayerCaravan2 = new Caravan();
				return true;
			case 3:
				PlayerCaravan3 = new Caravan();
				return true;
		}return false;
	}

	/**
	 * Fairly simple AI way to play the the game.
	 * get the biggest value non-face card and try to play it.
	 * if you can't get rid of the card and try again.
	 * @return
	 */
	public boolean PlayAI(){
		Card largestvaluecard = null;
		int largestvalue = 0;


		for(Card c : Hand){
			if(!(PlayerCaravan1.CheckFace(c))){
				if(c.getCardType() > largestvalue){
					largestvalue = c.getCardType();
					largestvaluecard = c;
				}
			}
		}
		if(largestvaluecard == null){
			DrawACard(Hand.get(0)); // if all the cards in the hand are faces just draw a new card.
			return true;
		}

		for(int i = 1; i < 4;  i++){
			if(PlayCard(largestvaluecard,i)){
				return true;
			}
		}
		DrawACard(largestvaluecard);
		return false;
	}

}
