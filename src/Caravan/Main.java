package Caravan;

import java.util.Scanner;

public class Main {
	public static Player PlayerObj = new Player();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Deck d = new Deck();
		// d.FillDeck(3);
		// PlayerObj.PlayerDeck.FillDeck(5);

		// d.Deck.push(d.CreateRandomCard());

		// //String PlayerInput = "";
		// PlayerObj.CreateDeck(30);
		//// PlayerObj.FillHand();
		// Card HeldCard;

		// Scanner input = new Scanner(System.in);

		Game();

		// System.out.println("You Have 5 Cards");
		// for(int i = 0; i <= 5;i++) {
		// System.out.println(PlayerObj.Hand.get(i).getCardType());

		// }
		// //PlayerInput = input.next();

		// PlayerObj.PlayerCaravan1.AddToCaravan(PlayerObj.Hand.get(1));
		// System.out.println(PlayerObj.PlayerCaravan1.getLastCardPlayed().GetCardValue());
		// System.out.println(PlayerObj.PlayerCaravan1.getTotalValue());

		// PlayerObj.PlayerCaravan1.AddToCaravan(PlayerObj.Hand.get(5));
		// System.out.println(PlayerObj.PlayerCaravan1.getLastCardPlayed().GetCardValue());
		// System.out.println(PlayerObj.PlayerCaravan1.getTotalValue());
		//

		// Game();

	}

	public static void Game() {
		String PlayerInput = "";
		PlayerObj.CreateDeck(30);
		PlayerObj.FillHand();
		Card HeldCard;

		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to Caravan.");
		while (!(PlayerInput.toLowerCase().equals("e"))) {
			
			
			System.out.println("You Have Three Caravans");
			System.out.println("Caravan 1 with the value of: " + PlayerObj.PlayerCaravan1.getTotalValue());
			System.out.println("Caravan 2 with the value of: " + PlayerObj.PlayerCaravan2.getTotalValue());
			System.out.println("Caravan 3 with the value of: " + PlayerObj.PlayerCaravan3.getTotalValue());

			System.out.println("You Have 5 Cards");
			for (int i = 0; i < 5; i++) {
				Card CurrentCard = PlayerObj.Hand.get(i);
				System.out.println(
						CurrentCard.getCardType() + " " + CurrentCard.getColour() + " " + CurrentCard.getSuit());

			}
			PlayerInput = input.next();
			CardToCaravanInput(PlayerInput);
			
		}

		System.out.println("Good bye. :)");
		/*
		 * todo:
		 * 
		 * --ask for user input add to caravan and complete the basic loop.-- code
		 * removes card from hand
		 */
	}

	/**
	 * Handle the user inputing what card goes to what caravan
	 */
	public static void CardToCaravanInput(String Input) {
		// user enters a (cardval)(caravan number) string this adds the card to the
		// caravan
		String InputCard = String.valueOf(Input.charAt(0));

		char inputCaravn = Input.charAt(1);

		// add a get based on value method into the player hand class
		Card PlayedCard = PlayerObj.PlayCard(InputCard);
		switch (inputCaravn) {
		case ('1'):
			PlayerObj.PlayerCaravan1.AddToCaravan(PlayedCard);
			break;
		case ('2'):
			PlayerObj.PlayerCaravan2.AddToCaravan(PlayedCard);
			break;
		case ('3'):
			PlayerObj.PlayerCaravan3.AddToCaravan(PlayedCard);
			break;

		}
	}

}
