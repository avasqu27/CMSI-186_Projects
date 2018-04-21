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
  ///  these can help speed up the math if they fit into the proper memory space
//  public static final BrobInt MAX_INT  = new BrobInt(  Integer.valueOf( Integer.MAX_VALUE ).toString() );
//  public static final BrobInt MIN_INT  = new BrobInt(  Integer.valueOf( Integer.MIN_VALUE ).toString() );
//  public static final BrobInt MAX_LONG = new BrobInt(  Long.valueOf( Long.MAX_VALUE ).toString() );
//  public static final BrobInt MIN_LONG = new BrobInt(  Long.valueOf( Long.MIN_VALUE ).toString() );

  /// These are the internal fields
   private String internalValue = "";        // internal String representation of this BrobInt
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
       System.out.println(value.substring(0,1));
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
    //   System.out.println("Check2: No wrongin' ");
       // charAt returns character at index i
     }

  //   System.out.println("past for statement ");

     int pos1 = s2.length();

     byteVersion = new byte[pos1];

    // System.out.println("Check5: No wrongin'");
     for (int j = 0; j < (s2.length()); j++) {
       byteVersion[j] = (byte) (Integer.parseInt(s2.substring( j, (j+1))));
     }
//     System.out.println(" BUT has the exception been thrown yet?");

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
//     throw new UnsupportedOperationException( "\n         Sorry, that operation is not yet implemented." );
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

     int[] resultByte = null;
     BrobInt larger = null;
     BrobInt smaller = null;
     int carry = 0;
     String result = "";

     int negativei = 0;
     int negativeg = 0;


     if (gint.sign  == 1 ) {
       negativei = 1;
//       System.out.println(sign  + " and new internalValue: " + internalValue);
     }

     if (sign  == 1 ) {
       negativeg = 1;
//       System.out.println(sign  + " and new internalValue: " + internalValue);
     }



/*     if (internalValue.charAt(0) == '-') {
       System.out.println("has negatuve");
       internalValue = internalValue.substring(1,internalValue.length()-1);
       negativei = 1;
     }
     if (gint.internalValue.charAt(0) == '-') {
       System.out.println("has negative");
       gint.internalValue = gint.internalValue.substring(1,internalValue.length()-1);
       negativeg = 1;
     }
     */


     if (this.compareTo(gint) == -1) {
       resultByte = new int[gint.internalValue.length() + 1];
       larger  = new BrobInt(gint.internalValue);
       smaller = new BrobInt(internalValue);
     } else {
       resultByte = new int[internalValue.length() + 1];
       larger  = new BrobInt(internalValue);
       smaller = new BrobInt(gint.internalValue);
     }
     // make the array the length of numbers of the bigger brobint




/*
     if (compareTo(gint) == 0) {
       resultByte = new int[internalValue.length()];
     } else if (compareTo(gint) == 1) {
       resultByte = new int[internalValue.length() + 1];
     } else {
       resultByte = new int[gint.internalValue.length() + 1];
     }
     */


    // actual addition
     for (int i = 0; i < smaller.byteVersion.length; i++) {
        resultByte[i] = byteVersion[i] + gint.byteVersion[i];
        //System.out.println(resultByte[i]);
      //  System.out.println( resultByte[i] );

        if (resultByte[i] > 9) {
          carry = 1;
          resultByte[i] = resultByte[i]-10;
        }
        result = result + Integer.toString(resultByte[i]);

        if ((larger.byteVersion.length-1 == i) & (carry == 1)){
          //resultByte[i+1] = carry;
          result = result + Integer.toString(resultByte[i+1]);
        //  System.out.println( "infiltration" );
        }
     }

     for (int j = 0; j < (larger.byteVersion.length - smaller.byteVersion.length ); j++) {
        result = result + (larger.byteVersion[j + smaller.byteVersion.length] );
      }

      if ((negativei == 1) & (negativeg == 1)){
        result = result + "-";
      }


