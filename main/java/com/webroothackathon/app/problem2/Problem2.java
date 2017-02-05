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

      UrlCatItem[] matchingItems = new UrlCatItem[100];
      int curr = 0;
      for (int i = 0; i < urls.size(); i++) {

        UrlCatItem temp = urls.get(i);
        if (temp.url.contains(s)) {
          if(curr == matchingItems.length)
            matchingItems = resizeArray(matchingItems);
          matchingItems[curr++] = new UrlCatItem(temp.url, temp.category, 
              temp.reputation);
        }
      }

      Sorter sorter = new Sorter(matchingItems);
      sorter.mergeSort(0, matchingItems.length - 1);

      matchingUrls = new ArrayList<UrlCatItem>(Arrays.asList(matchingItems));
    }
  }

  private static UrlCatItem[] resizeArray(UrlCatItem[] src) {
    int newSize = 2*src.length;
    UrlCatItem[] resizedArr = new UrlCatItem[newSize];
    for(int i = 0; i < src.length; ++i) {
      resizedArr[i] = src[i];
    }
    return resizedArr;
  }

/*  public static void main(String[] args) {
    ArrayList<UrlCatItem> urls = new ArrayList<UrlCatItem>();
    ArrayList<UrlCatItem> matchingUrls = new ArrayList<UrlCatItem>();
    String s = "abc";
    UrlCatItem url = new UrlCatItem("abc", 0, 0);
    for(int i = 0; i < 100; ++i) {
      urls.add(url);
    }
    getMatchingUrls(urls, s, matchingUrls);
    System.out.println(matchingUrls.size());
    for(int i = 0; i < matchingUrls.size(); ++i) {
      System.out.println(matchingUrls.get(i));
    }
  }*/
}
