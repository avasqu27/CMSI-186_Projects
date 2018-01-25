/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * File name   : CalendarStuff.java
 * Purpose     : Displays "Hello, World!"
 * Author      : Alejandra Vasquez
 * Date        : 01/21/2018
 * Description : None
 * Notes       : None
 * Warnings    : None
 * Exceptions  : None
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
public class CalendarStuff {
  /**
   * A listing of the days of the week, assigning numbers; Note that the week arbitrarily starts on Sunday
   */
   private static final int SUNDAY    = 0;
   private static final int MONDAY    = SUNDAY    + 1;
   private static final int TUESDAY   = MONDAY    + 1;
   private static final int WEDNESDAY = TUESDAY   + 1;
   private static final int THURSDAY  = WEDNESDAY + 1;
   private static final int FRIDAY    = THURSDAY  + 1;
   private static final int SATURDAY  = FRIDAY    + 1;

  /**
   * A listing of the months of the year, assigning numbers
   */
   private static final int January    = 0;
   private static final int February   = January   + 1;
   private static final int March      = February  + 1;
   private static final int April      = March     + 1;
   private static final int May        = April     + 1;
   private static final int June       = May       + 1;
   private static final int July       = June      + 1;
   private static final int August     = July      + 1;
   private static final int September  = August    + 1;
   private static final int October    = September + 1;
   private static final int November   = October   + 1;
   private static final int December   = November  + 1;

  /**
   * An array containing the number of days in each month
   *  NOTE: this excludes leap years, so those will be handled as special cases
   *  NOTE: this is optional, but suggested
   */
   private static int[]    days        = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

  /**
   * The constructor for the class
   */
   public CalendarStuff() {
      System.out.println( "Constructor called..." );  // replace this with the actual code

   }

  /**
   * A method to determine if the year argument is a leap year or not<br />
   *  Leap years are every four years, except for even-hundred years, except for every 400
   * @param    year  long containing four-digit year
   * @return         boolean which is true if the parameter is a leap year
   */
   public static boolean isLeapYear( long year ) {
     if ((year%4 == 0) && (!year%100 == 0)) {
       return true;
     } else if (year%400 == 0){
       return true;
     } else {
       return false;
     }
  }

  /**
   * A method to calculate the days in a month, including leap years
   * @param    month long containing month number, starting with "1" for "January"
   * @param    year  long containing four-digit year; required to handle Feb 29th
   * @return         long containing number of days in referenced month of the year
   * notes: remember that the month variable is used as an indix, and so must
   *         be decremented to make the appropriate index value
   */
   public static long daysInMonth( long month, long year ) {
     month = month - 1;
     if (month == 1) {
       if (isLeapYear(year) == true) {
         return (days[month] + 1);
       }
     } else {
       return days[month];
     }
   }

  /**
   * A method to determine if two dates are exactly equal
   * @param    month1 long    containing month number, starting with "1" for "January"
   * @param    day1   long    containing day number
   * @param    year1  long    containing four-digit year
   * @param    month2 long    containing month number, starting with "1" for "January"
   * @param    day2   long    containing day number
   * @param    year2  long    containing four-digit year
   * @return          boolean which is true if the two dates are exactly the same
   */
   public static boolean dateEquals( long month1, long day1, long year1, long month2, long day2, long year2 ) {
     long date1 ;
     date1 = new long [2];
     date1[0] = month1;
     date1[1] = day1;
     date1[2] = year1;
     long date2 ;
     date2 = new long [2];
     date2[0] = month2;
     date2[1] = day2;
     date2[2] = year2;
     if (date1 == date2){
       return true;
     }
      return false;
   }

  /**
   * A method to compare the ordering of two dates
   * @param    month1 long   containing month number, starting with "1" for "January"
   * @param    day1   long   containing day number
   * @param    year1  long   containing four-digit year
   * @param    month2 long   containing month number, starting with "1" for "January"
   * @param    day2   long   containing day number
   * @param    year2  long   containing four-digit year
   * @return          int    -1/0/+1 if first date is less than/equal to/greater than second
   */
   public static int compareDate( long month1, long day1, long year1, long month2, long day2, long year2 ) {
     if (year0 < year1) {
       return (-1);
     } else if (year0 > year1) {
       return (1);
     } else {
       if (month0 < month1) {
         return (-1);
       } else if (month0 > month1) {
         return (1);
       } else {
         if (day0 < day1) {
           return (-1);
         } else if (day0 > day1) {
           return (1);
         } else {
           return 0;
         }
       }
     }
   }

  /**
   * A method to return whether a date is a valid date
   * @param    month long    containing month number, starting with "1" for "January"
   * @param    day   long    containing day number
   * @param    year  long    containing four-digit year
   * @return         boolean which is true if the date is valid
   * notes: remember that the month and day variables are used as indices, and so must
   *         be decremented to make the appropriate index value
   */
   public static boolean isValidDate( long month, long day, long year ) {
      month = month - 1;

     if (year > 0) {
      if ((month >= 0 ) && (month <= 11)) {
      // checks if month is between Jan and Dec.
           if ((month == 3) || (month == 5) || (month == 8) || (month == 9 )) {
           // check if day exists in the month
             if ( (day > 0) && (day <= 30) ) {
               return true;
             }
           } else if (month == 1) {
             if (isLeapYear(year) == 1) {
               if ( (day > 0) && (day <= 29) ) {
                 return true;
               }
             } else {
               if ( (day > 0) && (day <= 28) ) {
                 return true;
               }
             }
           } else if ( (day > 0) && (day <= 31) ) {
             return true;
             // check if it is a valid day
           } else {
             return false;
           }
     } else {
       return false;
     }
   }
    return false;
   }

