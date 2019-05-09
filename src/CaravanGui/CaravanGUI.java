package CaravanGui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import Caravan.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CaravanGUI {

	private JFrame frame;
	private Card ClickedCard = null;
	

	private JButton Card1;
	private JButton Card2;
	private JButton Card3;
	private JButton Card4;
	private JButton Card5;
	
	private static JButton Caravan1;
	private JButton Caravan2;
	private JButton Caravan3;

	
	public static Player PlayerObj = new Player();

	/**
	 * Launch the application.
	 */

	/**
	 * TODO: set each card button to a card when card button is clicked set it as
	 * active card then when the user clicks the caravan add card to caravan
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CaravanGUI window = new CaravanGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CaravanGUI() {
		initialize();
		SetGameUp();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 368, 267);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		 Caravan1 = new JButton("New button");
		 Caravan1.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		AddToCaravan(1);
		 	}
		 });
		Caravan1.setBounds(21, 37, 89, 89);
		frame.getContentPane().add(Caravan1);

		 Caravan2 = new JButton("New button");
		 Caravan2.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		AddToCaravan(2);
		 	}
		 });
		Caravan2.setBounds(120, 37, 89, 89);
		frame.getContentPane().add(Caravan2);

		 Caravan3 = new JButton("New button");
		 Caravan3.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		AddToCaravan(2);
		 	}
		 });
		Caravan3.setBounds(219, 37, 89, 89);
		frame.getContentPane().add(Caravan3);

		 Card1 = new JButton("New button");
		 Card1.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {
		 		ClickedCard = PlayerObj.Hand.get(0);
		 	}
		 });
		Card1.setBounds(21, 140, 89, 23);
		frame.getContentPane().add(Card1);

		 Card2 = new JButton("New button");
		 Card2.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		ClickedCard = PlayerObj.Hand.get(1);
		 	}
		 });
		Card2.setBounds(120, 140, 89, 23);
	    frame.getContentPane().add(Card2);

		 Card4 = new JButton("New button");
		 Card4.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		ClickedCard = PlayerObj.Hand.get(3);
		 	}
		 });
		Card4.setBounds(21, 174, 89, 23);
		frame.getContentPane().add(Card4);

		 Card3 = new JButton("New button");
		 Card3.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		ClickedCard = PlayerObj.Hand.get(2);
		 	}
		 });
		Card3.setBounds(219, 140, 89, 23);
		frame.getContentPane().add(Card3);

		 Card5 = new JButton("New button");
		 Card5.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		ClickedCard = PlayerObj.Hand.get(4);
		 	}
		 });
		Card5.setBounds(120, 174, 89, 23);
		frame.getContentPane().add(Card5);
	}
	/**
	 * set up the Caravan Gui
	 */
	public void SetGameUp() {
		PlayerObj.CreateDeck(30);
		PlayerObj.FillHand();
		
		
		
		
		SetHand();
		
		/**
		 * set up the caravan buttons
		 * 
		 */
	}
	public void SetHand() {
		Card1.setText(PlayerObj.Hand.get(0).getCardType());
		Card2.setText(PlayerObj.Hand.get(1).getCardType());
		Card3.setText(PlayerObj.Hand.get(2).getCardType());
		Card4.setText(PlayerObj.Hand.get(3).getCardType());
		Card5.setText(PlayerObj.Hand.get(4).getCardType());
	}
	
	public void AddToCaravan(int CaravanNum) {
		switch(CaravanNum) {
		case(1):
			PlayerObj.PlayerCaravan1.AddToCaravan(ClickedCard);
			break;
		case(2):
			PlayerObj.PlayerCaravan2.AddToCaravan(ClickedCard);
			break;
		case(3):
			PlayerObj.PlayerCaravan1.AddToCaravan(ClickedCard);
			break;
		}
		System.out.println(CaravanNum);
		
		PlayerObj.Hand.remove(ClickedCard);
		PlayerObj.Hand.add(PlayerObj.PlayerDeck.Deck.pop());
		
		SetHand();
		this.frame.revalidate();
		this.frame.repaint();
	}

}
