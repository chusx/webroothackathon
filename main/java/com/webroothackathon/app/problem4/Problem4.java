package com.webroothackathon.app.problem4;

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
        if (size == 0) {
		    return "Size needs to be a positive integer";
        }
        else if (size % 2 != 0) {
            StringBuffer sb = new StringBuffer(); 

            // first line
            sb.append(">");
            for (int j = 0; j < size; j++) {
                sb.append("_");
            }
            //sb.append(" \n");
            sb.append("\n");
            
            // second through half
            for (int i = 1; i < size / 2 + 1; i++) {
                for (int j = 0; j < i - 1; j++) {
                    sb.append("|");
                }
                sb.append(" ");
                for (int j = 0; j < size - 2 * i + 1; j++) {
                    sb.append("_");
                }

                sb.append(" ");
                for (int j = 0; j < i; j++) {
                    sb.append("|");
                }
                sb.append("\n");
            }

            // middle
            for (int j = 0; j < size - 4; j++) {
                sb.append("|");
            }
            sb.append(" < ");
            for (int j = 0; j < size - 4; j++) {
                sb.append("|");
            }
            sb.append("\n");

            
            int k = 0;
            // half through end
            for (int i = size / 2 + 1; i < size; i++, k++) {
                for (int j = i; j < size; j++) {
                    sb.append("|");
                }
                for (int j = 0; j < i - 1 + k; j++) {
                    sb.append("_");

                }

                for (int j = i; j < size; j++) {
                    sb.append("|");
                }
                sb.append("\n");
            }
            sb.setLength(sb.length() - 1);
            return sb.toString();
        }
        else {
            StringBuffer sb = new StringBuffer(); 
            return sb.toString();
        }
        
	}
    /*
    public static void main(String[] argv) {
        System.out.print(getSleepingSnake(4));
        System.out.print(getSleepingSnake(7));
    }
    */
}
