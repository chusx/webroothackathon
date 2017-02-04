//package com.webroothackathon.app.problem4;

/*
 * DrawSleepingSnake Problem
 *
 * Implement getSleepingSnake(String size) which returns a string of a sleeping snake using chars:
 * > (greater than)
 * < (less than)
 * _ (underscore)
 * | (pipe)
 *   (space)
 *
 * size is the number of underscores the first line has and the number of pipes the most right layer has.
 *
 * If size is negative or 0 return "Size needs to be a positive integer".
 *
 * The snake's tail (>) should always start in the top left corner.
 * The snake's head (< or >) will depend on the orientation of the snake.
 *
 * Note: > is the first Char in the string
 * Note: There are spaces.
 *
 * example for size = 4
 >____
  ___ |
 | > ||
 ||__||
 |____|
 *
 * example for size = 7
 >_______
  ______ |
 | ____ ||
 || __ |||
 ||| < |||
 |||___|||
 ||_____||
 |_______|
 *
 *
 */

public class Problem4
{
	/*
	 * given a size draws a sleeping snake
         *
 	 * @param (size) (size of snake)
 	 * @return (String) (string of the sleeping snake)
         */

	public static String getSleepingSnake(int size)
	{
		String string = "";
		string += "fuck";
		return string;
	}

	public static void main(String[] args) {
		System.out.println(getSleepingSnake(7));
	}
}
