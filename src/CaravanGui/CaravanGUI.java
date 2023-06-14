package CaravanGui;

import javax.imageio.ImageIO;
import javax.swing.*;
import Caravan.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;


public class CaravanGUI {


    private Card clickedcard = null;
    private boolean TwoPlayers; //shouldnt occur here so its basiclly depreciated

    public static Player Player1;
    public static Player Player2;

    public static Player PlayerObj;
    public static Player OpPLayerObj;

    private JFrame frame;
    private JPanel toppanel;
    private JPanel bottompanel;
    private JPanel middlepanel;
    private JButton dumppile1button;
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
                if (PlayerObj.PlayCard(clickedcard, 1)) {
                    SwapPlayer();
                }
                clickedcard = null;
            }
        });
        pile2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (PlayerObj.PlayCard(clickedcard, 2)) {
                    SwapPlayer();
                }
                clickedcard = null;
            }
        });
        pile3Button.addActionListener(e -> {
            if (PlayerObj.PlayCard(clickedcard, 3)) {
                SwapPlayer();
            }
            clickedcard = null;
        });
        discardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(PlayerObj.Hand);
                if (PlayerObj.DrawACard(clickedcard)) {
                    System.out.println(PlayerObj.Hand);
                    clickedcard = null;
                    SwapPlayer();


                }

                //if the discard doesn't work then stop the game and award the player with the most and highest sold carvans the win.


            }
        });
        dumppile1button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(PlayerObj.DumpCaravan(1)){
                    SwapPlayer();
                }
                clickedcard = null;
            }
        });
        dumppile2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(PlayerObj.DumpCaravan(2)){
                    SwapPlayer();
                }
                clickedcard = null;
            }
        });
        dumppile3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(PlayerObj.DumpCaravan(3)){
                    SwapPlayer();
                }
                clickedcard = null;
            }
        });
    }

    /**
     * Main function preserved for quick debugging, not to be called in normal use of this class.
     */
    public static void main(String[] args) {
        System.out.print("this fired");
        JFrame frame = new JFrame("Caravan");
        frame.setContentPane(new CaravanGUI().mainpanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * TODO: add something for when a someone sells all their caravans.
     */
    public void StartGUI() {
        frame = new JFrame("Caravan");
        frame.setContentPane(new CaravanGUI().mainpanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(1200,900);

        frame.setVisible(true);




        PlayerObj = Player1;
        OpPLayerObj = Player2;
        SetCaravanIMG();
        SetHandIMG();

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

    }
    public void SetHandIMG() {
        String card1imgstring = GetImageName(PlayerObj.Hand.get(0));
        String card2imgstring = GetImageName(PlayerObj.Hand.get(1));
        String card3imgstring = GetImageName(PlayerObj.Hand.get(2));
        String card4imgstring = GetImageName(PlayerObj.Hand.get(3));
        String card5imgstring = GetImageName(PlayerObj.Hand.get(4));
        String card6imgstring = GetImageName(PlayerObj.Hand.get(5));
        String card7imgstring = GetImageName(PlayerObj.Hand.get(6));
        String card8imgstring = GetImageName(PlayerObj.Hand.get(7));


        try {
            Image card1img = ImageIO.read(new FileInputStream(card1imgstring));
            Image card2img = ImageIO.read(new FileInputStream(card2imgstring));
            Image card3img = ImageIO.read(new FileInputStream(card3imgstring));
            Image card4img = ImageIO.read(new FileInputStream(card4imgstring));
            Image card5img = ImageIO.read(new FileInputStream(card5imgstring));
            Image card6img = ImageIO.read(new FileInputStream(card6imgstring));
            Image card7img = ImageIO.read(new FileInputStream(card7imgstring));
            Image card8img = ImageIO.read(new FileInputStream(card8imgstring));



            card1Button.setIcon(new ImageIcon(card1img));
            card2Button.setIcon(new ImageIcon(card2img));
            card3Button.setIcon(new ImageIcon(card3img));
            card4Button.setIcon(new ImageIcon(card4img));
            card5Button.setIcon(new ImageIcon(card5img));
            card6Button.setIcon(new ImageIcon(card6img));
            card7Button.setIcon(new ImageIcon(card7img));
            card8Button.setIcon(new ImageIcon(card8img));
        }
        catch (Exception E){
            System.out.println(E);
        }
    }



    /**
     *does the simple swapping of the player
     *
     * @return true if player changed false if not
     */
    public boolean SwapPlayer() {
        System.out.println(Player2.isAI);

       if(OpPLayerObj.isAI == true){ //if its just one player and AI just skip all the other stuff.
            OpPLayerObj.PlayAI();
            playerlabel.setText("Your Caravans.");
            opplayerlabel.setText("AI's Caravans.");
            SetHandIMG();
           SetCaravanIMG();
           SetOPCaravan();
            return true;
       }

        if (Player1.isCurrent) {
            ChangePlayer(Player2);
            ChangePlayer(Player2);
            Player2.isCurrent = true;
            Player1.isCurrent = false;
            playerlabel.setText("Player: 2's Caravans.");
            opplayerlabel.setText("Player: 1's Caravans.");
            return true;

        }
        if (Player2.isCurrent) {
            ChangePlayer(Player1);
            Player1.isCurrent = true;
            Player2.isCurrent = false;
            playerlabel.setText("Player: 1's Caravans.");
            opplayerlabel.setText("Player: 2's Caravans.");
            return true;
        }
        return false;
    }

    /**
     * this function does the swapping of players
     *
     * @param NewPlayer
     */
    public void ChangePlayer(Player NewPlayer) {
        OpPLayerObj = PlayerObj;
        PlayerObj = NewPlayer;
        SetHandIMG();
        SetCaravanIMG();
        SetOPCaravan();

    }


    /**
     * Used to set up and reset the visuals of the GUI
     */
    public void SetCaravan() { //this is still not applying neither is the hand thing on first run.
        pile1Button.setText(PlayerObj.PlayerCaravan1.toString());
        pile2Button.setText(PlayerObj.PlayerCaravan2.toString());
        pile3Button.setText(PlayerObj.PlayerCaravan3.toString());

        if (PlayerObj.PlayerCaravan1.CheckSold()) {
            pile1info.setText("SOLD " + "Total Caravan Value: " + PlayerObj.PlayerCaravan1.GetTotalValueStr() + " " +
                    "Caravan Direction: " + PlayerObj.PlayerCaravan1.GetDirection());
        } else {
            pile1info.setText("Total Caravan Value: " + PlayerObj.PlayerCaravan1.GetTotalValueStr() + " " +
                    "Caravan Direction: " + PlayerObj.PlayerCaravan1.GetDirection());
        }
        if (PlayerObj.PlayerCaravan2.CheckSold()) {
            pile2info.setText("SOLD " + "Total Caravan Value: " + PlayerObj.PlayerCaravan2.GetTotalValueStr() + " " +
                    "Caravan Direction: " + PlayerObj.PlayerCaravan2.GetDirection());
        } else {
            pile2info.setText("Total Caravan Value: " + PlayerObj.PlayerCaravan2.GetTotalValueStr() + " " +
                    "Caravan Direction: " + PlayerObj.PlayerCaravan2.GetDirection());
        }
        if (PlayerObj.PlayerCaravan3.CheckSold()) {
            pile3info.setText("SOLD " + "Total Caravan Value: " + PlayerObj.PlayerCaravan3.GetTotalValueStr() + " " +
                    "Caravan Direction: " + PlayerObj.PlayerCaravan3.GetDirection());
            ;
        } else {
            pile3info.setText("Total Caravan Value: " + PlayerObj.PlayerCaravan3.GetTotalValueStr() + " " +
                    "Caravan Direction: " + PlayerObj.PlayerCaravan3.GetDirection());
        }

    }

    public void SetCaravanIMG() { //this is still not applying neither is the hand thing on first run.
        String pile1imgstring = GetImageName(PlayerObj.PlayerCaravan1.getLastCardPlayed());
        String pile2imgstring = GetImageName(PlayerObj.PlayerCaravan2.getLastCardPlayed());
        String pile3imgstring = GetImageName(PlayerObj.PlayerCaravan3.getLastCardPlayed());
        System.out.println(pile1imgstring);

        try {
            Image pile1img = ImageIO.read(new FileInputStream(pile1imgstring)); //need generic img for no card played, need to resize the images themselves and the gui to make it look nice
            Image pile2img = ImageIO.read(new FileInputStream(pile2imgstring));
            Image pile3img = ImageIO.read(new FileInputStream(pile3imgstring));


           pile1Button.setIcon(new ImageIcon(pile1img));
           pile2Button.setIcon(new ImageIcon(pile2img));
           pile3Button.setIcon(new ImageIcon(pile3img));

        } catch (Exception E){
            System.out.println(E);
        }


        if (PlayerObj.PlayerCaravan1.CheckSold()) {
            pile1info.setText("SOLD " + "Total Caravan Value: " + PlayerObj.PlayerCaravan1.GetTotalValueStr() + " " +
                    "Caravan Direction: " + PlayerObj.PlayerCaravan1.GetDirection());
        } else {
            pile1info.setText("Total Caravan Value: " + PlayerObj.PlayerCaravan1.GetTotalValueStr() + " " +
                    "Caravan Direction: " + PlayerObj.PlayerCaravan1.GetDirection());
        }
        if (PlayerObj.PlayerCaravan2.CheckSold()) {
            pile2info.setText("SOLD " + "Total Caravan Value: " + PlayerObj.PlayerCaravan2.GetTotalValueStr() + " " +
                    "Caravan Direction: " + PlayerObj.PlayerCaravan2.GetDirection());
        } else {
            pile2info.setText("Total Caravan Value: " + PlayerObj.PlayerCaravan2.GetTotalValueStr() + " " +
                    "Caravan Direction: " + PlayerObj.PlayerCaravan2.GetDirection());
        }
        if (PlayerObj.PlayerCaravan3.CheckSold()) {
            pile3info.setText("SOLD " + "Total Caravan Value: " + PlayerObj.PlayerCaravan3.GetTotalValueStr() + " " +
                    "Caravan Direction: " + PlayerObj.PlayerCaravan3.GetDirection());
            ;
        } else {
            pile3info.setText("Total Caravan Value: " + PlayerObj.PlayerCaravan3.GetTotalValueStr() + " " +
                    "Caravan Direction: " + PlayerObj.PlayerCaravan3.GetDirection());
        }

    }


    public void SetOPCaravan() {
        oppile1.setText(OpPLayerObj.PlayerCaravan1.toString());
        oppile2.setText(OpPLayerObj.PlayerCaravan2.toString());
        oppile3.setText(OpPLayerObj.PlayerCaravan3.toString());

        if (OpPLayerObj.PlayerCaravan1.CheckSold()) {
            oppile1info.setText("SOLD " + "Total Caravan Value: " + OpPLayerObj.PlayerCaravan1.GetTotalValueStr() + " " +
                    "Caravan Direction: " + OpPLayerObj.PlayerCaravan1.GetDirection());
        } else {
            oppile1info.setText("Total Caravan Value: " + OpPLayerObj.PlayerCaravan1.GetTotalValueStr() + " " +
                    "Caravan Direction: " + OpPLayerObj.PlayerCaravan1.GetDirection());
        }
        if (PlayerObj.PlayerCaravan2.CheckSold()) {
            oppile2info.setText("SOLD " + "Total Caravan Value: " + OpPLayerObj.PlayerCaravan2.GetTotalValueStr() + " " +
                    "Caravan Direction: " + OpPLayerObj.PlayerCaravan2.GetDirection());
        } else {
            oppile2info.setText("Total Caravan Value: " + OpPLayerObj.PlayerCaravan2.GetTotalValueStr() + " " +
                    "Caravan Direction: " + OpPLayerObj.PlayerCaravan2.GetDirection());
        }
        if (OpPLayerObj.PlayerCaravan3.CheckSold()) {
            oppile3info.setText("SOLD " + "Total Caravan Value: " + OpPLayerObj.PlayerCaravan3.GetTotalValueStr() + " " +
                    "Caravan Direction: " + OpPLayerObj.PlayerCaravan3.GetDirection());
            ;
        } else {
            oppile3info.setText("Total Caravan Value: " + OpPLayerObj.PlayerCaravan3.GetTotalValueStr() + " " +
                    "Caravan Direction: " + OpPLayerObj.PlayerCaravan3.GetDirection());
        }


    }



    public String GetImageName(Card card){
        if(!(card == null)) {
            String suit = card.getSuit();
            String type = String.valueOf(card.getCardType());
            return ("resource/" + type + "_of_" + suit + ".png");
        }
        return ("resource/red_joker.png");
    }

}

/**
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
*/