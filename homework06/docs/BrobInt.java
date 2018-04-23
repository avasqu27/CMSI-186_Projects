/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * File name  :  BrobInt.java
 * Purpose    :  Learning exercise to implement arbitrarily large numbers and their operations
 * @author    :  B.J. Johnson
 * Date       :  2017-04-04
 * Description:  @see <a href='http://bjohnson.lmu.build/cmsi186web/homework06.html'>Assignment Page</a>
 * Notes      :  None
 * Warnings   :  None
 *
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Revision History
 * ================
 *   Ver      Date     Modified by:  Reason for change or modification
 *  -----  ----------  ------------  ---------------------------------------------------------------------
 *  1.0.0  2017-04-04  B.J. Johnson  Initial writing and begin coding
 *  1.1.0  2017-04-13  B.J. Johnson  Completed addByt, addInt, compareTo, equals, toString, Constructor,
 *                                     validateDigits, two reversers, and valueOf methods; revamped equals
 *                                     and compareTo methods to use the Java String methods; ready to
 *                                     start work on subtractByte and subtractInt methods
 *
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
import java.util.Arrays;

public class BrobInt {

   public static final BrobInt ZERO     = new BrobInt(  "0" );      /// Constant for "zero"
   public static final BrobInt ONE      = new BrobInt(  "1" );      /// Constant for "one"
   public static final BrobInt TWO      = new BrobInt(  "2" );      /// Constant for "two"
   public static final BrobInt THREE    = new BrobInt(  "3" );      /// Constant for "three"
   public static final BrobInt FOUR     = new BrobInt(  "4" );      /// Constant for "four"
   public static final BrobInt FIVE     = new BrobInt(  "5" );      /// Constant for "five"
   public static final BrobInt SIX      = new BrobInt(  "6" );      /// Constant for "six"
   public static final BrobInt SEVEN    = new BrobInt(  "7" );      /// Constant for "seven"
   public static final BrobInt EIGHT    = new BrobInt(  "8" );      /// Constant for "eight"
   public static final BrobInt NINE     = new BrobInt(  "9" );      /// Constant for "nine"
   public static final BrobInt TEN      = new BrobInt( "10" );      /// Constant for "ten"


  /// Some constants for other intrinsic data types
  ///these can help speed up the math if they fit into the proper memory space
  //public static final BrobInt MAX_INT  = new BrobInt(  Integer.valueOf( Integer.MAX_VALUE ).toString() );
  //public static final BrobInt MIN_INT  = new BrobInt(  Integer.valueOf( Integer.MIN_VALUE ).toString() );
  //public static final BrobInt MAX_LONG = new BrobInt(  Long.valueOf( Long.MAX_VALUE ).toString() );
  //public static final BrobInt MIN_LONG = new BrobInt(  Long.valueOf( Long.MIN_VALUE ).toString() );

  /// These are the internal fields
   public String internalValue = "";        // internal String representation of this BrobInt
   private byte   sign          = 0;         // "0" is positive, "1" is negative
   private String reversed      = "";        // the backwards version of the internal String representation
   private byte[] byteVersion   = null;      // byte array for storing the string values

