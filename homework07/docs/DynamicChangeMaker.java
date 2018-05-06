/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * File name  :  DynamicChangeMaker.java
 * Purpose    :  ChangeMaker class; runs with DynamicChangemakerTestHarness for verification of the ChangeMaker class
 * @author    :  Professor BJ Johnson
 * @author    :  B.J. Johnson totally ripped off from the original
 * Date       :  2017-04-19
 * Description:  This clas2s is intended to be used as part of homework 7, the coin changemaker, which is a "Dynamic
 *                Programming" algorithm.
 * Notes      :  None
 * Warnings   :  None
 *
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;

public class DynamicChangeMaker{
  public int total = 0;
  public int index = 0;
  public static int[] indexArray = null;



/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Sets denom to indexArray
 *  @return  none
 *  @throws  IllegalArgumentException if something is hinky
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
public static int[] setArray(int[] n) {
  // throw new UnsupportedOperationException( "\n         Sorry, that operation is not yet implemented." );
  indexArray = n;
  return indexArray;
}



/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Method to check if inputs are valid; used in conjunction with BadData() and based on BJ's Tuple's
 *    checking method
 *  @throws  IllegalArgumentException if something is hinky
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
 public static void checkArray() {
  //throw new UnsupportedOperationException( "\n         Sorry, that operation is not yet implemented." );

  // count amount of index arguments
  // checks if element is valid
  int n = 0;
  for (int i = 0; i < indexArray.length; i++) {
    if ( indexArray[i] <= 0) {
      // zero or negative arguments
      n = 1;
      BadData(n);
      //return 1;
    } else if ( repeats() == 1) {
      // repeated arguments
      n = 2;
      BadData(n);
      //return 1;
    } else if (indexArray.length > 2) {
      // not enough arguments
      n = 3;
      BadData(n);
      //return 1;
    }
    else {
      // don't call Bad Data
      System.out.println(" Nothing wrong! Keep calm and carry on. ");
      //return 0;
    }
  }
  //return 0;
}

/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Returns int; used with checkArray()
 *  @return  int 1 if repeats exists; 0 if no repeats
 *  @throws  IllegalArgumentException if something is hinky
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
public static int repeats() {
  // throw new UnsupportedOperationException( "\n         Sorry, that operation is not yet implemented." );
  for (int i = 0; i < indexArray.length-1; i++) {
    for (int j = 1; j < indexArray.length-1; j++) {
      if (indexArray[i] == indexArray[j]) {
        //System.out.println("Inside the repeat loop: elements equal each other!");
        return 1;
      }
    }
    }
    return 0;
}

/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Returns string saying BAD DATA
 *  @return  String BadData
 *  @throws  IllegalArgumentException if something is hinky
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
public static String BadData(int n) {
  // throw new UnsupportedOperationException( "\n         Sorry, that operation is not yet implemented." );
  String newmessage = null;
  switch (n) {
    case 1: newmessage = "Input should not be zero or below zero. ";
      break;
    case 2: newmessage = "Inputs should not have repeats";
      break;
    case 3: newmessage = "Not enough arguments";
      break;
    default: newmessage = "The name's Bad. Bad Data. " + "You inputted an unknown invalid argument. ";
      break;
  }
  return newmessage;
  // must send out string "BAD DATA"
}

/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Method to return string saying BAD DATA
 *  @return  String data type
 *  @throws  IllegalArgumentException if something is hinky
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
public static Tuple makeChangeWithDynamicProgramming( int[] denom, int target) {
  //throw new UnsupportedOperationException( "\n         Sorry, that operation is not yet implemented." );
   Tuple lowest = new Tuple(denom.length);

   DynamicChangeMaker dynamicDuo = new DynamicChangeMaker();
  dynamicDuo.setArray(denom);
  dynamicDuo.checkArray();

  Tuple[][] t = new Tuple[denom.length][target+1];
  /*
  Tuple[][] t = new Tuple [rows][columns]
     where rows is argument length
     and column = target + 1
  */

  for( int i = 0; i < denom.length; i++ ) {
    for( int j = 0; j <= target; j++ ) {
      // Special case for column zero for all rows
      if( j == 0 ) {
        t[i][j] = new Tuple(denom.length);
        //(t[i][j]).setElement(i,1);
        // creates a tuple (< 0, 0, 0 >) of zeroes of denom.length
        // Otherwise, this is NOT column zero
       } else if (i%j == 0 ) {
         t[i][j] = new Tuple(1);
         //(t[i][j]).setElement(i,1);
          // returns int type
//          t[i][j] = new Tuple(t[i][j].data);
          if (i != 0 ) {
            // there is a valid tuple going up,
            if ( t[i-1][j].isImpossible() ) {
              t[i][j] = new Tuple(0);
            } else {
              t[i][j] = ( t[i][j] ).add( t[i-1][j] );
            }
          }
          // going backward
          if (i != 0 ) {
          if ((j- denom[i]) >= 0) {
            if ( t[i][j - denom[i]].isImpossible() ) {
              t[i][j] = new Tuple(0);
            } else {
              t[i][j] = ( t[i][j] ).add( t[i][j - denom[i]] );
            }
          } else {
            t[i][j].isImpossible();
            t[i][j] = new Tuple(0);
          }
        }
        }
        // but if remainder is NOT zero,
        else {
          // check if there is something above it that can be carried down
          if (i != 0 ){
            if ( t[i-1][j].isImpossible() ) {
              t[i][j] = new Tuple(0);
            } else {
              t[i][j] = t[i-1][j];
              // carried down ;
            }
          } else {
            // impossible Tuple
            t[i][j] = new Tuple(0);
          }
      }
    }
}
    // determine which tuple is the smallest
    for( int i = 0; i < denom.length; i++ ) {
      for( int j = 1; j <= target; j++ ) {
        if ( ( t[i][j-1] ).equals(t[i][j] ) ) {
          if ( (t[i][j]).total() <= lowest.total() ) {
            lowest = t[i][j];
          }
        } else if ( t[i][j].total() <= lowest.total() ) {
          lowest = t[i][j];
        }
      }
    }
    System.out.println(lowest.toString());
    return lowest;
}
}


/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Method to return string saying BAD DATA
 *  @return  String data type
 *  @throws  IllegalArgumentException if something is hinky
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
/*
public void main( String[] args) {
  throw new UnsupportedOperationException( "\n         Sorry, that operation is not yet implemented." );


  String output = "";

   for( int i = 0; i < byteVersion.length; i++ ) {
      byteVersionOutput = byteVersionOutput.concat( Byte.toString( byteVersion[i] ) );
   }

   if (1 == sign) {
     byteVersionOutput = "-" + byteVersionOutput;
   }

   byteVersionOutput = new String( new StringBuffer( byteVersionOutput ).reverse() );
   return internalValue;



}
*/
