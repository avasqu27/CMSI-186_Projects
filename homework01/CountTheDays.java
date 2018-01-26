/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * File name   : CountTheDays.java
 * Purpose     : Displays "Hello, World!"
 * Author      : Alejandra Vasquez
 * Date        : 01/21/2018
 * Description : None
 * Notes       : None
 * Warnings    : None
 * Exceptions  : None
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
public class CountTheDays {
   public static void main(String[] args) {
     // gets a string input
       long[] dates = new long[6];
       // array of six elements
       for (int i = 0; i < 6; i++) {
         // divides string input into six elements
         dates [i] = Long.parseLong(args[i]);
         // substitutes an element in dates with a parsed part of input string
       }
       long result = CalendarStuff.daysBetween(dates[0], dates[1], dates[2], dates[3], dates[4], dates[5]);
       // calls CalendarStuff file, daysBetween method and compares dates array
       // each element of dates array refers to month, day, or year
       // CalendarStuff.daysBetween result gets returned to CountTheDays
      System.out.println(result);
     }
      // prints out result
}
// user input in the terminal determines the countthedays between the dates
