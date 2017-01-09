//This was hosted on the website

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class GUI extends JPanel
{

    /** visual representation of the dice */
    GVdie d1, d2, d3;

    /** buttons and labels */
    JButton overButton, underButton, sevenButton, rollButton;
    JCheckBox overCheck, underCheck, onesCheck, fieldCheck;
    JCheckBox twosCheck, threesCheck, foursCheck, fivesCheck, sixesCheck;
    JLabel message, credits;
    JFrame myGUI;
    JPanel dicePanel;
    Chuck game;

    /** menu items */
    JMenuBar menus;
    JMenu fileMenu;
    JMenuItem quitItem;
    JMenuItem restartItem; 
    JMenuItem addItem;

    public static void main(String args[]){
        // the traditional five lines of code from the book are
        // provided in the GUI constructor
        new GUI();
    }

    /****************************************************************
    Create all elements and display within the GUI
     ****************************************************************/    
    public GUI(){ 

        // create the game object as well as the GUI Frame   
        game = new Chuck(); 
        myGUI = new JFrame("A Game of Chuck A Luck");
        myGUI.setSize(600,400);

        // place the die in the middle of the screen
        dicePanel = new JPanel();
        d1 = game.getDie(1);
        dicePanel.add(d1);
        d2 = game.getDie(2);
        dicePanel.add(d2);
        d3 = game.getDie(3);
        dicePanel.add(d3);    
        myGUI.add(BorderLayout.CENTER, dicePanel);

        // create the buttons and message field
        message = new JLabel();
        message.setText(game.getMessage());
        JPanel topPanel = new JPanel();
        topPanel.add(message);
        myGUI.add(BorderLayout.NORTH, topPanel);

        JPanel panel = new JPanel();
        rollButton = new JButton("Roll");
        rollButton.setForeground(Color.red); 
        
        credits = new JLabel ();
        credits.setText("Credits: " + game.getCredits());     

        // create the panel for all bets
        JPanel betsPanel = new JPanel();
        betsPanel.setLayout(new BoxLayout(betsPanel, BoxLayout.Y_AXIS));
        overCheck = new JCheckBox("Over 10");
        underCheck = new JCheckBox("Under 11");
        fieldCheck = new JCheckBox("< 8 or > 12");
        onesCheck = new JCheckBox("1s");
        twosCheck = new JCheckBox("2s");
        threesCheck = new JCheckBox("3s");
        foursCheck = new JCheckBox("4s");
        fivesCheck = new JCheckBox("5s");
        sixesCheck = new JCheckBox("6s");    
        betsPanel.add(new JLabel("Your Bets"));
        betsPanel.add(overCheck);
        betsPanel.add(underCheck);
        betsPanel.add(fieldCheck);
        betsPanel.add(onesCheck);
        betsPanel.add(twosCheck);
        betsPanel.add(threesCheck);
        betsPanel.add(foursCheck);    
        betsPanel.add(fivesCheck);
        betsPanel.add(sixesCheck);
        myGUI.add(BorderLayout.WEST, betsPanel);

        // position the GUI items on the screen
        panel.add(credits);
        panel.add(rollButton);
        myGUI.add(BorderLayout.SOUTH, panel);

        // register the button listener 
        ButtonListener listener = new ButtonListener();
        rollButton.addActionListener (listener);

        // set up File menu
        fileMenu = new JMenu("File");
        quitItem = new JMenuItem("Quit");
        restartItem = new JMenuItem("Restart");
        addItem = new JMenuItem("Add 10 Credits");
        quitItem.addActionListener(listener);
        restartItem.addActionListener(listener);
        addItem.addActionListener(listener);
        fileMenu.add(addItem);
        fileMenu.add(restartItem);
        fileMenu.add(quitItem);
        menus = new JMenuBar();
        myGUI.setJMenuBar(menus);
        menus.add(fileMenu); 

        myGUI.pack();
        myGUI.setVisible(true);
    }

    /****************************************************************
     * Start a new game
     ****************************************************************/
    private void restart(){

        // instantiate a new game and retrieve the new dice
        game = new Chuck();

        // clear and add the new dice
        dicePanel.removeAll();
        dicePanel.add(game.getDie(1));
        dicePanel.add(game.getDie(2));    
        dicePanel.add(game.getDie(3));  

        // clear all bets
        overCheck.setSelected(false);
        underCheck.setSelected(false);
        fieldCheck.setSelected(false);
        onesCheck.setSelected(false);
        twosCheck.setSelected(false);
        threesCheck.setSelected(false);
        foursCheck.setSelected(false);
        fivesCheck.setSelected(false);
        sixesCheck.setSelected(false);     
    }

    /****************************************************************
    Inner class to repond to the user action

    @param e - the JComponent just selected
     ****************************************************************/
    public class ButtonListener implements ActionListener{public void actionPerformed(ActionEvent e){

            // what did the user just select?
            JComponent buttonPressed = (JComponent) e.getSource();
//           
//             if ( overCheck.isSelected()){
//                 Chuck.placeBet(Chuck.LARGE);
//             }
//             
//             if ( fieldCheck.isSelected()){
//                 Chuck.placeBet(Chuck.FIELD);
//             }
//             if ( onesCheck.isSelected()){
//                 Chuck.placeBet(Chuck.ONES);
//             }
//             if ( twosCheck.isSelected()){
//                 Chuck.placeBet(Chuck.TWOS);
//             }
//             if ( threesCheck.isSelected()){
//                 Chuck.placeBet(Chuck.THEES);
//             }
//             if ( foursCheck.isSelected()){
//                 Chuck.placeBet(Chuck.FOURS);
//             }
//             if ( fivesCheck.isSelected()){
//                 Chuck.placeBet(Chuck.FIVES);
//             }
//             if ( sixesCheck.isSelected()){
//                 Chuck.placeBet(Chuck.SIXES);
//             }
     
      //  betsPanel.add(new JLabel("Your Bets"));
            if (buttonPressed == rollButton)
            {
                d1.roll();
                d2.roll();
                d3.roll();
            }

            // plauer selects menu to quit the game
            if (buttonPressed == quitItem)
            {   
                System.exit(1);
            }
            // player selects menu item to start a new game    
            if (buttonPressed == restartItem)
            { 
                restart();
            }
            // player selects menu item to add more credits    
            if (buttonPressed == addItem)
            {  
                game.addCredits(10); 
            }
        }

    }
}