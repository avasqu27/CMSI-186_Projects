/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  DiceSet.java
 *  Purpose       :  Provides a class describing a set of dice
 *  Author        :  Alejandra Vasquez
 *  Date          :  2017-02-09
 *  Description   :  This class provides everything needed (pretty much) to describe a set of dice.  The
 *                   idea here is to have an implementing class that uses the Die.java class.  Includes
 *                   the following:
 *                   public DiceSet( int k, int n );                  // Constructor for a set of k dice each with n-sides
 *                   public int sum();                                // Returns the present sum of this set of dice
 *                   public void roll();                              // Randomly rolls all of the dice in this set
 *                   public void rollIndividual( int i );             // Randomly rolls only the ith die in this set
 *                   public int getIndividual( int i );               // Gets the value of the ith die in this set
 *                   public String toString();                        // Returns a stringy representation of this set of dice
 *                   public static String toString( DiceSet ds );     // Classwide version of the preceding instance method
 *                   public boolean isIdentical( DiceSet ds );        // Returns true iff this set is identical to the set ds
 *                   public static void main( String[] args );        // The built-in test program for this class
 *
 *  Notes         :  Stolen from Dr. Dorin pretty much verbatim, then modified to show some interesting
 *                   things about Java, and to add this header block and some JavaDoc comments.
 *  Warnings      :  None
 *  Exceptions    :  IllegalArgumentException when the number of sides or pips is out of range
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision Histor
 *  ---------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-02-09  B.J. Johnson  Initial writing and release
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

import java.util.*;
public class DiceSet {

  /**
   * private instance data
   */
   private int count;
   private String dsetStr;
   // dice set sTring
   private int sides;
   private int n;
   private Die[] ds = null;
   private int MINIMUM_SIDES = 4;
   private String rollValue;
   // empty array


   // public constructor:
  /**
   * constructor
   * @param  count int value containing total dice count
   * @param  sides int value containing the number of pips on each die
   * @throws IllegalArgumentException if one or both arguments don't make sense
   * @note   parameters are checked for validity; invalid values throw "IllegalArgumentException"
   */
   public DiceSet( int count, int sides ) {
     Scanner sc = new Scanner(System.in);
     while (count < 1) {
       System.out.println("Too little number of dice. Choose a number above 1. ");
       System.out.println("Insert value here: ");
       count = sc.nextInt();
     }
     while (sides < MINIMUM_SIDES) {
       System.out.println("Your number of sides is too small! Please enter another value.");
       System.out.println("Insert value here: ");
       sides = sc.nextInt();
     }
     System.out.println("There are " + String.valueOf(count) + " dice that have " + String.valueOf(sides) + " sides each.");
   }

   public int findSides() {
     return (ds[0].findSides());
   }

   public int findCount() {
     return count;
   }

  /**
   * @return the sum of all the dice values in the set
   */
   public int sum() {
     int sum1 = 0;
     for (int i = 0; i < count; i++) {
       sum1 = sum1 + (ds[i].getValue());
     }
     //String cs = DiceSet(count,sides);
     System.out.println("The sum of this roll is " + String.valueOf(sum1));
     return sum1;
   }

  /**
   * Randomly rolls all of the dice in this set
   *  NOTE: you will need to use one of the "toString()" methods to obtain
   *  the values of the dice in the set
   */
   public void roll() {
     // we want this to return void b/c it just sets the value
     // we want this to call one of the string functions in Die.java
     // random generator function (between 1 and n);
     String rollValue = toString();
     String dsetStr = "";
     int rolled = 0;
     for (int i = 0; i < count; i++) {
       roll();
       rolled = ds[i].getValue();
       dsetStr = dsetStr + toString();
     }
   }

  /**
   * Randomly rolls a single die of the dice in this set indexed by 'dieIndex'
   * @param  dieIndex int of which die to roll
   * @return the integer value of the newly rolled die
   * @trhows IllegalArgumentException if the index is out of range
   */
   public int rollIndividual( int dieIndex ) {
     // ask user which one to roll
     // rolls dieIndex # chosen one
     // rolled die is by index, so if the user says 1, it is 1 - 1
     // in other words, n -1 ;
     int n = dieIndex;
     if ((dieIndex <= 0) || (dieIndex > count)) {
       return 0;
     }
     roll();
     int rolled = ds[n-1].getValue();
     System.out.println("Dice " + rolled + " was rolled.");
     return rolled;
   }

  /**
   * Gets the value of the die in this set indexed by 'dieIndex'
   * @param  dieIndex int of which die to roll
   * @trhows IllegalArgumentException if the index is out of range
   */
   public int getIndividual( int dieIndex ){
     int rolled = rollIndividual(dieIndex);
     return rolled;
     // gets the value of rolling the dieIndex from rollIndividual(dieIndex)
   }