  /**
   * A method to return a string version of the month name
   * @param    month long   containing month number, starting with "1" for "January"
   * @return         String containing the string value of the month (no spaces)
   */
   public static String toMonthString( int month ) {
      switch( month -1 ) {
        case 0:
          return "January";
        case 1:
          return "February";
        case 2:
          return "March";
        case 3:
          return "April";
        case 4:
          return "May";
        case 5:
          return "June";
        case 6:
          return "July";
        case 7:
          return "August";
        case 8:
          return "September";
        case 9:
          return "October";
        case 10:
          return "November";
        case 11:
          return "December";
         default: throw new IllegalArgumentException( "Illegal month value given to 'toMonthString()'." );
      }
   }

  /**
   * A method to return a string version of the day of the week name
   * @param    day int    containing day number, starting with "1" for "Sunday"
   * @return       String containing the string value of the day (no spaces)
   */
   public static String toDayOfWeekString( int day ) {
      switch( day - 1 ) {
        case 0:
          return "Sunday";
        case 1:
          return "Monday";
        case 2:
          return "Tuesday";
        case 3:
          return "Wednesday";
        case 4:
          return "Thursday";
        case 5:
          return "Friday";
        case 6:
          return "Saturday";
         default: throw new IllegalArgumentException( "Illegal day value given to 'toDayOfWeekString()'." );
      }
   }

  /**
   * A method to return a count of the total number of days between two valid dates
   * @param    month1 long   containing month number, starting with "1" for "January"
   * @param    day1   long   containing day number
   * @param    year1  long   containing four-digit year
   * @param    month2 long   containing month number, starting with "1" for "January"
   * @param    day2   long   containing day number
   * @param    year2  long   containing four-digit year
   * @return          long   count of total number of days
   */
   public static long daysBetween( long month0, long day0, long year0, long month1, long day1, long year1 ) {
      long dayCount = 0;
      long firstdate = {0,0,0};
      long seconddate = {0,0,0};

      // compares dates to see which is greater
      // smaller date becomes firstdate
      if (year0 < year1) {
        firstdate[0] = month0-1;
        firstdate[1] = day0;
        firstdate[2] = year0;
        seconddate[0] = month1 -1;
        seconddate[1] = day1;
        seconddate[2] = year1;
      } else if (year0 > year1) {
        firstdate[0] = month1 -1;
        firstdate[1] = day1;
        firstdate[2] = year1;
        seconddate[0] = month0 -1;
        seconddate[1] = day0;
        seconddate[2] = year0;
      } else {
        if (month0 < month1) {
          firstdate[0] = month0-1;
          firstdate[1] = day0;
          firstdate[2] = year0;
          seconddate[0] = month1 -1;
          seconddate[1] = day1;
          seconddate[2] = year1;
        } else if (month0 > month1) {
          firstdate[0] = month1 -1;
          firstdate[1] = day1;
          firstdate[2] = year1;
          seconddate[0] = month0 -1;
          seconddate[1] = day0;
          seconddate[2] = year0;
        } else {
          if (day0 < day1) {
            firstdate[0] = month0-1;
            firstdate[1] = day0;
            firstdate[2] = year0;
            seconddate[0] = month1 -1;
            seconddate[1] = day1;
            seconddate[2] = year1;
          } else if (day0 > day1) {
            firstdate[0] = month1 -1;
            firstdate[1] = day1;
            firstdate[2] = year1;
            seconddate[0] = month0 -1;
            seconddate[1] = day0;
            seconddate[2] = year0;
          } else {
            firstdate[0] = month0-1;
            firstdate[1] = day0;
            firstdate[2] = year0;
            seconddate[0] = month1 -1;
            seconddate[1] = day1;
            seconddate[2] = year1;
          }
        }
      }

       if ( firstdate[2] == seconddate[2]) {
      for (long j = firstdate[0]; j <= seconddate[0]; j++) {
          if (firstdate[0] == seconddate[0]) {
            dayCount = Math.abs(seconddate[1] - firstdate[1]);
          } else {
            if ((firstdate[0] == 2) && (isLeapYear(firstdate[2]) == true)) {
              dayCount =+  Math.abs(firstdate[1] - 29);
              firstdate[1] = 0;
            } else {
                dayCount =  Math.abs(firstdate[1]-days[firstdate[0] ] );
                firstdate[1] = 0;
               }
          }
      }
    }
// NOW FOR THE YEARS
     for (long i = firstdate[2]; i <= seconddate[2]; i++) {
       if ((firstdate[0] == seconddate[0]) && (firstdate[1] == seconddate[1])) {
         if (isLeapYear(firstdate[2]) == true) {
           dayCount =+ 366;
         } else {
           dayCount =+ 365;
         }
       } else if ( (firstdate[0] == seconddate[0]) && (firstdate[1] != seconddate[1]) ) {
         if ((firstdate[0] == 2) && (isLeapYear(firstdate[2]) == true)) {
           dayCount =+  Math.abs(firstdate[1] - 29);
           firstdate[1] = 0;
         } else {
             dayCount =  Math.abs(firstdate[1]-days[firstdate[0] ] ); // get days of first date
             firstdate[1] = 0;
            }
       } else {
         for (long j = firstdate[0]; j <= seconddate[0]; j++) {
             if (firstdate[0] == seconddate[0]) {
               dayCount =  Math.abs(seconddate[1] - firstdate[1]);
             } else {
               if ((firstdate[0] == 2) && (isLeapYear(firstdate[2]) == true)) {
                 dayCount =+  Math.abs(firstdate[1] - 29);
                 firstdate[1] = 0;
               } else {
                   dayCount =  Math.abs(firstdate[1]-days[firstdate[0] ] );
                   firstdate[1] = 0;
                  }
             }
         }
       }
       //*********************************************
     }
   return dayCount;

}
