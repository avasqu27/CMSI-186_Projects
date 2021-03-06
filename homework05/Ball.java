/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  Ball.java
 *  Purpose       :  The faux program for the SoccerSim class
 *  @see
 *  @author       :  Alejandra Vasquez
 *  Date written  :  2017-03-13
 *  Description   :  This program sets the ball's position, velocity, and time.
 *  Notes         :  None right now.  I'll add some as they occur.
 *  Warnings      :  None
 *  Exceptions    :  None
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

// ********F**O**C**U**S**I**N**G******
//            O**N
//           O**N**E*
//          B**A**L**L
//           F**O**R
//  *********N**O**W*****************

// extends theySeeMeRolling

//  IN SECONDS

import java.text.DecimalFormat;

public class Ball {

  DecimalFormat df = new DecimalFormat("#0.00");
  public double xpos = 0.0;
  public double ypos = 0.0;
  public double xspeed = 0.0;
  public double yspeed = 0.0;
  public static double friction = 0.01;
  public double time_slice_in_seconds = 1.0;

  /**
   *  Checks if valid inputs
   *  sets the ball's positions and speeds; sets timeslice
   */
  public void Ball(String args[]) throws NumberFormatException {
    double howManyArgs = args.length;
    try {
      double NewargValue = 0;
      for (int i = 0; i < (howManyArgs-1); i++) {
        NewargValue = Double.parseDouble(args[i]);
        // NewargValue is the double representation of the each input
      if (NewargValue >= 0) {
        continue;
        // if the input is above or equal to zero, continue the for loop
      } else {
        throw new NumberFormatException();
        // if not, then throw a Number format exception
      }
    }
  }
    catch (NumberFormatException e) {
      System.out.println("Not a valid statement! Try again next time; DANGER DANGER WILL ROBINSON");
    }
    xpos = Double.parseDouble(args[0]);
    ypos = Double.parseDouble(args[1]);
    xspeed = Double.parseDouble(args[2]);
    yspeed = Double.parseDouble(args[3]);
    if ( 5 == howManyArgs) {
      time_slice_in_seconds = Double.parseDouble(args[4]);
    }
  }


  public double xfriction() {
    // feet per second
    xspeed = xspeed - xspeed*friction;
    if (xspeed <= 0.5) {
      xspeed = 0;
    }
    return xspeed;
  }

  public double yfriction() {
    // feet per second
    yspeed = yspeed - yspeed*friction;
    if (yspeed <= 0.5) {
      yspeed = 0;
    }
    return yspeed;
  }

  public double movingx() {
    xpos = xpos + xspeed;
    return xpos;
  }

  public double movingy() {
    ypos = ypos + yspeed;
    return ypos;
  }

  public double xpos() {

    return xpos;
  }

  public  double ypos() {
    return ypos;
  }

public String toString() {
  // String representation to report to Soccer Sim
  // wants to return x and y position of the ball + elapsed Time
if ((xspeed == 0) || (yspeed == 0)) {
  String stringrep = "position < " + String.valueOf(xpos)+ " X, " + String.valueOf(ypos) + " Y >" + "              velocity < at rest >";
  return stringrep;
} else {
  String stringrep = "position < " + String.valueOf(xpos)+ " X, " + String.valueOf(ypos) + " Y >" + "              velocity < " + String.valueOf(xspeed) +" X and " + String.valueOf(yspeed) + " Y > ft/sec";
  return stringrep;
}
}

public static void main( String args[] ) {

   System.out.println( "\n Ball TESTER PROGRAM\n" +
                       "--------------------------\n" );
   System.out.println( "  Creating a new clock: " );
   Ball ball1 =  new Ball();
   System.out.println( "    New clock created: " + ball1.toString() );
   System.out.println( "    Testing inputs for Ball()....");
   String[] newArgs = {"10", "10", "1", "1" };
   ball1.Ball(newArgs);
   System.out.println((ball1.xpos));
   System.out.println((ball1.ypos));
   System.out.println((ball1.xspeed));
   System.out.println((ball1.yspeed));
   System.out.println(ball1.toString());
  // System.out.println((ball1.elapsedTime));
 }



 // check if it can handle negative numbers
}
