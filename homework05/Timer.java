/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  Timer.java
 *  Purpose       :  The main program for the SoccerSim class
 *  @see
 *  @author       :  Alejandra Vasquez
 *  Date written  :  2017-03-13
 *  Description   :  This program uses the Clock and ClockSolver java files to run the ball.
 *  Notes         :  None right now.  I'll add some as they occur.
 *  Warnings      :  None
 *  Exceptions    :  None
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */


import java.text.DecimalFormat;

public class Timer  {
  public double time_slice_in_seconds = 1.0;
//  Clock clock  = new Clock();
  DecimalFormat df = new DecimalFormat("#0.00");
  public  double elapsedTime = 0.0;
  public static double friction = 0.01;


  public Timer() {
    elapsedTime = 0.0;
  }

  public double tick() {
    elapsedTime = elapsedTime + time_slice_in_seconds;
    return elapsedTime;
   }

   public String TimetoString() {
       // returns hour, minutes, and seconds in string format
       // manipulate elapsedTime to give back hours, minutes, and seconds
       double hours = Math.floor(elapsedTime/3600);
       double minutes = Math.floor((elapsedTime - hours*3600)/60);
       double seconds = elapsedTime - hours*3600 - minutes*60;
        String time = (df.format(hours)) + ":" + (df.format(minutes)) + ":" + (df.format(seconds));
        return time;
   }

   public static void main( String args[] ) {

      Clock clock1  = new Clock();
      System.out.println( "\n Timer TESTER PROGRAM\n" +
                          "--------------------------\n" );
      System.out.println( "Let's try ticking: " );
      System.out.println("Testing tick(), initial time slice is 10.0 seconds....");
      System.out.println("expecting string with 0 for all hours and minutes, and 10.0 seconds values ");
      clock1.validateTimeSliceArg("10.0");
      try { System.out.println( ((10.0) == clock1.tick()) ? " - got 0:0:10" : " - no joy" ); }
      catch (Exception e ) { System.out.println( "- OOPS! " + e.toString() );}

      System.out.println(clock1.elapsedTime);
    }

}
