import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Chuck
{
    public static final int NUM_DICE = 4;
    public GVdie[] dice;
    public int credits;
    private String message ;
    private boolean isDoubles, isTriplets;
    int Num, bet;

    public static final int ONES = 1;
    public static final int TWOS = 2;
    public static final int THREES = 3;
    public static final int FOURS = 4;
    public static final int FIVES = 5;
    public static final int SIXES = 6;
    public static final int SMALL = 7;
    public static final int FIELD = 8;
    public static final int LARGE = 9;

    public Chuck() {

        isDoubles = true;
        isTriplets = true;
        credits = 0;

        dice = new GVdie[NUM_DICE];
        for(int i = 1; i < NUM_DICE; i++){
            dice[i] = new GVdie();
            dice[i].setDelay(25);
            dice[i].setBlank();
            dice[i].roll();
        }

        message = "Chuck-A-Luck!";

    }

    public int getCredits(){

        credits = 10;

        return credits;

    }

    public void addCredits(int amount) {

        amount = 10;

        if (credits < 1){

            credits = credits + amount;

            JOptionPane.showMessageDialog(null, "You added 10 credits");

        }else {

            JOptionPane.showMessageDialog(null, "You still have credits");
        }
    }

    public GVdie getDie( int num){

        if ( num >= 0 && num < dice.length)

            return dice[num];

        else

            return null;

    }

    public String getMessage(){

        return message;

    }

    public void placeBet(int bet) 
    {
        
    }

    public boolean enoughCredits() {
        if (credits >= bet)
            return true;
        else
            return false;

    }

    private boolean isDoubles () {
        if(dice[1] == dice[2] || dice[1] == dice[3] || dice[2] == dice[3]) {
            credits = credits + 3;
            return true;
        } else {
            credits--;
            return false;
        }
    }

    private boolean isTriplets () {
        if(dice[1] == dice[2] && dice[2] == dice[3]) {
            credits = credits + 3;
            return true;
        } else if(dice[2] == dice[1] && dice[2] == dice[3]) {
            credits = credits + 3;
            return true;
        } else if(dice[3] == dice[1] && dice[3] == dice[2]) {
            credits = credits + 3;
            return true;
        } else {
            credits--;
            return false;
        }
    }

    private void checkSmall (int num) {
        if(num < 11 && isTriplets() == false ) {
            credits = credits + 2;
            return ;
        }
        else {
            credits--;
            return ;
        }
    }

    private void checkField (int num) {
        if(num < 8 || num > 12 ) {
            credits = credits + 2;
            return ;
        } else {
            credits--;
            return ;
        }
    }

    private void checkLarge(int num){
        if(num > 10 && isTriplets == false ){
            credits = credits + 2;
            return;
        }
        else{
            credits--;
            return;
        }
    }

//     private void checkNumber(int num){
//         if( dice[1] == num || dice[2] == num || dice[3] == num){
//             credits = credits + 2;
//             return;
//         }
//         else if (dice[1] && dice[2] == num || dice[2] && dice[3] == num || dice[1] && dice[3] == num){
//             credits = credits + 3;
//             return;
//         }
//         else if (dice[1] && dice[2] && dice[3] == num ){
//             credits = credits + 11;
//             return;
//         }
//         else{
//             credits--;
//         }
//     }
    
    private void checkAllBets(){
        
    }

    public void roll(){

    }

}

