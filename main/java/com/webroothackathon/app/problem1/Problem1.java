package com.webroothackathon.app.problem1;

public class Problem1
{
	/*
	 *  Takes in an array of UrlCatItems and picks out the smallest UrlCatItem 
     	 *  from the array following these rules:
	 *  1. urlCatItem with the smaller char(0) of the url is considered smaller.
	 *  2. If both urls have the same char(0) of the url, then the one with 
     	 *      lower reputation is considered smaller.
	 *  3. If reputation is also equal, then the item that has a smaller index 
  	 *      in the array is considered smaller.
	 *	
	 *  If an empty array is passed in an IntPair object with -1 category and 
     	 *      -1 reputation should be returned.
	 *
	 *  @param (urlCatItems) (array of UrlCatItem)
	 *  @return (an IntPair, where the first int is the category of the 
     	 *      smallest UrlCatItem from the array and the second int is the 
     	 *      reputation of the smallest urlCatItem from the array.)
	 */
	public static IntPair getLowestCatRep(UrlCatItem[] urlCatItems)
	{
        if (urlCatItems.length == 0) {
            return new IntPair(-1, -1);
        }
        else {

	        UrlCatItem lowestCatItem = urlCatItems[urlCatItems.length - 1];
	           
	        for(int i = urlCatItems.length - 2; i > 0; i--)
	        {
	        	if (lowestCatItem.isGreater(urlCatItems[i]))
	        		lowestCatItem = urlCatItems[i];
	        }
	        return new IntPair(lowestCatItem.category, lowestCatItem.reputation);
        }

	}
    /*
    public static void main(String[] argv) {
        UrlCatItem[] u = new UrlCatItem[0];
        getLowestCatRep(u);
    }
    */
}
