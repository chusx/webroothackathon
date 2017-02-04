package com.webroothackathon.app.problem2;

import com.webroothackathon.app.problem1.UrlCatItem;
import java.util.*;

public class Problem2 {

    /*
     * Given an ArrayList of UrlCatItems (urls) and a String s, 
     * populate a second ArrayList (matchingUrls) with all UrlCatItems from 
     * urls where UrlCatItem.url contains the String s. You are also to ensure that the 
     * UrlCatItem objects in the matchingUrls ArrayList are sorted according to 
     * Sorter's (Sorter.java) sorting definition.
     *
     * Do not do anything if any of the parameters are null.
     *
     * Note: This problem assumes you have fixed the issues with UrlCatItem 
     *       exposed in problem1
     *
     * @param (urls) (populated array of UrlCatItems)
     * @param (s)    (string sequence to be matched in UrlCatItems.url)
     * @param (matchingUrls) (array that should be populated with all the matched UrlCatItems)
     */
    public void getMatchingUrls(ArrayList<UrlCatItem> urls, 
        String s, ArrayList<UrlCatItem> matchingUrls) {
        if (s != null && urls != null && matchingUrls != null) {

            UrlCatItem[] matchingItems = new UrlCatItem[10];
            int curr = 0;
            for (int i = 0; i < urls.size(); i++) {
                
                UrlCatItem temp = urls.get(i);
                if (temp.url.contains(s)) {
                    matchingItems[curr] = new UrlCatItem(temp.url, temp.category, 
                        temp.reputation);
                }
            }

            Sorter sorter = new Sorter(matchingItems);
            sorter.mergeSort(0, matchingItems.length - 1);

            matchingUrls = new ArrayList<UrlCatItem>(Arrays.asList(matchingItems));
        }
    }
}
