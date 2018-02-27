/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  HighRoll.java
 *  Purpose       :  Game to play
 *  Author        :  Alejandra Vasquez
 *  Date          :  2017-02-13
 *  Description   :  This class provides everything needed (pretty much) to describe a set of dice.  The
 *                   idea here is to have an implementing class that uses the Die.java class.  Includes
 *                   the following:
 *                   public DiceSet( int k, int n );                  // Constructor for a set of k dice each with n-sides
 *                   public int sum();                                // Returns the present sum of this set of dice
 *  Notes         :  Stolen from Dr. Dorin pretty much verbatim, then modified to show some interesting
 *                   things about Java, and to add this header block and some JavaDoc comments.
 *  Warnings      :  None
 *  Exceptions    :  IllegalArgumentException when the number of sides or pips is out of range
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*/
import java.util.*;
public class HighRoll {
  /**
   * private instance data
   */
   private int count;
   private int nsides;
   private int sum = 0;
   private int highscore = 0;
   private Die[] ds = null;
   private Die[] dset1 = null;
   private String play = "  ";
// set up the menu

public String playGame() {
  System.out.println("Welcome to the High Roll game!");
  Scanner sc = new Scanner(System.in);
  while (play != "Q") {
    System.out.println("Main Menu");
    System.out.println("ROLL ALL THE DICE >> Press R");
    System.out.println("ROLL A SINGLE DIE >> Press F");
    System.out.println("CALCULATE THE SCORE FOR THIS SET >> Press C");
    System.out.println("SAVE THIS SCORE AS HIGH SCORE >> Press S");
    System.out.println("DISPLAY THE HIGH SCORE >> Press D");
    System.out.println("PRESS Q TO QUIT THE PROGRAM");
    System.out.println("Press one of the corresponding keys: ");
    play = sc.nextLine();
    if (play.toUpperCase() == "R"){
      System.out.println("How many dice do you want to play with? ");
      count = sc.nextInt();
      System.out.println("How many sides should the dice have? ");
      nsides = sc.nextInt();
      DiceSet dset1 = new DiceSet(count, nsides);
      dset1.roll();
      String values = dset1.dsetStr;

    } else if (play.toUpperCase() == "F"){
      System.out.println("How many dice do you want in your set? ");
      count = sc.nextInt();
      System.out.println("How many sides should the dice have? ");
      nsides = sc.nextInt();
      DiceSet dset1 = new DiceSet(count, nsides);
      dset1.roll();
      System.out.println("Which dice do you want to roll?");
      int DieIndex = sc.nextInt();
      String value = dset1.toString(DieIndex);
      System.out.println("You rolled a " + value + " ! ");

    } else if (play.toUpperCase() == "C") {
      if ( (count == 0) || (nsides == 0) ) {
        System.out.println("Please set up a dice set before trying this :) ");
      } else {
        // sum = dset1.sum.sum();   IS THIS RIGHT?  THERE IS A SUM.SUM()?
        sum = dset1.sum();
        System.out.println("Your score is " + Integer.toString(sum));
      }

    } else if (play.toUpperCase() == "S") {
      highscore = sum;

    } else if (play.toUpperCase() == "D"){
      System.out.println("Your high score is " + Integer.toString(highscore) );

    } else {
      play = play.toUpperCase();
      System.out.println("Invalid input. Try again. ");
    }

  }
}

}
