/*
 *	Problem:
 *
 *	1. Given an unordered list of numbers from 1 to n, with no duplicate
 *	numbers, and one number missing, find the missng number.
 *
 *	For example, given n = 8 and x = { 1, 2, 8, 5, 4, 7, 3 }, find the missing
 *	number (6).
 *
 *	2. Given a similar unordered list of numbers from a to b, where a > 0 and
 *	a < b = n, use the above solution to find the missing number.
 *
 *	For example, given a = 4, b = 8 and x = { 8, 5, 4, 7 }, find the missing
 *	number (6).
 *
 *	Note: Solve both problems without sorting.
 */

package com.webroothackathon.app.problem3;

/**
 *
 * @author saif
 */
public class Problem3 {

	public static int findMissingInteger(
		int[] array, int n)
	{
		int sum = 0;
    int i;
    for(i=0;i<array.length;i++){
    	sum+=array[i];
    }
    int trueSum = sum+i+1;
    int missingNumber = trueSum - sum;
    return missingNumber;
	}



	public static int findMissingInteger(
		int[] x, int a, int b)
	{
		int i;
	  int trueSum = 0;
		int sum = 0;
 	 for(i=0;i<x.length;i++){
 		 	trueSum+=a++;
			sum+=x[i];
 	 }
	 trueSum+=a++;

		return trueSum-sum;
	}


}