  /**
   * @return Public Instance method that returns a String representation of the DiceSet instance
   */
   public String toString(int dieIndex) {
     String dsetString1 = String.valueOf(getIndividual(dieIndex));
      // same thing at getIndividual(dieIndex) except returns string representation
      return dsetString1;
   }

  /**
   * @return Class-wide version of the preceding instance method
   */
   public static String toString( DiceSet ds ) {
      return ds.toString();
   }

  /**
   * @return  tru iff this set is identical to the set passed as an argument
   */
   public boolean isIdentical( DiceSet ds1 ) {
     // compares if dice set is identical
     //if (ds[0].findSides() != ds1.findSides1())
     if (ds[0].findSides() != ds1.sides) {
       return false;
     } else if (ds.length != ds1.count) {
     //else if (ds.findCount() != ds1.findCount()){
       return false;
     } else if (sum() != ds1.sum()){
       return false;
     }
     return true;
   }

  /**
   * A little test main to check things out
   */
   public static void main( String[] args ) {
      // You do this part!
      System.out.print( "   Test for 5 dice, 6 sides each: " );
      DiceSet dset1 = new DiceSet( 5,6 );
      try { dset1 = new DiceSet( 5,6 ); }
      catch( Exception e ) { System.out.println ( false ); }
      System.out.print( "   Test for 1 dice, 5 sides each: " );
      DiceSet dset2 = new DiceSet( 1,5 );
      try { dset2 = new DiceSet( 1,5 ); }
      catch( Exception e ) { System.out.println ( false ); }
      System.out.print( "   Test for 4 dice, 0 sides each: " );
      DiceSet dset3 = new DiceSet( 4,5 );
      try { dset3 = new DiceSet( 4,5 ); }
      catch( Exception e ) { System.out.println ( false ); }
      System.out.print( "   Test for 3 dice, 0 sides each: " );
      DiceSet dset4 = new DiceSet( 4,7 );
      try { dset4 = new DiceSet( 4 ,7 ); }
      catch( Exception e ) { System.out.println ( false ); }

      System.out.println( "   Test for rolling: " );
      dset1.roll();
      dset2.roll();
      dset3.roll();
      dset4.roll();

      System.out.println( "Checking for rolled numbers: " );
      int rollednumber1 = dset1.rollIndividual(2);
      try {  rollednumber1 = dset1.rollIndividual(2); }
      catch( Exception e ) { System.out.println ( false ); }
      int rollednumber2 = dset2.rollIndividual(1);
      try {  rollednumber2 = dset2.rollIndividual(1); }
      catch( Exception e ) { System.out.println ( false ); }
      int rollednumber3 = dset3.rollIndividual(4);
      try {  rollednumber3 = dset3.rollIndividual(4); }
      catch( Exception e ) { System.out.println ( false ); }
      int rollednumber4 = dset1.rollIndividual(6);
      try {  rollednumber4 = dset1.rollIndividual(6); }
      catch( Exception e ) { System.out.println ( false ); }
      System.out.println(Integer.toString(rollednumber1) + Integer.toString(rollednumber2) + Integer.toString(rollednumber3)+ Integer.toString(rollednumber4));

      System.out.println("Checking for string representation of rolled numbers: ");
      String stringnum1 = dset1.toString(2);
      try {  stringnum1 = dset1.toString(2); }
      catch( Exception e ) { System.out.println ( false ); }
      String stringnum2 = dset2.toString(0);
      try {  stringnum2 = dset2.toString(0); }
      catch( Exception e ) { System.out.println ( false ); }
      String stringnum3 = dset3.toString(4);
      try {  stringnum3 = dset3.toString(4); }
      catch( Exception e ) { System.out.println ( false ); }
      String stringnum4 = dset1.toString(6);
      try {  stringnum4 = dset1.toString(6); }
      catch( Exception e ) { System.out.println ( false ); }
      System.out.println((rollednumber1) + (rollednumber2) + (rollednumber3)+ (rollednumber4));


      System.out.println("Checking for sum of rolled numbers: ");
      int sum1 = 0;
      try {  sum1 = dset1.sum(); }
      catch( Exception e ) { System.out.println ( false ); }
      int sum2 = 0;
      try {  sum2 = dset2.sum(); }
      catch( Exception e ) { System.out.println ( false ); }
      int sum3 = 0;
      try {  sum3 = dset3.sum(); }
      catch( Exception e ) { System.out.println ( false ); }
      int sum4 = 0;
      try {  sum4 = dset4.sum(); }
      catch( Exception e ) { System.out.println ( false ); }
   }

}
