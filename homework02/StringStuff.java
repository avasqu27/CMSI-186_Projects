/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  StringStuff.java
 *  Purpose       :  A file full of stuff to do with the Java String class
 *  Author        :  B.J. Johnson
 *  Date          :  2017-01-19
 *  Description   :  This file presents a bunch of String-style helper methods.  Although pretty much
 *                   any and every thing you'd want to do with Strings is already made for you in the
 *                   Jave String class, this exercise gives you a chance to do it yourself [DIY] for some
 *                   of it and get some experience with designing code that you can then check out using
 *                   the real Java String methods [if you want]
 *  Notes         :  None
 *  Warnings      :  None
 *  Exceptions    :  None
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision History
 *  ----------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-01-19  B.J. Johnson  Initial writing and release
 *  @version 1.1.0  2017-01-22  B.J. Johnson  Fill in methods to make the program actually work
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
import java.util.Set;
import java.util.LinkedHashSet;

public class StringStuff {

  /**
   * Method to determine if a string contains one of the vowels: A, E, I, O, U, and sometimes Y.
   * Both lower and upper case letters are handled.  In this case, the normal English rule for Y means
   * it gets included.
   *
   * @param s String containing the data to be checked for &quot;vowel-ness&quot;
   * @return  boolean which is true if there is a vowel, or false otherwise
   */
   public static boolean containsVowel( String s ) {
     String vowelsU = "AEIOU";
     String vowelsL = "aeiou";

     for (int i = 0; i <= (s.length()-1); i++) {
       for (int j = 0; j <= (vowelsU.length()-1);j++){
         if (vowelsU.charAt(j) == s.charAt(i)) {
           return true;
         } else if (vowelsL.charAt(j) == s.charAt(i)) {
           return true;
         }
       }
     }
      return false;
   }

  /**
   * Method to determine if a string is a palindrome.  Does it the brute-force way, checking
   * the first and last, second and last-but-one, etc. against each other.  If something doesn't
   * match that way, returns false, otherwise returns true.
   *
   * @param s String containing the data to be checked for &quot;palindrome-ness&quot;
   * @return  boolean which is true if this a palindrome, or false otherwise
   */
   public static boolean isPalindrome( String s ) {
     String s2 =reverse(s);
     // sets s1 to the input string
     if (s2.contains(s) == true) {
       return true;
     } else {
       return false;
     }

   }

  /**
   * Method to return the characters in a string that correspond to the &quot;EVEN&quot; index
   * numbers of the alphabet.  The letters B, D, F, H, J, L, N, P, R, T, V, X, and Z are even,
   * corresponding to the numbers 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, and 26.
   *
   * @param s String containing the data to be parsed for &quot;even&quot; letters
   * @return  String containing the &quot;even&quot; letters from the input
   */
   public static String evensOnly( String s ) {
     String evenLettersU = "BDFHJLNPRTVXZ";
     int elength = evenLettersU.length() - 1;
     String evenLettersL = "bdfhjlnprtvxz";
     String evenString = "";

     for (int i = 0; i <= (s.length()-1); i++) {
       // grabs A
       for (int j = 0; j <= (elength); j++) {
         if (evenLettersU.charAt(j) == s.charAt(i)) {
           evenString = evenString + evenLettersU.charAt(j);
         } else if (evenLettersL.charAt(j) == s.charAt(i)) {
           evenString = evenString + evenLettersL.charAt(j);
         }
       }
     }
     System.out.println(evenString);
     return evenString;
   }

  /**
   * Method to return the characters in a string that correspond to the &quot;ODD&quot; index
   * numbers of the alphabet.  The letters A, C, E, G, I, K, M, O, Q, S, U, W, and Y are odd,
   * corresponding to the numbers 1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, and 25.
   *
   * @param s String containing the data to be parsed for &quot;odd&quot; letters
   * @return  String containing the &quot;odd&quot; letters from the input
   */
   public static String oddsOnly( String s ) {
     String oddLettersU = "ACEGIKMOQSUWY";
     String oddLettersL = "acegikmoqsuwy";
     int olength = oddLettersU.length() - 1;
     String oddString = "";

     for (int i = 0; i <= (s.length()-1); i++) {
       // grabs A
       for (int j = 0; j <= (olength); j++) {
         if (oddLettersU.charAt(j) == s.charAt(i)) {
           oddString = oddString + oddLettersU.charAt(j);
         } else if (oddLettersL.charAt(j) == s.charAt(i)) {
           oddString = oddString + oddLettersL.charAt(j);
         }
       }
     }
     return oddString;
   }

