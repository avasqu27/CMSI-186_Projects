/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  Clock.java
 *  Purpose       :  Provides a class defining methods for the ClockSolver class
 *  @author       :  B.J. Johnson
 *  Date written  :  2017-02-28
 *  Description   :  This class provides a bunch of methods which may be useful for the ClockSolver class
 *                   for Homework 4, part 1.  Includes the following:
 *
 *  Notes         :  None right now.  I'll add some as they occur.
 *  Warnings      :  None
 *  Exceptions    :  IllegalArgumentException when the input arguments are "hinky"
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision Histor
 *  ---------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-02-28  B.J. Johnson  Initial writing and release
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

import java.text.DecimalFormat;

public class Clock {
  /**
   *  Class field definintions go here
   */
   public double chosen_time_slice_in_seconds = 60.0;
   private static final double INVALID_ARGUMENT_VALUE = -1.0;
   private static final double MAXIMUM_DEGREE_VALUE = 360.0;
   private static final double HOUR_HAND_DEGREES_PER_SECOND = 0.00834;
   private static final double MINUTE_HAND_DEGREES_PER_SECOND = 0.1;
   public static double elapsedTime = 0.0;
   DecimalFormat df = new DecimalFormat("#0.00");
   // total time IN SECONDS

  /**
   *  Constructor goes here
   */
   public Clock() {
     elapsedTime = 0.0;
   }

  /**
   *  Methods go here
   *
   *  Method to calculate the next tick from the time increment
   *  @return double-precision value of the current clock tick
   */
   public double tick() {
     // function that is meant to be looped in ClockSolver
     elapsedTime = elapsedTime + chosen_time_slice_in_seconds;
     return elapsedTime;
   }

  /**
   *  Method to validate the angle argument
   *  @param   argValue  String from the main programs args[0] input
   *  @return  double-precision value of the argument
   *  @throws  NumberFormatException
   */
   public double validateAngleArg( String argValue ) throws NumberFormatException {

     double NewargValue = Double.parseDouble(argValue);

     try {
       NewargValue = Double.parseDouble(argValue);
       if (NewargValue < 0 ){
         throw new NumberFormatException();
       }
     }
     catch (NumberFormatException e) {
       System.out.println(" Not a valid statement! Try again next time; DANGER DANGER WILL ROBINSON");
      }

     if (NewargValue < 0 ){
       return 0;
     } else {
     return NewargValue;
   }

   }

  /**
   *  Method to validate the optional time slice argument
   *  @param  argValue  String from the main programs args[1] input
   *  @return double-precision value of the argument or -1.0 if invalid
   *  note: if the main program determines there IS no optional argument supplied,
   *         I have elected to have it substitute the string "60.0" and call this
   *         method anyhow.  That makes the main program code more uniform, but
   *         this is a DESIGN DECISION, not a requirement!
   *  note: remember that the time slice, if it is small will cause the simulation
   *         to take a VERY LONG TIME to complete!
   */
   public double validateTimeSliceArg( String argValue )  {
     // another version of plot format
     // while the other one throws an error to the main program, this one sends a value to indicate an error

     // string converted to double

     double n = -1;
     double NewargValue = Double.parseDouble(argValue);
     if (NewargValue >  0.0) {
       // **************** colors switch here *******************
       chosen_time_slice_in_seconds = NewargValue;
       return NewargValue;
     } else {
       return n;
     }
   }

  /**
   *  Method to calculate and return the current position of the hour hand
   *  @return double-precision value of the hour hand location
   */
   public double getHourHandAngle() {
     double currentHrAngle = elapsedTime * HOUR_HAND_DEGREES_PER_SECOND;
     while (currentHrAngle > 360) {
       currentHrAngle = currentHrAngle - 360;
     }
     //System.out.println("Hour hand is " + currentHrAngle);
     return currentHrAngle;
   }

  /**
   *  Method to calculate and return the current position of the minute hand
   *  @return double-precision value of the minute hand location
   */
   public double getMinuteHandAngle() {
     double currentMinAngle = elapsedTime * MINUTE_HAND_DEGREES_PER_SECOND;
     while (currentMinAngle > 360) {
       currentMinAngle = currentMinAngle - 360;
     }
     //System.out.println("Minute hand is " + currentMinAngle);
     return currentMinAngle;
   }

  /**
   *  Method to calculate and return the angle between the hands
   *  @return double-precision value of the angle between the two hands
   */
   public double getHandAngle() {
     // difference between hands' angles
     double hrHand = getHourHandAngle();
     double minHand = getMinuteHandAngle();
     double handAngle = Math.abs(hrHand - minHand);
     //System.out.println("Hand angle is " + handAngle);
     return handAngle;
   }

  /**
   *  Method to fetch the total number of seconds
   *   we can use this to tell when 12 hours have elapsed
   *  @return double-precision value the total seconds private variable
   */
   public double getTotalSeconds() {
     return elapsedTime;
   }

