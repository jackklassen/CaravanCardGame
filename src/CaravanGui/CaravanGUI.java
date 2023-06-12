package CaravanGui;

import javax.swing.*;
import Caravan.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CaravanGUI {


    private Card clickedcard = null;
    public boolean TwoPlayers = false;
    private int CurrentPlayer = 1;

    public static Player Player1;
    public static Player Player2;

    public static Player PlayerObj = new Player();

    private JFrame frame;
    private JPanel toppanel;
    private JPanel bottompanel;
    private JPanel middlepanel;
    private JButton dumppile1Button;
    private JButton dumppile3Button;
    private JButton dumppile2Button;
    private JButton card1Button;
    private JButton card2Button;
    private JButton card3Button;
    private JButton card4Button;
    private JButton card5Button;
    private JButton card6Button;
    private JButton card7Button;
    private JButton card8Button;
    private JButton pile1Button;
    private JButton pile2Button;
    private JButton pile3Button;
    private JButton discardButton;
    private JLabel oppile1;
    private JLabel oppile3;
    private JLabel oppile2;
    private JLabel oppile1info;
    private JLabel oppile2info;
    private JLabel oppile3info;
    private JLabel pile1info;
    private JLabel pile2info;
    private JLabel pile3info;
    private JLabel playerlabel;
    private JPanel mainpanel;
    private JLabel opplayerlabel;

    public CaravanGUI() {
        card1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clickedcard = PlayerObj.Hand.get(0);
            }
        });
        card2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clickedcard = PlayerObj.Hand.get(1);
            }
        });
        card3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clickedcard = PlayerObj.Hand.get(2);
            }
        });
        card4Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clickedcard = PlayerObj.Hand.get(3);
            }
        });
        card5Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clickedcard = PlayerObj.Hand.get(4);
            }
        });
        card6Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clickedcard = PlayerObj.Hand.get(5);
            }
        });
        card7Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clickedcard = PlayerObj.Hand.get(6);
            }
        });
        card8Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clickedcard = PlayerObj.Hand.get(7);
            }
        });
        pile1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PlayerObj.PlayCard(clickedcard,1);
                clickedcard = null;
                SwapPlayer();
            }
        });
        pile2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PlayerObj.PlayCard(clickedcard,2);
                clickedcard = null;
                SwapPlayer();
            }
        });
        pile3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PlayerObj.PlayCard(clickedcard,3);
                clickedcard = null;
                SwapPlayer();
            }
        });
        discardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            System.out.println(PlayerObj.Hand);
            if(PlayerObj.DrawACard(clickedcard)){
                System.out.println(PlayerObj.Hand);
                clickedcard = null;
                SwapPlayer();
            }
            //if the discard doesn't work then stop the game and award the player with the most and highest sold carvans the win.


            }
        });
    } /**
     *Main function preserved for quick debugging, not to be called in normal use of this class.
     */
    public static void main(String[] args) {
        System.out.print("this fired");
        JFrame frame = new JFrame("Caravan");
        frame.setContentPane(new CaravanGUI().mainpanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public void StartGUI() {
        frame = new JFrame("Caravan");
        frame.setContentPane(new CaravanGUI().mainpanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        PlayerObj = Player1; //not a good fix but workable for right now
        SetHand();
    }


    /**
     	 * used to paint and repaint the current condition of the hand onto the GUI
     	 */
    public void SetHand() {
        card1Button.setText(PlayerObj.Hand.get(0).toString());
        card2Button.setText(PlayerObj.Hand.get(1).toString());
        card3Button.setText(PlayerObj.Hand.get(2).toString());
        card4Button.setText(PlayerObj.Hand.get(3).toString());
        card5Button.setText(PlayerObj.Hand.get(4).toString());
        card6Button.setText(PlayerObj.Hand.get(5).toString());
        card7Button.setText(PlayerObj.Hand.get(6).toString());
        card8Button.setText(PlayerObj.Hand.get(7).toString());
        SwingUtilities.updateComponentTreeUI(card1Button);
    }

    //	/**
//	 * set up the inital Caravan Gui
//	 */
    public void SetGameUp() {
        PlayerObj.SetGameUp();
        SetHand();
        SetCaravan();

    }

    /**TODO: this is bugged.
     * does the simple swapping of the player
     * @return true if player changed false if not
     */
    public boolean SwapPlayer(){
        if (CurrentPlayer == 1){
            ChangePlayer(Player2);
            CurrentPlayer = 2;
            playerlabel.setText("Player: "+ CurrentPlayer + "'s Caravans." );
            opplayerlabel.setText("Player: 1" + "'s Caravans." );
            return true;
        }
        if(CurrentPlayer == 2){
            ChangePlayer(Player1);
            CurrentPlayer = 1;
            playerlabel.setText("Player: "+ CurrentPlayer + "'s Caravans." );
            opplayerlabel.setText("Player: 2" + "'s Caravans." );
            return true;
        }
        return false;
    }

    /**
     * this function does the swapping of players
     * @param NewPlayer
     */
    public void ChangePlayer(Player NewPlayer) {
        PlayerObj = NewPlayer;
        SetHand();
        SetCaravan();

    }




    /**
      * set up the GUI for the Caravans
     */

	public void SetCaravan() {
        pile1Button.setText(PlayerObj.PlayerCaravan1.toString());
        pile2Button.setText(PlayerObj.PlayerCaravan2.toString());
        pile3Button.setText(PlayerObj.PlayerCaravan3.toString());

        pile1info.setText("Total Caravan Value: " + PlayerObj.PlayerCaravan1.GetTotalValueStr() + " " +
                "Caravan Direction: " + PlayerObj.PlayerCaravan1.GetDirection());
        pile2info.setText("Total Caravan Value: " + PlayerObj.PlayerCaravan2.GetTotalValueStr()  + " " +
                "Caravan Direction: " + PlayerObj.PlayerCaravan2.GetDirection());
        pile3info.setText("Total Caravan Value: " + PlayerObj.PlayerCaravan3.GetTotalValueStr()  + " " +
                "Caravan Direction: " + PlayerObj.PlayerCaravan3.GetDirection());
	}

}





//
//
//old version package CaravanGui;
//


//	/**
//	 * TODO: Create ToString methods for Cards And Caravans Remove a card and put a
//	 * new one in the same place
//	 *
//	 * reduce amount done on this gui make gui better for two players
//	 *
//	 * add images
//	 * make it so that a player can see the caravans of the opponent.
//	 *
//	 * add proper rule https://fallout.fandom.com/wiki/Caravan_(game)
//	 */
//
//	 * Create the application.
//	 */
//	public CaravanGUI() {
//
//		initialize();
//		SetGameUp();
//		this.frame.setTitle("Caravan");
//
//	}
//
//	public CaravanGUI(String Name) {
//
//		initialize();
//		SetGameUp();
//		this.frame.setTitle(Name);
//
//	}
/**+
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

*/
//