package CaravanGui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
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

	private JButton Caravan1;
	private JButton Caravan2;
	private JButton Caravan3;

	public static Player PlayerObj = new Player();

	/**
	 * Launch the application.
	 */

	/**
	 * TODO: Create ToString methods for Cards And Caravans Remove a card and put a
	 * new one in the same place
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
		this.frame.setTitle("Caravan");

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 419, 267);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		Caravan1 = new JButton("New button");
		Caravan1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddToCaravan(1);
			}
		});
		Caravan1.setBounds(10, 37, 114, 89);
		frame.getContentPane().add(Caravan1);

		Caravan2 = new JButton("New button");
		Caravan2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddToCaravan(2);
			}
		});
		Caravan2.setBounds(134, 37, 111, 89);
		frame.getContentPane().add(Caravan2);

		Caravan3 = new JButton("New button");
		Caravan3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddToCaravan(3);
			}
		});
		Caravan3.setBounds(255, 37, 112, 89);
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
		Card2.setBounds(145, 140, 89, 23);
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
		Card3.setBounds(265, 140, 89, 23);
		frame.getContentPane().add(Card3);

		Card5 = new JButton("New button");
		Card5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClickedCard = PlayerObj.Hand.get(4);
			}
		});
		Card5.setBounds(145, 174, 89, 23);
		frame.getContentPane().add(Card5);
	}

	/**
	 * set up the inital Caravan Gui
	 */
	public void SetGameUp() {
		PlayerObj.CreateDeck(30);
		PlayerObj.FillHand();

		SetHand();
		SetCaravan();

	}

	public void SetHand() {
		Card1.setText(PlayerObj.Hand.get(0).toString());
		Card2.setText(PlayerObj.Hand.get(1).toString());
		Card3.setText(PlayerObj.Hand.get(2).toString());
		Card4.setText(PlayerObj.Hand.get(3).toString());
		Card5.setText(PlayerObj.Hand.get(4).toString());
	}

	public void SetCaravan() {
		Caravan1.setText(PlayerObj.PlayerCaravan1.toString());
		Caravan2.setText(PlayerObj.PlayerCaravan2.toString());
		Caravan3.setText(PlayerObj.PlayerCaravan3.toString());
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
			System.out.println(CaravanNum);
			if (AddSuccess == true) {
				PlayerObj.Hand.remove(ClickedCard);
				PlayerObj.Hand.add(PlayerObj.PlayerDeck.Deck.pop());

				SetHand();
				SetCaravan();
				CheckWinLoss();

				this.frame.revalidate();
				this.frame.repaint();
				ClickedCard = null;
			} else if (AddSuccess == false) {
				System.out.println("Card Can not be added to caravan.");
			}
		}
	}

	public int CheckWinLoss() {

		int WinNeutralLoss = 0; // -1 means lost, 0 means fine, 1 means won

		if (PlayerObj.PlayerCaravan1.CheckWin() || PlayerObj.PlayerCaravan2.CheckWin()
				|| PlayerObj.PlayerCaravan3.CheckWin()) {
			WinNeutralLoss = 1;
			JOptionPane.showMessageDialog(null, "You Have Won.");
		} else if (PlayerObj.PlayerCaravan1.CheckLoss() || PlayerObj.PlayerCaravan2.CheckLoss()
				|| PlayerObj.PlayerCaravan3.CheckLoss()) {
			WinNeutralLoss = -1;
			JOptionPane.showMessageDialog(null, "You Have Lost.");
		} else {
			WinNeutralLoss = 0;
		}

		return WinNeutralLoss;

	}
}
