/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  Die.java
 *  Purpose       :  Provides a class describing a single die that can be rolled
 *  @author       :  Alejandra Vasquez
 *  Date          :  2017-02-06
 *  Description   :  This class provides the data fields and methods to describe a single game die.  A
 *                   die can have "N" sides.  Sides are randomly assigned sequential pip values, from 1
 *                   to N, with no repeating numbers.  A "normal" die would thus has six sides, with the
 *                   pip values [spots] ranging in value from one to six.  Includes the following:
 *                   public Die( int nSides );                  // Constructor for a single die with "N" sides
 *                   public int roll();                         // Roll the die and return the result
 *                   public int getValue()                      // get the value of this die
 *                   public void setSides()                     // change the configuration and return the new number of sides
 *                   public String toString()                   // Instance method that returns a String representation
 *                   public static String toString()            // Class-wide method that returns a String representation
 *                   public static void main( String args[] );  // main for testing porpoises
 *
 *  Notes         :  Restrictions: no such thing as a "two-sided die" which would be a coin, actually.
 *                   Also, no such thing as a "three-sided die" which is a physical impossibility without
 *                   having it be a hollow triangular prism shape, presenting an argument as to whether
 *                   the inner faces are faces which then should be numbered.  Just start at four for
 *                   minimum number of faces.  However, be aware that a four-sided die dosn't have a top
 *                   face to provide a value, since it's a tetrahedron [pyramid] so you'll have to figure
 *                   out a way to get the value, since it won't end up on its point.
 *
 *  Warnings      :  None
 *  Exceptions    :  IllegalArgumentException when the number of sides or pips is out of range
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision Histor
 *  ---------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-02-06  B.J. Johnson  Initial writing and release
 *  @version 1.1.0  2017-02-17  B.J. Johnson  Filled in method code
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Notes:
 *  ---------------
 *  Missing static String toString() function
 * Missing static void main(String[] args); to test program
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
import java.util.*;
public class Die {
  /**
   * private instance data
   */
   public int sides;
   private int pips;
//   private int rollValue;
   private final int MINIMUM_SIDES = 4;

   // public constructor:
  /****************************
   * constructor
   * @param nSides int value containing the number of sides to build on THIS Die
   * @throws       IllegalArgumentException
   * Note: parameter must be checked for validity; invalid value must throw "IllegalArgumentException"
   */
   public Die( int sides ) {
     // checks fi MINIMUM_SIDES variable is defined inside this function
     int nSides = 0;
     while (sides < MINIMUM_SIDES) {
       Scanner sc = new Scanner(System.in);
       System.out.println("Your number of sides is too small! Please enter another value.");
       System.out.println("Insert value here: ");
       sides = sc.nextInt();
     // nsides is what is returned to whatever called Die(sides);
     // input.next TYPENAME()
   }
//   return nSides;
   }

  /*
   * Roll THIS die and return the result
   * @return  integer value of the result of the roll, randomly selected
   */
   // public void roll() {  THIS IS WRONG -- IT IS SPECIFIED TO RETURN AN int NOT A void
   public int roll() {
     // sets the number rolled BUT DOES NOT SAVE [that will be done with getValue()]
     pips = (int) (Math.ceil(Math.random()*(sides)));
     return pips;
   }


  /**
   * Get the value of THIS die to return to the caller; note that the way
   *  the count is determined is left as a design decision to the programmer
   *  For example, what about a four-sided die - which face is considered its
   *  "value"?
   * @return the pip count of THIS die instance
   */
   public int getValue() {
     // current state
     int rollValue = pips;
     return rollValue;
     //return rollValue;
   }

  /**
   * @param  int  the number of sides to set/reset for this Die instance
   * @return      The new number of sides, in case anyone is looking
   * @throws      IllegalArgumentException
   */
   public void setSides( int newsides ) {
     sides =  newsides;
     if (sides < MINIMUM_SIDES) {
       Scanner sc = new Scanner(System.in);
       System.out.println("Your number of sides is too small! Please enter another value.");
       System.out.println("Insert value here: ");
       sides = sc.nextInt();
     // input.next TYPENAME()
   }
     System.out.println("You dice now has " + sides + " sides.");
    // return sides;
   }

  public int findSides() {
    return sides;
  }

  public int findSides1() {
    return sides;
  }

  /**
   * Public Instance method that returns a String representation of THIS die instance
   * @return String representation of this Die
   */
   public String toString() {
     String result = Integer.toString(getValue());
      String newresult = "+" + result + "+";
      // returns String type representation of the die
      // instance method
      return result;
   }

  /**
   * Class-wide method that returns a String representation of THIS die instance
   * @return String representation of this Die
   */
   public static String toString( Die d ) {
     //  classwide method ; current value of the die after it has been rolled
      return d.toString();
   }

  /**
   * A little test main to check things out
   */
   public static void main( String[] args ) {
     // checks if methods in Die work
      System.out.println( "Hello world from the Die class..." );
      Die die1 = new Die(5);
      Die die2 = new Die(6);
      Die die3 = new Die(7);
      Die die4 = new Die(8);

      die1.setSides(7);
      die1.setSides(10);
      die2.setSides(5);
      die3.setSides(7);
      die4.setSides(7);

      die1.roll();
      die2.roll();
      die3.roll();
      die4.roll();

      System.out.println(Integer.toString(die1.getValue()));
      System.out.println(Integer.toString(die2.getValue()));
      System.out.println(Integer.toString(die3.getValue()));
      System.out.println(Integer.toString(die4.getValue()));
   }
}