  /**
   *  Constructor takes a string and assigns it to the internal storage, checks for a sign character
   *   and handles that accordingly;  it then checks to see if it's all valid digits, and reverses it
   *   for later use
   *  @param  value  String value to make into a BrobInt
   */
   public BrobInt( String value ) {
     // we define the brobint
     internalValue = value;


     if (value.substring(0,1).equals("-") == true ) {
       sign = 1;
       internalValue = value.substring(1);
//       System.out.println(sign  + " and new internalValue: " + internalValue);
     }

    // System.out.println("past if statement");


     String s1 = internalValue;
     String s2 = "";
     int valuelength = internalValue.length() - 1;
     int currentlet = 0;



     for (int i = 0; i <= (valuelength); i++) {
      // System.out.println("Check1: Nothin' wrong");
       currentlet = valuelength - i;
       s2 = s2 + s1.charAt(currentlet);
       // System.out.println("Check2: No wrongin' ");
       // charAt returns character at index i
     }

     //System.out.println("past for statement ");

     int pos1 = s2.length();

     byteVersion = new byte[pos1];

    // System.out.println("Check5: No wrongin'");
     for (int j = 0; j < (s2.length()); j++) {
       byteVersion[j] = (byte) (Integer.parseInt(s2.substring( j, (j+1))));
     }
    // System.out.println(" BUT has the exception been thrown yet?");

   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to validate that all the characters in the value are valid decimal digits
   *  @return  boolean  true if all digits are good
   *  @throws  IllegalArgumentException if something is hinky
   *  note that there is no return false, because of throwing the exception
   *  note also that this must check for the '+' and '-' sign digits
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public boolean validateDigits() {
     // see if the digits are valid; if they have a letter or symbol, take it out
     // should be able to refer to a value in the brob int
     int unknown = 0;
     int lengthh = byteVersion.length;
     char c = 'p';
     for ( int i = 0; i < (byteVersion.length); i++ ) {
       c = (char) byteVersion[i];
       if (Character.isDigit(c) == false) {
         return false;
       }
     }
     return true;
   //throw new UnsupportedOperationException( "\n         Sorry, that operation is not yet implemented." );
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to reverse the value of this BrobInt
   *  @return BrobInt that is the reverse of the value of this BrobInt
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public BrobInt reverser() {
     String s1 = internalValue;
     String s2 = "";
     int valuelength = s1.length() - 1;
     int currentlet = 0;

     for (int i = 0; i <= (valuelength); i++) {
       currentlet = valuelength - i;
       s2 = s2 + s1.charAt(currentlet);
       // charAt returns character at index i
     }
     System.out.println(s2);
     BrobInt result = new BrobInt(s2);

     return result ;
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to reverse the value of a BrobIntk passed as argument
   *  Note: static method
   *  @param  gint         BrobInt to reverse its value
   *  @return BrobInt that is the reverse of the value of the BrobInt passed as argument
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public static BrobInt reverser( BrobInt gint ) {
     String s1 = gint.internalValue;
     String s2 = "";
     int valuelength = s1.length() - 1;
     int currentlet = 0;

     for (int i = 0; i <= (valuelength); i++) {
       currentlet = valuelength - i;
       s2 = s2 + s1.charAt(currentlet);
       // charAt returns character at index i
     }
     System.out.println(s2);
     BrobInt result = new BrobInt(s2);

     return result ;
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to add the value of a BrobIntk passed as argument to this BrobInt using byte array
   * Uses the bytes that are broken up and adds them together
   *  @param  gint         BrobInt to add to this
   *  @return BrobInt that is the sum of the value of this BrobInt and the one passed in
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public BrobInt addByte( BrobInt gint ) {
     //  throw new UnsupportedOperationException( "\n         Sorry, that operation is not yet implemented." );

     int[] resultByte = null;
     BrobInt larger = null;
     BrobInt smaller = null;
     int carry = 0;
     String result = "";

     if (this.compareTo(gint) == -1) {
       resultByte = new int[gint.internalValue.length() + 2];
       larger  = new BrobInt(gint.internalValue);
       smaller = new BrobInt(internalValue);
     } else {
       resultByte = new int[internalValue.length() + 2];
       larger  = new BrobInt(internalValue);
       smaller = new BrobInt(gint.internalValue);
     }

     // Makes the array the length of numbers of the smaller brobint
     // Here's where the addition happens!
     for (int i = 0; i < smaller.byteVersion.length; i++) {
        resultByte[i] = byteVersion[i] + gint.byteVersion[i] + carry;
        carry = 0;
      //  System.out.println( resultByte[i] );
      // Forming and implementing the carry
        if ((resultByte[i] ) > 9) {
          while ((resultByte[i]) > 9){
          carry = carry + 1;
          //System.out.println("I just got a carry");
          resultByte[i] = resultByte[i]-10;
        }
      } else {
          // Regardless of what happened, adds existing carry
          resultByte[i] = resultByte[i] + carry;
        //  System.out.println("Result rn is: " + Integer.toString(resultByte[i]) + "      carry: " + Integer.toString(carry));
        }


        // adds the results to a String
        result = result + Integer.toString(resultByte[i]);

        // If there is still a carry by the time the last digit is added,
        //    create a new place in the resultByte array that holds the carry value.
        if ((larger.byteVersion.length-1 == i) && (carry == 1)){
          resultByte[i+1] = carry + larger.byteVersion[larger.byteVersion.length-1];
        //  System.out.println(resultByte[i+1]);
          result = result + Integer.toString(resultByte[i+1]);
        //  System.out.println( "infiltration" );
      }
   }

     // Adds the remaining digits to the result String
     for (int j = 0; j < (larger.byteVersion.length - smaller.byteVersion.length ); j++) {
        result = result + (larger.byteVersion[j + smaller.byteVersion.length] );
      }

      // Deletes all zeros at the beginning of the result string by creating a substring
      // Remember: the string still hasn't been reversed!
    while ((result.charAt(result.length()-1)) == '0'){
      result = result.substring(0,result.length()-1);
    }

     // Reverses the result string
     String s1 = result;
     String s2 = "";
     int resultBytelength = result.length() - 1;
     int currentlet = 0;


     for (int i = 0; i <= (resultBytelength); i++) {
       currentlet = resultBytelength - i;
       s2 = s2 + s1.charAt(currentlet);
       // charAt returns character at index i
     }

     BrobInt finalResult = new BrobInt(s2);
     if ((gint.sign == 1) & (sign == 1) ){
       finalResult = new BrobInt("-" + s2);
       s2 = "-" + s2;
     }

     // prints out the result that will go into the new BrobInt
     // System.out.println("     My input for the new BrobInt is: " + s2);

     // Clarifies where the sign went; the sign went into the sign variable in BrobInt Constructor
     // Constructor set up the value so that the intervalValue variable ONLY contains numbers,
     // no signs.
  /*
     if (finalResult.sign == 1) {
       System.out.println("     sign holds " + finalResult.sign + " meaning it is a negative number.");
     } else {
       System.out.println("     sign holds " + finalResult.sign + " meaning it is a positive number.");
     }
*/
    return finalResult;
 }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to add the value of a BrobIntk passed as argument to this BrobInt using int array
   *  @param  gint         BrobInt to add to this
   *  @return BrobInt that is the sum of the value of this BrobInt and the one passed in
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public BrobInt addInt( BrobInt gint ) {
     BrobInt result = addByte(gint);
      //throw new UnsupportedOperationException( "\n         Sorry, that operation is not yet implemented." );
      return result;
   }

   /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    *  Method to return add in string format
    *  @param  gint         BrobInt to add to this
    *  @return BrobInt that is the sum of the value of this BrobInt and the one passed in
    *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
    public String add( BrobInt gint ) {
       String result = addByte(gint).internalValue;
       if ((gint.sign == 1) & (sign == 1) ){
         result = "-" + result;
       }
       return result;
    }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to subtract the value of a BrobIntk passed as argument to this BrobInt using bytes
   *  @param  gint         BrobInt to subtract from this
   *  @return BrobInt that is the difference of the value of this BrobInt and the one passed in
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public BrobInt subtractByte( BrobInt gint ) {
   // throw new UnsupportedOperationException( "\n         Sorry, that operation is not yet implemented." );
    // create an array that will hold the difference
    int[] resultByte = null;

      int borrow = 0;
      String result = "";
      BrobInt larger = null;
      BrobInt smaller = null;

      // make the array the length of numbers of the bigger brobint
        if (this.compareTo(gint) == -1) {
          resultByte = new int[gint.internalValue.length() + 1];
          larger  = new BrobInt(gint.internalValue);
          smaller = new BrobInt(internalValue);
        } else {
          resultByte = new int[internalValue.length()];
          larger  = new BrobInt(internalValue);
          smaller = new BrobInt(gint.internalValue);
        }

      // actual subtraction
      for (int i = 0; i < smaller.byteVersion.length; i++) {
        if (borrow == 1) {
          resultByte[i] = larger.byteVersion[i] - borrow - smaller.byteVersion[i];
          borrow = 0;
        }
        if (larger.byteVersion[i] < smaller.byteVersion[i]) {
          borrow = 1;
          resultByte[i] = (larger.byteVersion[i] + 10) - smaller.byteVersion[i];
        } else {
          resultByte[i] = larger.byteVersion[i] - borrow - smaller.byteVersion[i];
        }
        result = result + Integer.toString(resultByte[i]);
      }

      // Adds the remaining digits to the result String
      for (int j = 0; j < (larger.byteVersion.length - smaller.byteVersion.length ); j++) {
        result = result + (larger.byteVersion[j + smaller.byteVersion.length] );
       }

     // String reverser
      String s1 = result;
      String s2 = "";
      int resultBytelength = result.length() - 1;
      int currentlet = 0;

      for (int i = 0; i <= (resultBytelength); i++) {
        currentlet = resultBytelength - i;
        s2 = s2 + s1.charAt(currentlet);
        // charAt returns character at index i
      }

      BrobInt finalResult = new BrobInt(s2);
      if ((this.compareTo(gint) == 1) & (this.sign == 1)){
        finalResult = new BrobInt("-" + s2);
        s2 = "-" + s2;
      } else if ( ((this.compareTo(gint) == -1) & (gint.sign == 0))){
        finalResult = new BrobInt("-" + s2);
        s2 = "-" + s2;
      }

    //  System.out.println("My input for the new BrobInt is: " + s2);

    // BrobInt finalResult = new BrobInt(s2);
     return finalResult ;
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to subtract the value of a BrobIntk passed as argument to this BrobInt using int array
   *  @param  gint         BrobInt to subtract from this
   *  @return BrobInt that is the difference of the value of this BrobInt and the one passed in
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public BrobInt subtractInt( BrobInt gint ) {
//     throw new UnsupportedOperationException( "\n         Sorry, that operation is not yet implemented." );
     BrobInt finalResult = subtractByte(gint);
     return finalResult;
   }

   /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    *  Method to return subtract in string format
    *  @param  gint         BrobInt to add to this
    *  @return BrobInt that is the sum of the value of this BrobInt and the one passed in
    *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
    public String subtract( BrobInt gint ) {
       String result = this.subtractByte(gint).internalValue;
       if ((this.compareTo(gint) == 1) & (this.sign == 1)){
         result = "-" + result;
       } else if ( ((this.compareTo(gint) == -1) & (gint.sign == 0))){
         result = "-" + result;
       }
       return result;
    }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to multiply the value of a BrobIntk passed as argument to this BrobInt
   *  @param  gint         BrobInt to multiply by this
   *  @return BrobInt that is the product of the value of this BrobInt and the one passed in
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public BrobInt multiply( BrobInt gint ) {
      //throw new UnsupportedOperationException( "\n         Sorry, that operation is not yet implemented." );
    int counter = 1;

      BrobInt resulting = new BrobInt(internalValue);
      //BrobInt pastBrob = new BrobInt(internalValue);

      System.out.println(resulting.internalValue);
    //  System.out.println(pastBrob.internalValue);


      while (counter != Integer.valueOf(gint.internalValue)) {
        resulting = addByte(resulting);
      //  System.out.println(resulting.internalValue);
        counter = counter + 1;
      //  System.out.println(resulting.internalValue);
      //  System.out.println("counter: " + counter);
      }

       return resulting;

   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to divide the value of this BrobIntk by the BrobInt passed as argument
   *  @param  gint         BrobInt to divide this by
   *  @return BrobInt that is the dividend of this BrobInt divided by the one passed in
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public BrobInt divide( BrobInt gint ) {
   //   throw new UnsupportedOperationException( "\n         Sorry, that operation is not yet implemented." );
     int counter = 1;


    // System.out.println(resulting.internalValue);

    BrobInt larger  = null;
    BrobInt smaller = null;

    if (this.compareTo(gint) == -1) {
      //resultByte = new int[gint.internalValue.length() + 1];
     larger  = new BrobInt(gint.internalValue);
     smaller = new BrobInt(internalValue);
    } else {
    //  resultByte = new int[internalValue.length()];
     larger  = new BrobInt(internalValue);
     smaller = new BrobInt(gint.internalValue);
    }

    BrobInt resulting = new BrobInt(smaller.internalValue);


    while (counter != Integer.valueOf(larger.internalValue)) {
      resulting = subtractByte(resulting);
    //  System.out.println(resulting.internalValue);
      counter = counter + 1;
    //  System.out.println(resulting.internalValue);
    //  System.out.println("counter: " + counter);
    }

     return resulting;
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to get the remainder of division of this BrobInt by the one passed as argument
   *  @param  gint         BrobInt to divide this one by
   *  @return BrobInt that is the remainder of division of this BrobInt by the one passed in
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public BrobInt remainder( BrobInt gint ) {
     String result = subtract(this.divide(gint).multiply(gint));
     BrobInt resulting = new BrobInt(result);

     return resulting;
     //throw new UnsupportedOperationException( "\n         Sorry, that operation is not yet implemented." );
   }



   /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  *  Method to compare a BrobInt passed as argument to this BrobInt
  *  @param  gint  BrobInt to add to this
  *  @return int   that is one of neg/0/pos if this BrobInt precedes/equals/follows the argument
  *  NOTE: this method does not do a lexicographical comparison using the java String "compareTo()" method
  *        It takes into account the length of the two numbers, and if that isn't enough it does a
  *        character by character comparison to determine
  *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
  public int compareTo( BrobInt gint ) {

    // handle the signs here
     if( 1 == sign && 0 == gint.sign ) {
        return (-1);
     } else if( 0 == sign && 1 == gint.sign ) {
        return 1;
     }

    // the signs are the same at this point
    // check the length and return the appropriate value
    //   1 means this is longer than gint, hence larger
    //  -1 means gint is longer than this, hence larger
     if( internalValue.length() > gint.internalValue.length() ) {
        return 1;
     } else if( internalValue.length() < gint.internalValue.length() ) {
        return (-1);

    // otherwise, they are the same length, so compare absolute values
     } else {
        for( int i = 0; i < internalValue.length(); i++ ) {
           Character a = Character.valueOf( internalValue.charAt(i) );
           Character b = Character.valueOf( gint.internalValue.charAt(i) );
           if( Character.valueOf(a).compareTo( Character.valueOf(b) ) > 0 ) {
              return 1;
           } else if( Character.valueOf(a).compareTo( Character.valueOf(b) ) < 0 ) {
              return (-1);
           }
        }
     }
     return 0;
  }


  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to check if a BrobInt passed as argument is equal to this BrobInt
   *  @param  gint     BrobInt to compare to this
   *  @return boolean  that is true if they are equal and false otherwise
   *  NOTE: this method performs a similar lexicographical comparison as the "compareTo()" method above
   *        also using the java String "equals()" method -- THAT was easy, too..........
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public boolean equals( BrobInt gint ) {
      return (internalValue.equals( gint.toString() ));
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to return a BrobInt given a long value passed as argument
   *  @param  value         long type number to make into a BrobInt
   *  @return BrobInt  which is the BrobInt representation of the long
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public static BrobInt valueOf( long value ) throws NumberFormatException {
     BrobInt gi = null;
     String val = Long.valueOf( value ).toString();
  // System.out.println(sign);
/*     if ( 1 == sign){
       val = "-" + val;
     }
*/
    try {
       gi = new BrobInt( val );
    }
    catch( NumberFormatException nfe ) {
       System.out.println( "\n  Sorry, the value must be numeric of type long." );
    }
    return gi;
 }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to return a String representation of this BrobInt
   *  @return String  which is the String representation of this BrobInt
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public String toString() {
     String byteVersionOutput = "";

      for( int i = 0; i < byteVersion.length; i++ ) {
         byteVersionOutput = byteVersionOutput.concat( Byte.toString( byteVersion[i] ) );
      }

      if (1 == sign) {
        byteVersionOutput = "-" + byteVersionOutput;
      }

      byteVersionOutput = new String( new StringBuffer( byteVersionOutput ).reverse() );
      return internalValue;
   }


  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to display an Array representation of this BrobInt as its bytes
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public void toArray( byte[] d ) {
      System.out.println( Arrays.toString( d ) );
   }


  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  the main method redirects the user to the test class
   *  @param  args  String array which contains command line arguments
   *  note:  we don't really care about these
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public static void main( String[] args ) {
      System.out.println( "\n  Hello, world, from the BrobInt program!!\n" );
      System.out.println( "\n   You should run your tests from the BrobIntTester...\n" );


/*

       String g01String = "144127909719710664015092431502440849849506284148982076191826176553";
       String g02String = "144127909719710664015092431502440849849506284148982076191826176553";
       String g03String = "144127909719710664015092431502440849849506284108982076191826176553";
       String g04String = "14412790971971066401509243150244084984950628410898207";
       String g05String = "0";
       String g06String = "1";
       String g07String = "10";
       String g11String = "10";
       String g12String = "20";
       String g13String = "234567";
       String g14String = "-234567";
       String g15String = "-10";
       String g16String = "-999999";
       String g17String = "765";
       String g18String = "23";
       String g19String = "56789";
       String g20String = "37";

       BrobInt g1 = null;
       BrobInt g2 = null;
       BrobInt g3 = null;
       BrobInt g4 = null;
       BrobInt g5 = null;
       BrobInt g6 = null;
       BrobInt g7 = null;
       BrobInt g8 = null;
       BrobInt g9 = null;
       BrobInt g10 = null;
       BrobInt g11 = null;
       BrobInt g12 = null;
       BrobInt g13 = null;
       BrobInt g14 = null;
       BrobInt g15 = null;
       BrobInt g16 = null;
       BrobInt g17 = null;
       BrobInt g18 = null;
       BrobInt g19 = null;
       BrobInt g20 = null;

       System.out.println( "\n  Hello, world, from the BrobInt program!!\n" );

       System.out.println( "    TESTING CONSTRUCTOR AND CONSTANTS:\n" +
                           "    ==================================" );
       try {
          System.out.println( "    Test 001: Making a new BrobInt: " );
          g1 = new BrobInt( g01String );
       }
       catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }
       try {
          System.out.println( "      expecting: " + g01String + "\n" +
                              "        and got: " + g1.toString() );
       }
       catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

       System.out.println( "\n    Test 002: Making a second new BrobInt [same as first]: " );
       try {
          g2 = new BrobInt( g02String );
          System.out.println( "      expecting: " + g02String + "\n" +
                              "        and got: " + g2.toString() );
       }
       catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

       try {
          System.out.println( "    Test 003: Comparing equality of g1 and g2 with 'equals()': " );
          System.out.println( "      expecting: true\n" + "        and got: " + g1.equals( g2 ) );
       }
       catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

       try {
          System.out.println( "\n    Test 004: Making a third new BrobInt [differs at position 47    |]: " +
                              "\n           [position indicated by down arrow]                  v   " );
          g3 = new BrobInt( g03String );
       }
       catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

       try {
          System.out.println( "      expecting: " + g03String + "\n" +
                              "        and got: " + g3.toString() );
          System.out.println( "          g1 is: " + g1.toString() );
       }
       catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

       try {
          System.out.println( "    Test 005: Comparing equality of g1 and g3 [detect different digit]: " );
          System.out.println( "      expecting: false\n" + "        and got: " + g1.equals( g3 ) );
       }
       catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

       try {
          System.out.println( "\n    Test 006: Making a fourth new BrobInt [same as g3 but truncated]: "  );
          g4 = new BrobInt( g04String );
       }
       catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

       try {
          System.out.println( "      expecting: " + g04String + "\n" +
                              "        and got: " + g4.toString() );
       }
       catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

       try {
          System.out.println( "    Test 007: Comparing equality of g3 and g4 [detect different length prior to detecting different digit]: " );
          System.out.println( "      expecting: false\n" + "        and got: " + g3.equals( g4 ) );
       }
       catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

       try {
          System.out.println( "\n    Test 008: Making a fifth new BrobInt, checking BrobInt.ZERO: "  );
          g5 = new BrobInt( "0" );
       }
       catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

       try {
          System.out.println( "      expecting: " + BrobInt.ZERO + "\n" +
                              "        and got: " + g5.toString() );
       }
       catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

       try {
          System.out.println( "\n    Test 009: Making a sixth new BrobInt, checking BrobInt.ONE: "  );
          g6 = new BrobInt( "1" );
       }
       catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

       try {
          System.out.println( "      expecting: " + BrobInt.ONE + "\n" +
                              "        and got: " + g6.toString() );
       }
       catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

       try {
          System.out.println( "\n    Test 010: Making a seventh new BrobInt, checking BrobInt.TEN: "  );
          g7 = new BrobInt( g07String );
       }
       catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

       try {
          System.out.println( "      expecting: " + BrobInt.TEN + "\n" +
                              "        and got: " + g7.toString() );
       }
       catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

       System.out.println( "\n\n    TESTING VALUEOF( LONG ) METHOD:\n" +
                           "    ===============================" );
       System.out.println( "\n    Test 011: Creating several long type values to check the 'valueOf()' method: " );
       long long01 = Long.MAX_VALUE;
       long long02 = Long.MIN_VALUE;
       long long03 = 1234567890;
       try {
          System.out.println( "      expecting: " + Long.MAX_VALUE + "\n" +
                              "        and got: " + long01 );
       }
       catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

       try {
          System.out.println( "      expecting: " + Long.MIN_VALUE + "\n" +
                              "        and got: " + long02 );
       }
       catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

       try {
          System.out.println( "      expecting: 1234567890\n" +
                              "        and got: " + long03 );
       }
       catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

       try {
          System.out.println( "    Test 012: Now testing 'valueOf()' method: " );
          g8  = BrobInt.valueOf( long01 );
          g9  = BrobInt.valueOf( long02 );
          g10 = BrobInt.valueOf( long03 );
       }
       catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

       try {
          System.out.println( "      expecting: " + Long.MAX_VALUE + "\n" +
                              "        and got: " + g8.toString() );
       }
       catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

       try {
          System.out.println( "      expecting: " + Long.MIN_VALUE + "\n" +
                              "        and got: " + g9.toString() );
       }
       catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

       try {
          System.out.println( "      expecting: 1234567890\n" +
                              "        and got: " + g10.toString() );
       }
       catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

       System.out.println( "\n\n    TESTING ADD() AND ADDINT() METHODS:\n" +
                           "    =======================================" );

       try {
          System.out.println( "\n    Test 013: Making an eleventh and twelfth new BrobInt, calling add method: "  );
          g11 = new BrobInt( g11String );
       }
       catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

       try {
          System.out.println( "      expecting: 10\n" +
                              "        and got: " + g11.toString() );
       }
       catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

       try {
          g12 = new BrobInt( g12String );
       }
       catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

       try {
          System.out.println( "      expecting: 20\n" +
                              "        and got: " + g12.toString() );
       }
       catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

       try {
          System.out.println( "    Test 014: Adding g11 and g12: " );
          System.out.println( "      expecting: 30 and got " + g11.add( g12 ) );
       }
       catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

       System.out.println( "\n    Test 015: Making a thirteenth new BrobInt, calling add methods: "  );
       try {
          g13 = new BrobInt( g13String );
       }
       catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

       try {
          System.out.println( "      expecting: 234567\n" +
                              "        and got: " + g13.toString() );
       }
       catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

       try {
          System.out.println( "    Test 016: Adding g11 and g13 [10 + 234567] using bytes: " );
          System.out.println( "      expecting: 234577 and got " + g11.add( g13 ) );
       }
       catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

       try {
          System.out.println( "    Test 017: Adding g11 and g13 [10 + 234567] using ints: " );
          System.out.println( "      expecting: 234577 and got " + g11.addInt( g13 ) );
       }
       catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

       try {
          System.out.println( "    Test 018: Adding g13 and g11 [234567 + 10] using bytes: " );
          System.out.println( "      expecting: 234577 and got " + g13.add( g11 ) );
       }
       catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

       try {
          System.out.println( "    Test 019: Adding g13 and g11 [234567 + 10] using ints: " );
          System.out.println( "      expecting: 234577 and got " + g13.addInt( g11 ) );
       }
       catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

       System.out.println( "\n    Test 020: Making a fourteenth new BrobInt, calling add methods: "  );
       try {
          g14 = new BrobInt( g14String );
       }
       catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

       try {
          System.out.println( "      expecting: -234567\n" +
                              "        and got: " + g14.toString() );
          System.out.println( "\n    Test 021: Making a fifteenth new BrobInt, calling add methods: "  );
       }
       catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

       try {
          g15 = new BrobInt( g15String );
       }
       catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

       try {
          System.out.println( "      expecting: -10\n" +
                              "        and got: " + g15.toString() );
       }
       catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

       try {
          System.out.println( "    Test 022: Adding g14 and g15 [-234567 + -10] using bytes: " );
          System.out.println( "      expecting: -234577 and got " + g14.add( g15 ) );
       }
       catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

       try {
          System.out.println( "    Test 023: Adding g14 and g15 [-234567 + -10] using ints: " );
          System.out.println( "      expecting: -234577 and got " + g14.addInt( g15 ) );
       }
       catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

       try {
          System.out.println( "    Test 024: Adding g15 and g14 [-10 + -234567] using bytes: " );
          System.out.println( "      expecting: -234577 and got " + g15.add( g14 ) );
       }
       catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

       try {
          System.out.println( "    Test 025: Adding g15 and g14 [-10 + -234567] using ints: " );
          System.out.println( "      expecting: -234577 and got " + g15.addInt( g14 ) );
       }
       catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

       System.out.println( "\n    Test 026: Making a sixteenth new BrobInt, calling add methods: "  );
       try {
          g16 = new BrobInt( g16String );
          System.out.println( "      expecting: -999999\n" +
                              "        and got: " + g16.toString() );
       }
       catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

       try {
          System.out.println( "    Test 027: Adding g14 and g16 [-234567 + -999999] using bytes: " );
          System.out.println( "      expecting: -1234566 and got " + g14.add( g16 ) );
       }
       catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

       try {
          System.out.println( "    Test 028: Adding g14 and g16 [-234567 + -999999] using ints: " );
          System.out.println( "      expecting: -1234566 and got " + g14.addInt( g16 ) );
       }
       catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

       try {
          System.out.println( "    Test 029: Adding g16 and g14 [-999999 + -234567] using bytes: " );
          System.out.println( "      expecting: -1234566 and got " + g16.add( g14 ) );
       }
       catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

       try {
          System.out.println( "    Test 030: Adding g16 and g14 [-999999 + -234567] using ints: " );
          System.out.println( "      expecting: -1234566 and got " + g16.addInt( g14 ) );
       }
       catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

       try {
          System.out.println( "\n      Test 031: Adding g1 and g4 using bytes: " );
  //        System.out.println( "\n      g1 is: " + g1.internalValue );
  //        System.out.println( "\n      g4 is: " + g4.internalValue );
          System.out.println( "      expecting: 144127909719725076806064402568842359092656528233967026820237074760\n" +
                              "        and got: " + g1.add( g4 ) );
       }
       catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

       try {
          System.out.println( "\n      Test 032: Adding g4 and g1 using ints: " );
          System.out.println( "      expecting: 144127909719725076806064402568842359092656528233967026820237074760\n" +
                              "        and got: " + g4.addInt( g1 ) );
       }
       catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

       System.out.println( "\n\n    TESTING COMPARETO() METHOD:\n" +
                           "    ===========================\n" +
                           "    NOTE: this.compareTo(that) returns: -1 if this < that\n" +
                           "                               returns: +1 if this > that\n" +
                           "                               returns:  0 if this = that" );
       try {
          System.out.println( "\n    Test 033: Checking compareTo() method on g1.compareTo g2: "  );
          System.out.println( "      expecting: 0 and got: " + g1.compareTo( g2 ) );
       }
       catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

       try {
          System.out.println( "\n    Test 034: Checking compareTo() method on g2.compareTo g1: "  );
          System.out.println( "      expecting: 0 and got: " + g2.compareTo( g1 ) );
       }
       catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

       try {
          System.out.println( "\n    Test 035: Checking compareTo() method on g1.compareTo g3: "  );
          System.out.println( "      expecting: positive value and got: " + g1.compareTo( g3 ) );
       }
       catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

       try {
          System.out.println( "\n    Test 036: Checking compareTo() method on g3.compareTo g1: "  );
          System.out.println( "      expecting: negative value and got: " + g3.compareTo( g1 ) );
       }
       catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

       try {
          System.out.println( "\n    Test 037: Checking compareTo() method on g3.compareTo g4: "  );
          System.out.println( "      expecting: positive value and got: " + g3.compareTo( g4 ) );
       }
       catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

       try {
          System.out.println( "\n    Test 037a: Checking compareTo() method on 123456789.compareTo 234: "  );
          System.out.println( "      expecting: positive value and got: " + (new BrobInt("123456789").compareTo( new BrobInt("234"))) );
       }
       catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

       try {
          System.out.println( "\n    Test 037b: Checking compareTo() method on 123.compareTo 123456789: "  );
          System.out.println( "      expecting: ngative value and got: " + (new BrobInt("123").compareTo( new BrobInt("123456789"))) );
       }
       catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

       try {
          System.out.println( "\n    Test 037c: Checking compareTo() method on g3.compareTo 999: "  );
          System.out.println( "      expecting: positive value and got: " + g3.compareTo( new BrobInt( "999" ) ) );
       }
       catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

       try {
          System.out.println( "\n    Test 037d: Checking compareTo() method on 1234.compareTo -999: "  );
          System.out.println( "      expecting: positive value and got: " + (new BrobInt("1234").compareTo( new BrobInt( "-999" ) ) ) );
       }
       catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

       try {
          System.out.println( "\n    Test 037e: Checking compareTo() method on -999.compareTo G3: "  );
          System.out.println( "      expecting: negative value and got: " + new BrobInt( "-999" ).compareTo( g3 ) );
       }
       catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }
       */

      /*
      try {
         System.out.println( "    Test 001: Making a new BrobInt: " );
         g1 = new BrobInt( g01String );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  BEEDOOP" ); }
      try {
         System.out.println( "      expecting: " + g01String + "\n" +
                             "        and got: " + g1.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  BEEBOOP" ); }

      System.out.println( "\n    Test 002: Making a second new BrobInt [same as first]: " );
      try {
         g2 = new BrobInt( g02String );
         System.out.println( "      expecting: " + g02String + "\n" +
                             "        and got: " + g2.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  BUUUUDOOP" ); }

      try {
         System.out.println( "    Test 003: Making a new BrobInt: " );
         g13 = new BrobInt( g13String );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  BEEDOOP" ); }

      try {
         System.out.println( "    Test 004: Making a new BrobInt: " );
         g11 = new BrobInt( g11String );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  BEEDOOP" ); }


      System.out.println( "\n\n    TESTING ADD() AND ADDINT() METHODS:\n" +
                          "    =======================================" );
      try {
         System.out.println( "\n    Test 013: Making an eleventh and twelfth new BrobInt, calling add method: "  );
         g11 = new BrobInt( g11String );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "      expecting: 10\n" +
                             "        and got: " + g11.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         g12 = new BrobInt( g12String );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "      expecting: 20\n" +
                             "        and got: " + g12.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "    Test 014: Adding g11 and g12: " );
         System.out.println( "      expecting: 30 and got " + g11.add( g12 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      System.out.println( "\n\n    TESTING SUBTRACTBYTE() METHOD:\n" +
                          "    ==============================" );

      System.out.println( "\n      Test 038: Subtracting g13 take away g11 [234567 - 10] using bytes: " );
      try {
         System.out.println( "      expecting: 234557\n" +
                             "        and got: " + g13.subtract( g11 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); e.printStackTrace(); }

      */


}
}
