/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  SoccerSim.java
 *  Purpose       :  The main program for the SoccerSim class
 *  @see
 *  @author       :  Alejandra Vasquez
 *  Date written  :  2017-03-13
 *  Description   :  Uses Ball.java and Timer.java
 *  Notes         :  None right now.  I'll add some as they occur.
 *  Warnings      :  None
 *  Exceptions    :  None
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

// import java.text.DecimalFormat;

public class SoccerSim extends Ball {

//  DecimalFormat df = new DecimalFormat("#0.00");

//  public double n = 0.0;
  public double ballSpeed = 0.0;
  public double x = 0;
  public double y = 0;
  public double acceleration = 0.1;
  public static double field = 1000;
  Ball[] balls = null;
/*
public String SoccerSim(int n){
  Ball[] balls = null;

}
*/

public void isValid( String args[]) throws NumberFormatException {
  double howManyArgs = args.length;
  try {
    if (args.length <= 0) {
      String works = "works!";
    } else {
      throw new NumberFormatException();
      // if not, then throw a Number format exception
    }
  }
  catch (NumberFormatException e) {
    System.out.println("Not a valid statement! You have inserted an invalid number of inputs. Inputs must consist of 4 inputs per ball. Example: <10 10 1 1> ");
  }

  if (howManyArgs %4 == 0){

    balls = new Ball[(int) Math.floor(args.length/4)];
    // number of balls created
    /*for (int i =0; i < args.length; i+=4) {
        balls[i] = Double.parseDouble(args[i]);
        balls[i+1] = Double.parseDouble(args[i+1]);
        balls[i+2] = Double.parseDouble(args[i+2]);
        balls[i+3] = Double.parseDouble(args[i+3]);
    }*/

    for (int j = 0; j < Math.floor(args.length/4); j++) {
      for (int i =0; i < args.length; i+=4) {
        String[] array = {args[i], args[i+1], args[i+2], args[i+3]};
        //balls[j] = Ball((args[i]), (args[i+1]), (args[i+2]), (args[i+3]));
        balls[j].Ball(array);
      }
    }

  }else if (howManyArgs %4 == 1) {

    balls = new Ball[(int) Math.floor(args.length/4)];
    for (int j = 0; j < Math.floor(args.length/4); j++) {
      for (int i =0; i < args.length; i+=4) {
      //  balls[j] = Ball((args[i]), (args[i+1]), (args[i+2]), (args[i+3]), (args[args.length-1]));
        String[] array = {args[i], args[i+1], args[i+2], args[i+3],args[args.length-1]};
        balls[j].Ball(array);
      }
    }

  }
  }



public static void main( String args[] ) throws NumberFormatException {
  try {
    if (args.length <= 0) {
      String works = "works!";
    } else {
      throw new NumberFormatException();
    }
}
  catch (NumberFormatException e) {
    System.out.println("Not a valid statement! You have inserted an invalid number of inputs. Inputs must consist  of 4 inputs per ball. Example: <10 10 1 1> ");
  }
//  Ball[] soccerBalls = new SoccerSim();
  // SoccerSim soccerBalls = new SoccerSim();
  SoccerSim soccerBalls = new SoccerSim();
  soccerBalls.isValid(args);

  Timer timer = new Timer();
  double polepositionx = Math.random()*1000;
  double polepositiony = Math.random()*1000;
  double collision = 0;
  // collision marks if the ball stops moving or not

/*  for (let i = 0; i < ((int) Math.floor(args.length/4); i++) {
    if (args.length%4 == 1; j++) {
      balls[i].settingTheBall(i, i+1, i+2, i+3, args.length-1);
    }
    */

  while (collision == 0) {

    timer.tick();
    // ticks; increases time by time slice
    // for number of balls, repeat this:
    for (int i =0; i < (soccerBalls.balls.length - 1); i+=4) {
    soccerBalls.balls[i].xfriction();
    // changes x speed; double
    soccerBalls.balls[i].yfriction();
    // changes y speed; double
    soccerBalls.balls[i].movingx();
    soccerBalls.balls[i].movingy();
    // updates position; double
    soccerBalls.balls[i].toString();
    // string representation of above

    // check if in bounds of field
    if (( ((double)(soccerBalls.balls[i].xpos + 0.37083)) > field) | ( ((double)(soccerBalls.balls[i].xpos - 0.37083)) > field)) {
      System.out.println("Ball " + Integer.toString(i) + " is out of bounds. ");
      collision = 1;
    } else if (( ((double)(soccerBalls.balls[i].ypos + 0.37083)) > field) | ( ((double)(soccerBalls.balls[i].ypos - 0.37083)) > field)) {
      System.out.println("Ball " + Integer.toString(i) + " is out of bounds. ");
      collision = 1;
    }

  }

  int counter = 0;
  for (int i = 0; i < (soccerBalls.balls.length-1); i++) {
    if ((soccerBalls.balls[i].xspeed == 0) | (soccerBalls.balls[i].yspeed == 0)) {
      counter = counter++;
    }
    if (counter == soccerBalls.balls.length) {
      System.out.println("Soccer balls stopped moving! ");
      collision = 1;
    }
  }



  // now check if ball collided with another ball:

  for (int i = 0; i < (soccerBalls.balls.length/2); i++){
    // testing if balls in
    for (int j = 0; j < (soccerBalls.balls.length/2); j++) {
      if (soccerBalls.balls[j] == soccerBalls.balls[soccerBalls.balls.length-i]) {
        break;
      }
      if (( Math.abs(soccerBalls.balls[j].ypos - soccerBalls.balls[soccerBalls.balls.length-i].ypos) ) <=  0.37083*2  ) {
        collision = 1;
        System.out.println("Collision occurred at " + Timer.TimetoString() );
    } else if ( ( Math.abs(soccerBalls.balls[j].xpos - soccerBalls.balls[soccerBalls.balls.length-i].xpos) ) <= 0.37083*2 ) {
      collision = 1;
      System.out.println("Collision occurred at " + Timer.TimetoString() );
    } else if (((soccerBalls.balls[j].xpos + 0.37083) == polepositionx ) | ((soccerBalls.balls[j].xpos - 0.37083) == polepositionx )){
      collision = 1;
    } else if (((soccerBalls.balls[j].ypos + 0.37083) == polepositiony ) | ((soccerBalls.balls[j].ypos - 0.37083) == polepositiony )){
    collision = 1;
    }
  // end of for loop
  }


}

  // end of while loop
  }
}



}
