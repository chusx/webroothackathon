package com.webroothackathon.app.problem2;

import com.webroothackathon.app.problem1.UrlCatItem;
import java.util.*;


/*
 * Takes in an array of UrlCatItems and sorts it in descending order 
 * following these rules (same rules as in problem1):
 *  1. UrlCatItem with the smaller char(0) of the url is considered smaller.
 *  2. If both urls have the same char(0) of the url then the one with lower 
 *      reputation is considered smaller.
 *  3. If reputation is also the same then leave the url in order they are 
 *      seen in the array.
 *
 *  Note: mergesort skeleton is provided, but any sorting algorithm can be used.
 */

class Sorter 
{
	public Sorter(UrlCatItem[] urlCatItems)
	{
		this.urlCatItems = urlCatItems;
		this.tempUrlCatItems = new UrlCatItem[urlCatItems.length];
	}

	public void mergeSort(int lowIndex, int highIndex)
	{
		if(lowIndex < highIndex)
		{
			int middle = lowIndex + (highIndex - lowIndex) / 2;

			//recursion on left half
			mergeSort(lowIndex, middle);
			//recursion on right half
			mergeSort(middle+1, highIndex);

			mergeParts(lowIndex, middle, highIndex);
		}
	}

	private void mergeParts(int lowIndex, int midIndex, int highIndex)
	{	
	}

	private UrlCatItem[] urlCatItems;
	private UrlCatItem[] tempUrlCatItems;
}