  /**
   * Method to return the characters in a string that correspond to the &quot;EVEN&quot; index
   * numbers of the alphabet, but with no duplicate characters in the resulting string.
   *
   * @param s String containing the data to be parsed for &quot;even&quot; letters
   * @return  String containing the &quot;even&quot; letters from the input without duplicates
   */
   public static String evensOnlyNoDupes( String s ) {
     String evenString = evensOnly(s);
     String newString = "";
     char currentCh = evenString.charAt(0);
     String stringCh = "";

     for (int i = 0; i<= (evenString.length()-1); i++){
       currentCh = evenString.charAt(i);
       stringCh = String.valueOf(currentCh);
         if (newString.contains(stringCh) == false) {
           newString = newString + evenString.charAt(i);
         }
     }
     return newString;
   }

  /**
   * Method to return the characters in a string that correspond to the &quot;ODD&quot; index
   * numbers of the alphabet, but with no duplicate characters in the resulting string.
   *
   * @param s String containing the data to be parsed for &quot;odd&quot; letters
   * @return  String containing the &quot;odd&quot; letters from the input without duplicates
   */
   public static String oddsOnlyNoDupes( String s ) {
   String oddString = oddsOnly(s);
   String newString = "";
   char currentCh = oddString.charAt(0);
   String stringCh = "";

   for (int i = 0; i<= (oddString.length()-1); i++){
     currentCh = oddString.charAt(i);
     stringCh = String.valueOf(currentCh);
       if (newString.contains(stringCh) == false){
         newString = newString + oddString.charAt(i);
       }
   }
   return newString;
 }

  /**
   * Method to return the reverse of a string passed as an argument
   *
   * @param s String containing the data to be reversed
   * @return  String containing the reverse of the input string
   */
   public static String reverse( String s ) {
     String s1 = s;
     // sets s1 to the input string
     String s2 = "";
     // sets s2 to an empty string
     int slength = s.length() - 1;
     int currentlet = 0;
     //sets slength to numerical value of the length os input string

     for (int i = 0; i <= (slength); i++) {
       currentlet = slength - i;
       s2 = s2 + s1.charAt(currentlet);
       // charAt returns character at index i
     }
    return s2;
   }

  /**
   * Main method to test the methods in this class
   *
   * @param args String array containing command line parameters
   */
   /*
   public static void main( String args[] ) {
      String blah = new String( "Blah blah blah" );
      String woof = new String( "BCDBCDBCDBCDBCD" );
      String pal1 = new String( "a" );
      String pal2 = new String( "ab" );
      String pal3 = new String( "aba" );
      String pal4 = new String( "amanaplanacanalpanama" );
      String pal5 = new String( "abba" );
      System.out.println( containsVowel( blah ) );
      System.out.println( containsVowel( woof ) );
      System.out.println( isPalindrome( pal1 ) );
      System.out.println( isPalindrome( pal2 ) );
      System.out.println( isPalindrome( pal3 ) );
      System.out.println( isPalindrome( pal4 ) );
      System.out.println( isPalindrome( pal5 ) );
      System.out.println( "evensOnly()        returns: " + evensOnly( "REHEARSALSZ" ) );
      System.out.println( "evensOnly()        returns: " + evensOnly( "REhearSALsz" ) );
      System.out.println( "evensOnlyNoDupes() returns: " + evensOnlyNoDupes( "REhearSALsz" ) );
      System.out.println( "oddsOnly()         returns: " + oddsOnly( "xylophones" ) );
      System.out.println( "oddsOnly()         returns: " + oddsOnly( "XYloPHonES" ) );
      System.out.println( "oddsOnlyNoDupes()  returns: " + oddsOnlyNoDupes( "XYloPHonES" ) );
      System.out.println( "reverse()          returns: " + reverse( "REHEARSALSZ" ) );
   }
   */
}
