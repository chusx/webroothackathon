//package com.webroothackathon.app.problem10;
import java.util.*;
import java.lang.*;

public class Problem10
{
  /*
   * As a detective John Morgan, you've followed your target to a secret warehouse where you assume all the stolen goods are located.
   * The door to this warehouse is secured by an electronic combination lock, but you're not sure about the PIN entered by the target.
   *
   * The keypad has the following layout:
   *
   *  _ _ _
   * |1|2|3|
   *  - - -
   * |4|5|6|
   *  - - -
   * |7|8|9|
   *  - - -
   *   |0|
   *    -
   *
   * You've noted the PIN 1357, but it's possible that each of the digits seen could actually be another adjacent digit 
   * (horizontally or vertically, but not diagonally). E.g. instead of the 1 it could also be the 2 or 4. And instead of the 5 it 
   * could be the 2, 4, 6, or 8.
   *
   * Create a function that returns a String array of all variations for an observed PIN with a length of 1 to 8 digits.
   * Any incorrect inputs should return an empty String array.
   * Note: All PINs must be strings, due to to potentially leadings '0's.
   *
   * @param (observedPIN) (String of 1-8 digits)
   * @return (result) (String[] of possible PINs)
   *
   *
   * E.g. GetPins("8") should return an array with values: "5", "7", "8", "9", "0".
   * 	GetPins("12") should return an array with values: "11", "21", "41", "12", "22", "42", "13", "23", "43", "15", "25", "45".
   */

  public static String[] GetPins(String observedPin) {
    ArrayList<Integer> pinList = new ArrayList<Integer>();
    int digit;
    for(int i = 0; i < observedPin.length(); ++i) {
      String s = observedPin.substring(i, i+1);
      try {
        digit = Integer.parseInt(s);
      }
      catch (NumberFormatException e) {
        return new String[0];
      }
      pinList.add(digit);
    }

    ArrayList<ArrayList<Integer>> pinVariations =
      new ArrayList<ArrayList<Integer>>();
    for(int i = 0; i < pinList.size(); ++i) {
      pinVariations.add(new ArrayList<Integer>());
      singleVariations(pinList.get(i), pinVariations.get(i));
    }

    ArrayList<String> results = new ArrayList<String>();
    int depth = 0;
    rAppend("", pinVariations, results, depth);

    String[] stringResults = new String[results.size()];
    for(int i = 0; i < stringResults.length; ++i) {
      stringResults[i] = results.get(i);
    }

    return stringResults;
  }

  private static void singleVariations(int digit,
    ArrayList<Integer> pinVar)
  {
    switch(digit) {
      case 0: pinVar.add(0);
              pinVar.add(8);
              break;
      case 1: pinVar.add(1);
              pinVar.add(2);
              pinVar.add(4);
              break;
      case 2: pinVar.add(1);
              pinVar.add(2);
              pinVar.add(3);
              pinVar.add(5);
              break;
      case 3: pinVar.add(2);
              pinVar.add(3);
              pinVar.add(6);
              break;
      case 4: pinVar.add(1);
              pinVar.add(4);
              pinVar.add(5);
              pinVar.add(7);
              break;
      case 5: pinVar.add(2);
              pinVar.add(4);
              pinVar.add(5);
              pinVar.add(6);
              pinVar.add(8);
              break;
      case 6: pinVar.add(3);
              pinVar.add(5);
              pinVar.add(6);
              pinVar.add(9);
              break;
      case 7: pinVar.add(4);
              pinVar.add(7);
              pinVar.add(8);
              break;
      case 8: pinVar.add(5);
              pinVar.add(7);
              pinVar.add(8);
              pinVar.add(9);
              pinVar.add(0);
              break;
      case 9: pinVar.add(6);
              pinVar.add(8);
              pinVar.add(9);
              break;
      default:
    }
  }

  private static void rAppend(String s, ArrayList<ArrayList<Integer>> pinVar,
      ArrayList<String> results, int depth)
  {
    String intermediate = new String();
    for(int i = 0; i < pinVar.get(depth).size(); ++i) {
      int digit = pinVar.get(depth).get(i);
      intermediate = s.concat(String.valueOf(digit));
      if(depth < pinVar.size()-1)
        rAppend(intermediate, pinVar, results, depth+1);
      else
        results.add(intermediate);
    }
  }

  public static void main(String[] argv) {
    String pin = "12";
    String[] pins = GetPins(pin);
    for(int i = 0; i < pins.length; ++i) {
      System.out.println(pins[i]);
    }
  }
}
