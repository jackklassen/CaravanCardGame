package CaravanGui;

import Caravan.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainScreen {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainScreen window = new MainScreen();
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
	public MainScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 *
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 129, 255);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnTwoPlayer = new JButton("Two Player");
		btnTwoPlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RunTwoPlayers();
			}
		});
		btnTwoPlayer.setBounds(10, 49, 101, 23);
		frame.getContentPane().add(btnTwoPlayer);

		JButton btnSinglePlayer = new JButton("Single Player");
		btnSinglePlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RunOnePlayer();
			}
		});
		btnSinglePlayer.setBounds(10, 83, 101, 23);
		frame.getContentPane().add(btnSinglePlayer);
	}

	public void RunOnePlayer() {
		CaravanGUI Game = new CaravanGUI();

		Player Player1 = new Player();
		Player AI = new Player();

		Player1.SetGameUp();
		AI.isAI = true;


		AI.SetGameUp();
		Game.Player1 = Player1;
		Game.Player2 = AI;

		Game.StartGUI();
		this.frame.dispose();

	}

	/**
	 * mangage two human players
	 */
	public void RunTwoPlayers() {


		CaravanGUI Game = new CaravanGUI();

		
			Player Player1 = new Player();
			Player Player2 = new Player();
			Player2.isAI = false;
			Player1.isCurrent = true;

			Player1.SetGameUp();
			Player2.SetGameUp();
			Game.Player1 = Player1;
			Game.Player2 = Player2;
			System.out.println("RunTwoCalled");


			Game.StartGUI();
			this.frame.dispose();
	}
}
