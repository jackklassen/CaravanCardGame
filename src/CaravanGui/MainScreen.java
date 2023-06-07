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
		CaravanGUI Player1 = new CaravanGUI();
		Player1.NewScreen("Caravan");
		Player1.TwoPlayers = false;
	}

	/**
	 * mangage two human players
	 */
	public void RunTwoPlayers() {
		boolean GameDone = false;
		//while (!GameDone) {
		CaravanGUI Game = new CaravanGUI();
		
			Player Player1 = new Player();
			Player Player2 = new Player();
			
			Player1.SetGameUp();
			Player2.SetGameUp();
			
			Game.TwoPlayers = true;
			
			Game.Player2 = Player2;
			Game.NewScreen("Caravan");
			
			//Game.ChangePlayer(Player2);
			
			
			
		//}

	}
}
