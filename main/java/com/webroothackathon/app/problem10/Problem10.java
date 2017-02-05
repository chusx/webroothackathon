package com.webroothackathon.app.problem10;
import java.util.*;

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

	public static String[] GetPins(String observedPin)
  	{
		return new String[]{""};
  	}
}
