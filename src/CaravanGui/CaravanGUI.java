package CaravanGui;


import Caravan.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CaravanGUI {

	private JFrame frame;
	private Card ClickedCard = null;

	private JButton Card1;
	private JButton Card2;
	private JButton Card3;
	private JButton Card4;
	private JButton Card5;

	private JButton Caravan1;
	private JButton Caravan2;
	private JButton Caravan3;

	private JLabel lblCaravanTotal1;
	private JLabel lblCaravanTotal2;
	private JLabel lblCaravanTotal3;

	private JLabel lblCaravanDirecttion1;
	private JLabel lblCaravanDirecttion2;
	private JLabel lblCaravanDirecttion3;

	private JLabel lblCurrentPlayer;
	private JLabel lblTotalValue;

	public boolean TwoPlayers = false;
	private int CurrentPlayer = 1;

	public static Player Player1;
	public static Player Player2;

	public static Player PlayerObj = new Player();

	/**
	 * Launch the application.
	 */

	/**
	 * TODO: Create ToString methods for Cards And Caravans Remove a card and put a
	 * new one in the same place
	 * 
	 * reduce amount done on this gui make gui better for two players
	 * 
	 * add images
	 * 
	 * 
	 * add proper rule https://fallout.fandom.com/wiki/Caravan_(game)
	 */
	// public static void main(String[] args) {
	public static void NewScreen(String Name) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CaravanGUI window = new CaravanGUI(Name);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

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
		this.frame.setTitle("Caravan");

	}

	public CaravanGUI(String Name) {

		initialize();
		SetGameUp();
		this.frame.setTitle(Name);

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 525, 653);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		Caravan1 = new JButton("New button");
		Caravan1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddToCaravan(1);
			}
		});
		Caravan1.setBounds(37, 50, 100, 150);
		frame.getContentPane().add(Caravan1);

		Caravan2 = new JButton("New button");
		Caravan2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddToCaravan(2);
			}
		});
		Caravan2.setBounds(202, 50, 100, 150);
		frame.getContentPane().add(Caravan2);

		Caravan3 = new JButton("New button");
		Caravan3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddToCaravan(3);
			}
		});
		Caravan3.setBounds(347, 50, 100, 150);
		frame.getContentPane().add(Caravan3);

		Card1 = new JButton("New button");
		Card1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ClickedCard = PlayerObj.Hand.get(0);
			}
		});
		Card1.setBounds(55, 257, 100, 150);
		frame.getContentPane().add(Card1);

		Card2 = new JButton("New button");
		Card2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClickedCard = PlayerObj.Hand.get(1);
			}
		});
		Card2.setBounds(203, 257, 100, 150);
		frame.getContentPane().add(Card2);

		Card4 = new JButton("New button");
		Card4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClickedCard = PlayerObj.Hand.get(3);
			}
		});
		Card4.setBounds(125, 418, 100, 150);
		frame.getContentPane().add(Card4);

		Card3 = new JButton("New button");
		Card3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClickedCard = PlayerObj.Hand.get(2);
			}
		});
		Card3.setBounds(362, 257, 100, 150);
		frame.getContentPane().add(Card3);

		Card5 = new JButton("New button");
		Card5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClickedCard = PlayerObj.Hand.get(4);
			}
		});
		Card5.setBounds(282, 418, 100, 150);
		frame.getContentPane().add(Card5);

		lblCaravanTotal1 = new JLabel("New label");
		lblCaravanTotal1.setBounds(26, 209, 135, 14);
		frame.getContentPane().add(lblCaravanTotal1);

		lblCaravanTotal2 = new JLabel("New label");
		lblCaravanTotal2.setBounds(189, 209, 148, 14);
		frame.getContentPane().add(lblCaravanTotal2);

		lblCaravanTotal3 = new JLabel("New label");
		lblCaravanTotal3.setBounds(347, 209, 138, 14);
		frame.getContentPane().add(lblCaravanTotal3);

		lblCaravanDirecttion1 = new JLabel("New label");
		lblCaravanDirecttion1.setBounds(26, 227, 135, 14);
		frame.getContentPane().add(lblCaravanDirecttion1);

		lblCaravanDirecttion2 = new JLabel("New label");
		lblCaravanDirecttion2.setBounds(189, 227, 148, 14);
		frame.getContentPane().add(lblCaravanDirecttion2);

		lblCaravanDirecttion3 = new JLabel("New label");
		lblCaravanDirecttion3.setBounds(347, 227, 138, 14);
		frame.getContentPane().add(lblCaravanDirecttion3);

		lblTotalValue = new JLabel("Total Value: ");
		lblTotalValue.setBounds(50, 25, 73, 14);
		frame.getContentPane().add(lblTotalValue);
		
		lblCurrentPlayer = new JLabel("");
		lblCurrentPlayer.setBounds(223, 11, 46, 14);
		frame.getContentPane().add(lblCurrentPlayer);
		
		JButton btnRedrawHand = new JButton("Re-Draw Hand");
		btnRedrawHand.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PlayerObj.RedrawHand();
				SetHand();
			}});
		btnRedrawHand.setBounds(198, 579, 123, 23);
		frame.getContentPane().add(btnRedrawHand);
	}

	public void ChangePlayer(Player NewPlayer) {
		PlayerObj = NewPlayer;
		SetHand();
		SetCaravan();

		this.frame.revalidate();
		this.frame.repaint();
	}

	/**
	 * set up the inital Caravan Gui
	 */
	public void SetGameUp() {
		PlayerObj.SetGameUp();
		SetHand();
		SetCaravan();

	}

	/**
	 * Set Up the GUI for the hand of cards
	 */
	public void SetHand() {
		Card1.setText(PlayerObj.Hand.get(0).toString());
		Card2.setText(PlayerObj.Hand.get(1).toString());
		Card3.setText(PlayerObj.Hand.get(2).toString());
		Card4.setText(PlayerObj.Hand.get(3).toString());
		Card5.setText(PlayerObj.Hand.get(4).toString());

		Icon Card1Image = new ImageIcon("");
		Card1.setIcon(Card1Image);
		Icon Card2Image = new ImageIcon(
				"cardimages/" + PlayerObj.Hand.get(1).getCardType() + PlayerObj.Hand.get(1).getColour() + ".png");
		Card2.setIcon(Card2Image);
		Icon Card3Image = new ImageIcon(
				"cardimages/" + PlayerObj.Hand.get(2).getCardType() + PlayerObj.Hand.get(2).getColour() + ".png");
		Card3.setIcon(Card3Image);
		Icon Card4Image = new ImageIcon(
				"cardimages/" + PlayerObj.Hand.get(3).getCardType() + PlayerObj.Hand.get(3).getColour() + ".png");
		Card4.setIcon(Card4Image);
		Icon Card5Image = new ImageIcon(
				"cardimages/" + PlayerObj.Hand.get(4).getCardType() + PlayerObj.Hand.get(4).getColour() + ".png");
		Card5.setIcon(Card5Image);

	}

	/**
	 * set up the GUI for the Caravans
	 */

	public void SetCaravan() {
		Caravan1.setText(PlayerObj.PlayerCaravan1.toString());
		Caravan2.setText(PlayerObj.PlayerCaravan2.toString());
		Caravan3.setText(PlayerObj.PlayerCaravan3.toString());

		lblCaravanTotal1.setText("Total Caravan Value: " + PlayerObj.PlayerCaravan1.GetTotalValueStr());
		lblCaravanTotal2.setText("Total Caravan Value: " + PlayerObj.PlayerCaravan2.GetTotalValueStr());
		lblCaravanTotal3.setText("Total Caravan Value: " + PlayerObj.PlayerCaravan3.GetTotalValueStr());

		lblCaravanDirecttion1.setText("Caravan Direction: " + PlayerObj.PlayerCaravan1.GetDirection());
		lblCaravanDirecttion2.setText("Caravan Direction: " + PlayerObj.PlayerCaravan2.GetDirection());
		lblCaravanDirecttion3.setText("Caravan Direction: " + PlayerObj.PlayerCaravan3.GetDirection());

	}

	public void AddToCaravan(int CaravanNum) {
		boolean AddSuccess = false;
		if (ClickedCard != null) {
			switch (CaravanNum) {
			case (1):
				AddSuccess = PlayerObj.PlayerCaravan1.AddToCaravan(ClickedCard);
				break;
			case (2):
				AddSuccess = PlayerObj.PlayerCaravan2.AddToCaravan(ClickedCard);
				break;
			case (3):
				AddSuccess = PlayerObj.PlayerCaravan3.AddToCaravan(ClickedCard);
				break;

			}
			
			if (AddSuccess == true) {
				PlayerObj.DrawACard(ClickedCard);

				if (TwoPlayers == true) {
					if (CurrentPlayer == 1) {
						ChangePlayer(Player2);
						CurrentPlayer = 2;
						lblCurrentPlayer.setText("Player 2");
					} else if (CurrentPlayer == 2) {
						ChangePlayer(Player1);
						CurrentPlayer = 1;
						lblCurrentPlayer.setText("Player 1");
					}
				}

				SetHand();
				SetCaravan();
				// CheckWinLoss();

				this.frame.revalidate();
				this.frame.repaint();
				ClickedCard = null;
			} else if (AddSuccess == false) {
				System.out.println("Card Can not be added to caravan.");
			}
		}
	}

	public int CheckWinLoss() {

		return PlayerObj.CheckWinLoss();

	}
}