// reverse
     String s1 = result;
     String s2 = "";
     int resultBytelength = result.length() - 1;
     int currentlet = 0;


     for (int i = 0; i <= (resultBytelength); i++) {
       currentlet = resultBytelength - i;
       s2 = s2 + s1.charAt(currentlet);
       // charAt returns character at index i
     }

     //System.out.println(s2);

     BrobInt finalResult = new BrobInt(s2);
    return finalResult;
  //  throw new UnsupportedOperationException( "\n         Sorry, that operation is not yet implemented." );
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

      for (int j = 0; j < (larger.byteVersion.length - smaller.byteVersion.length ); j++) {
        result = result + (larger.byteVersion[j + smaller.byteVersion.length] );
       }

      if ((compareTo(gint) == -1)){
        result = result + "-";
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
       return result;
    }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to multiply the value of a BrobIntk passed as argument to this BrobInt
   *  @param  gint         BrobInt to multiply by this
   *  @return BrobInt that is the product of the value of this BrobInt and the one passed in
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public BrobInt multiply( BrobInt gint ) {
      throw new UnsupportedOperationException( "\n         Sorry, that operation is not yet implemented." );
      // RUSSIAN PEASANT MMMMMMMMUUUUUUULLLLLLLTTTTTTTIIIIIIIIPPPPPPPLLLLLLLLLIIIIIICCCCCAAAAATTTTTTIIIIIIONNNNN!!!!!!!!!!!!
      // OR USE THE PSEODOCODE BJ GAVE US
      /*
      int a = 0;
      int b = 0;
      int resultByte = [];
      String resultString = "";
      for (let i = 0; i < gint.byteVersion.length; i++){
        resultByte[i] = this.byteVersion[i] * gint.byteVersion[i];
        if (resultByte[i] > 9) {
          carry = Math.abs(10-resultByte[i]);
          resultByte[i] = Math.abs(resultByte[i]-10);
          if (i == byteVersion.length-1) {
            resultByte[i+1] = carry;
            result = Integer.toString(resultByte(i+1));
          }
        }
        result = Integer.toString(resultByte(i));


      }
      */
   }
  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to divide the value of this BrobIntk by the BrobInt passed as argument
   *  @param  gint         BrobInt to divide this by
   *  @return BrobInt that is the dividend of this BrobInt divided by the one passed in
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public BrobInt divide( BrobInt gint ) {
      throw new UnsupportedOperationException( "\n         Sorry, that operation is not yet implemented." );
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to get the remainder of division of this BrobInt by the one passed as argument
   *  @param  gint         BrobInt to divide this one by
   *  @return BrobInt that is the remainder of division of this BrobInt by the one passed in
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public BrobInt remainder( BrobInt gint ) {
      throw new UnsupportedOperationException( "\n         Sorry, that operation is not yet implemented." );
   }



   /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  *  Method to compare a BrobInt passed as argument to this BrobInt
  *  @param  gint  BrobInt to add to this
  *  @return int   that is one of neg/0/pos if this BrobInt precedes/equals/follows the argument
  *  NOTE: this method does not do a lexicographical comparison using the java String "compareTo()" method
  *        It takes into account the length of the two numbers, and if that isn't enough it does a
  *        character by character comparison to determine
  *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
  //***********************************   DEPRECATION  HERE   **************************************************
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
//     System.out.println(sign);
/*     if ( 1 == sign){
       val = "-" + val;
     }*/
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

      if (1 == sign){
        byteVersionOutput = "-" + byteVersionOutput;
      }

      byteVersionOutput = new String( new StringBuffer( byteVersionOutput ).reverse() );
      return internalValue;
//      return this.internalValue;
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

      System.out.println( "    TESTING CONSTRUCTOR AND CONSTANTS:\n" +
                          "    ==================================" );

      System.out.println( "\n    Test 020: Making a fourteenth new BrobInt: "  );
      try {
         g14 = new BrobInt( g14String );
      }
    catch( Exception e ) { System.out.println( "        Exception thrown:  " ); /*e.printStackTrace();*/  }
    try {
       System.out.println( "      expecting: " + g01String + "\n" +
                           "        and got: " + g1.toString() );
    }
    catch( Exception e ) { System.out.println( "        Exception thrown:  BEEBOOP" ); }


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