  /**
   *  Method to return a String representation of this clock
   *  @return String value of the current clock
   */
   public String toString() {
     // returns hour, minutes, and seconds in string format
     // manipulate elapsedTime to give back hours, minutes, and seconds

     double hours = Math.floor(elapsedTime/3600);
     double minutes = Math.floor((elapsedTime - hours*3600)/60);
     double seconds = elapsedTime - hours*3600 - minutes*60;
     /*if (seconds > 0) {
       seconds = 0;
     }
     if (minutes <= 60) {
       // create the hour category
       // think of it like
       hours = minutes/60;
       minutes = hours - Math.floor(hours);
     } else {
       hours = 0;
     }*/
      String time = (df.format(hours)) + ":" + (df.format(minutes)) + ":" + (df.format(seconds));
      return time;
   }

  /**
   *  The main program starts here
   *  remember the constraints from the project description
   *  @see  http://bjohnson.lmu.build/cmsi186web/homework04.html
   *  be sure to make LOTS of tests!!
   *  remember you are trying to BREAK your code, not just prove it works!
   */
   public static void main( String args[] ) {

      System.out.println( "\nCLOCK CLASS TESTER PROGRAM\n" +
                          "--------------------------\n" );
      System.out.println( "  Creating a new clock: " );
      Clock clock = new Clock();
      System.out.println( "    New clock created: " + clock.toString() );
      System.out.println( "    Testing validateAngleArg()....");
      System.out.print( "      sending '  0.0 degrees', expecting double value   0.0" );
      try { System.out.println( (0.0 == clock.validateAngleArg( "0.0" )) ? " - got 0.0" : " - no joy" ); }
      // sends out exception
      catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }
      // catches exception and gives an error message to the user
      System.out.print( "      sending '  30.0 degrees', expecting double value   30.0" );
      try { System.out.println( (30.0 == clock.validateAngleArg( "30.0" )) ? " - got 30.0" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }
      System.out.print( "      sending '  90.0 degrees', expecting double value   90.0" );
      try { System.out.println( (90.0 == clock.validateAngleArg( "90.0" )) ? " - got 90.0" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }
      System.out.print( "      sending '  120.0 degrees', expecting double value   120.0" );
      try { System.out.println( (120.0 == clock.validateAngleArg( "120.0" )) ? " - got 120.0" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }
      System.out.print( "      sending '  180.0 degrees', expecting double value   180.0" );
      try { System.out.println( (180.0 == clock.validateAngleArg( "180.0" )) ? " - got 180.0" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }
      System.out.print( "      sending '  270.0 degrees', expecting double value   270.0" );
      try { System.out.println( (270.0 == clock.validateAngleArg( "270.0" )) ? " - got 270.0" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }
      System.out.print( "      sending '  360.0 degrees', expecting double value   360.0" );
      try { System.out.println( (360.0 == clock.validateAngleArg( "360.0" )) ? " - got 360.0" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }
      System.out.print( "      sending '  -10.0 degrees', expecting no joy" );
      try { System.out.println( (-10.0 == clock.validateAngleArg( "-10.0" )) ? " - got -10.0" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }

      System.out.println("Testing validateTimeSliceArg()...");
      System.out.print( "      sending '  0 seconds', expecting ERROR MESSAGE " );
      try { System.out.println( ((-1) == clock.validateTimeSliceArg("0.0")) ? " - got -1; not cool" : "  - ERROR MESSAGE; rad! "); }
      catch (Exception e ) { System.out.println( "- OOPS! " + e.toString() );}
      // NEEDS A CATCH STATEMENT
      System.out.print( "      sending '  10.0 seconds', expecting double value" );
      try { System.out.println( ((10.0) == clock.validateTimeSliceArg("10.0")) ? " - got 10.0; awesome!" : " - uh oh" ); }
      catch (Exception e ) { System.out.println( "- OOPS! " + e.toString() );}
      System.out.print( "      sending '  45.0 seconds', expecting double value" );
      try { System.out.println( ((45.0) == clock.validateTimeSliceArg("45.0")) ? " - got 45.0; it works!" : " - uh oh" ); }
      catch (Exception e ) { System.out.println( "- OOPS! " + e.toString() );}
      System.out.print( "      sending '  90.0 seconds', expecting double value" );
      try { System.out.println( ((90.0) == clock.validateTimeSliceArg("90.0")) ? " - got 90.0; kaching!" : " - uh oh" ); }
      catch (Exception e ) { System.out.println( "- OOPS! " + e.toString() );}
      System.out.print( "      sending '  180.0 seconds', expecting double value" );
      try { System.out.println( ((180.0) == clock.validateTimeSliceArg("180.0")) ? " - got 45.0; whapow!" : " - uh oh" ); }
      catch (Exception e ) { System.out.println( "- OOPS! " + e.toString() );}
      System.out.print( "      sending '  500.0 seconds', expecting double value" );
      try { System.out.println( ((500.0) == clock.validateTimeSliceArg("500.0")) ? " - got 500.0; yahoo!" : " - uh oh" ); }
      catch (Exception e ) { System.out.println( "- OOPS! " + e.toString() );}
      System.out.print( "      sending '  ABC seconds', expecting ERROR MESSAGE" );
      try { System.out.println( (clock.validateTimeSliceArg("ABC"))); }
      catch (Exception e ) { System.out.println( "- OOPS! " + e.toString() );}
      System.out.print( "      sending '  1000.0 seconds', expecting double value" );
      try { System.out.println( ((1000.0) == clock.validateTimeSliceArg("1000.0")) ? " - got 1000.0; rad!" : " - uh oh" ); }
      catch (Exception e ) { System.out.println( "- OOPS! " + e.toString() );}
      System.out.print( "      sending '  1800.0 seconds', expecting double value" );
      try { System.out.println( ((1800.0) == clock.validateTimeSliceArg("1800.0")) ? " - got 1800.0; much wow!" : " - uh oh" ); }
      catch (Exception e ) { System.out.println( "- OOPS! " + e.toString() );}
      System.out.print( "      sending '  1805.0 seconds', expecting ERROR MESSAGE" );
      try { System.out.println( ((1805.0) == clock.validateTimeSliceArg("1805.0")) ? " - got 1805.0; cool!" : " - ERROR MESSAGE; rad!" ); }
      catch (Exception e ) { System.out.println( "- OOPS! " + e.toString() );}

      System.out.println("Testing toString()...");
      System.out.println("expecting string with 0:0:0 for all hours, minutes, and seconds values ");
      try { System.out.println( (("0:0:0") == clock.toString()) ? " - got 0:0:0" : " - no joy" ); }
      catch (Exception e ) { System.out.println( "- OOPS! " + e.toString() );}

/* THIS TIME SLICE ADDS SECONDS */
      System.out.println("Testing tick(), initial time slice is 10.0 seconds....");
      System.out.println("This test adds the new time slice. ");
      System.out.println("expecting string with 0 for all hours and minutes, and 10.0 seconds values ");
      clock.validateTimeSliceArg("10.0");
      try { System.out.println( ((10.0) == clock.tick()) ? " - got 0:0:10" : " - no joy" ); }
      catch (Exception e ) { System.out.println( "- OOPS! " + e.toString() );}
      System.out.println("expecting string with 0 for all hours and minutes, and 20.0 seconds values ");
      clock.validateTimeSliceArg("20.0");
      try { System.out.println( ((30.0) == clock.tick()) ? " - got 0:0:30" : " - no joy" ); }
      catch (Exception e ) { System.out.println( "- OOPS! " + e.toString() );}
      System.out.println("expecting string with 0 for all hours and minutes, and 30.0 seconds values ");
      clock.validateTimeSliceArg("30.0");
      try { System.out.println( ((60) == clock.tick()) ? " - got 0:1:00" : " - no joy" ); }
      catch (Exception e ) { System.out.println( "- OOPS! " + e.toString() );}
      System.out.println("expecting string with 0 for all hours and seconds, and 1.0 minutes values ");
      clock.validateTimeSliceArg("60.0");
      try { System.out.println( ((120) == clock.tick()) ? " - got 0:2:0" : " - no joy" ); }
      catch (Exception e ) { System.out.println( "- OOPS! " + e.toString() );}
      System.out.println("expecting string with 0 for all hours and seconds, and 2.0 minutes values ");
      clock.validateTimeSliceArg("120.0");
      try { System.out.println( ((240) == clock.tick()) ? " - got 0:4:0" : " - no joy" ); }
      catch (Exception e ) { System.out.println( "- OOPS! " + e.toString() );}

     Clock clock1 = new Clock();
     clock1.elapsedTime = 21957.107;
     System.out.println("Testing getHourHandAngle(), for current time 06:05:57.1070...");
     System.out.println("expecting double angle value of approximately 183.131 ");
     try { System.out.println( ((183.131) == clock1.getHourHandAngle()) ? " - got true" : " - no joy" );}
     catch (Exception e ) { System.out.println( "- OOPS! " + e.toString() );}

     clock1.elapsedTime = 21957.107;
     System.out.println("Testing getMinuteHandAngle(), for current time 06:05:57.1070...");
     System.out.println("expecting double angle value of approximately 35.811 ");
     try { System.out.println( ((35.811) == clock1.getMinuteHandAngle()) ? " - got true" : " - no joy" );}
     catch (Exception e ) { System.out.println( "- OOPS! " + e.toString() );}

     clock1.elapsedTime = 21957.107;
     System.out.println("Testing getHandAngle(), for current time 06:05:57.1070...");
     System.out.println("expecting double angle value of approximately 147.321 ");
     try { System.out.println( ((147.321) == clock1.getHandAngle()) ? " - got true" : " - no joy" );}
     catch (Exception e ) { System.out.println( "- OOPS! " + e.toString() );}
   }
}
