/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  ClockSolver.java
 *  Purpose       :  The main program for the ClockSolver class
 *  @see
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

public class ClockSolver {
  /**
   *  Class field definintions go here
   */
   // private final double MAX_TIME_SLICE_IN_SECONDS  = 1800.00;
   private final double DEFAULT_TIME_SLICE_SECONDS = 60.0;
   private double EPSILON_VALUE              = 0.1;      // small value for double-precision comparisons


  /**
   *  Constructor
   *  This just calls the superclass constructor, which is "Object"
   */
   public ClockSolver() {
     // DO NOT ask the user for an inpur using the Scanner; let them use predetermined ones
      super();
   }


  /**
   *  Method to handle all the input arguments from the command line
   *   this sets up the variables for the simulation
   */
   public void handleInitialArguments( String args[] ) {
     // args[0] specifies the angle for which you are looking
     // check if angle is entered IN DEGREES
     // make sure the angle is less than 360.0 degrees
     //  your simulation will find all the angles in the 12-hour day at which those angles occur
     // args[1] if present will specify a time slice value; if not present, defaults to 60 seconds
     // you may want to consider using args[2] for an "angle window"

// **********************************************************************************************
// This is ARGS[1] --> ARGS IS TIME SLICE IN SECONDS
      System.out.println( "\n   Hello world, from the ClockSolver program!!\n\n" ) ;
      if( 0 == args.length ) {
         System.out.println( "   Sorry, you must enter at least one argument\n" +
                             "   Usage: java ClockSolver <angle> [timeSlice]\n" +
                             "   Please try again..........." );
         System.exit( 1 );
      } else if (1 == args.length){
        System.out.println("   Your simulation is running, \n" +
                           "   looking for angles of " + args[0] + " degrees \n" +
                           "   with a time slice of 60.0 seconds and \n" +
                           "   with an EPSILON_VALUE 0.1" );
      } else if (2 == args.length) {
        System.out.println("   Your simulation is running, \n" +
                           "   looking for angles of " + args[0] + " degrees \n" +
                           "   with a time slice of " + args[1] + " seconds and \n" +
                           "   with an EPSILON_VALUE 0.1" );
      } else if (3 == args.length) {
        System.out.println("   Your simulation is running, \n" +
                           "   looking for angles of " + args[0] + " degrees \n" +
                           "   with a time slice of " + args[1] + " seconds and \n" +
                           "   with an EPSILON_VALUE " + args[2] );
      } else {
        System.out.println("   Sorry, you must enter at most three arguments, including \n" +
                           "   Angle, Time_Slice, and EPSILON_VALUE separated by a space");
      }
      Clock clock = new Clock();
   }


  /**
   *  The main program starts here
   *  remember the constraints from the project description
   *  @see  http://bjohnson.lmu.build/cmsi186web/homework04.html
   *  @param  args  String array of the arguments from the command line
   *                args[0] is the angle for which we are looking
   *                args[1] is the time slice; this is optional and defaults to 60 seconds
   */
   public static void main( String args[] ) {
      ClockSolver cse = new ClockSolver();
      Clock clock    = new Clock();
      double[] timeValues = new double[3];
      cse.handleInitialArguments( args );
      if (args.length == 1) {
        double zeroInitial = Double.parseDouble(args[0]);
          while (zeroInitial > 360) {
            zeroInitial = zeroInitial - 360;
          }
          if (zeroInitial < 0) {
            zeroInitial = 360 + zeroInitial;
          }
    } else if (args.length == 2) {
      double zeroInitial = Double.parseDouble(args[0]);
        while (zeroInitial > 360) {
          zeroInitial = zeroInitial - 360;
        }
        if (zeroInitial < 0) {
          zeroInitial = 360 + zeroInitial;
        }
        clock.validateTimeSliceArg(args[1]);
        clock.chosen_time_slice_in_seconds = Double.parseDouble(args[1]);
  } else if (args.length == 3) {
    double zeroInitial = Double.parseDouble(args[0]);
      while (zeroInitial > 360) {
        zeroInitial = zeroInitial - 360;
      }
      if (zeroInitial < 0) {
        zeroInitial = 360 + zeroInitial;
      }
      clock.validateTimeSliceArg(args[1]);
      clock.chosen_time_slice_in_seconds = Double.parseDouble(args[1]);
      cse.EPSILON_VALUE = Double.parseDouble(args[2]);
  }
      while (clock.elapsedTime <= 43200 ) {
        double handAngle = clock.getHandAngle();
        double errorValue = Math.abs(handAngle - Double.parseDouble(args[0]) );
        if (errorValue <= cse.EPSILON_VALUE) {
          // get string representation of the hour, minute, and second that this occurs
          String time = clock.toString();
          System.out.println("Found target angle of " + args[0] + " at time: " + time);
        }

        double time = clock.tick();
        // System.out.println(time);
         //break;
      }
      System.exit( 0 );
   }
}
