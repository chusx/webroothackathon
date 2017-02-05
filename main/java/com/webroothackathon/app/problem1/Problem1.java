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

      for(int i = urlCatItems.length - 2; i >= 0; i--)
      {
        if (lowestCatItem.isGreater(urlCatItems[i]))
          lowestCatItem = urlCatItems[i];
      }
      return new IntPair(lowestCatItem.category, lowestCatItem.reputation);
    }

  }

/*  public static void main(String[] argv) {
    UrlCatItem[] u = new UrlCatItem[0];
    IntPair test = getLowestCatRep(u);
    System.out.println(test.first);
    System.out.println(test.second);

    UrlCatItem[] urlArr = new UrlCatItem[5];
    urlArr[0] = new UrlCatItem("abc", 0, 100);
    //System.out.println(0+":"+urlArr[0]);
    urlArr[1] = new UrlCatItem("def", 1, 101);
    //System.out.println(1+":"+urlArr[1]);
    urlArr[2] = new UrlCatItem("ghi", 2, 102);
    //System.out.println(2+":"+urlArr[2]);
    urlArr[3] = new UrlCatItem("jkl", 3, 103);
    //System.out.println(3+":"+urlArr[3]);
    urlArr[4] = new UrlCatItem("mno", 4, 104);
    //System.out.println(4+":"+urlArr[4]);
    IntPair test1 = getLowestCatRep(urlArr);
    System.out.println(test1.first);
    System.out.println(test1.second);

    urlArr[0] = new UrlCatItem("ab", 5, 99);
    //System.out.println(0+":"+urlArr[0]);
    urlArr[1] = new UrlCatItem("ab", 10, 101);
    //System.out.println(1+":"+urlArr[1]);
    urlArr[2] = new UrlCatItem("ab", 20, 102);
    //System.out.println(2+":"+urlArr[2]);
    urlArr[3] = new UrlCatItem("ab", 30, 103);
    //System.out.println(3+":"+urlArr[3]);
    urlArr[4] = new UrlCatItem("ab", 40, 104);
    //System.out.println(4+":"+urlArr[4]);
    test1 = getLowestCatRep(urlArr);
    System.out.println(test1.first);
    System.out.println(test1.second);

    urlArr[0] = new UrlCatItem("ab", 10, 110);
    //System.out.println(0+":"+urlArr[0]);
    urlArr[1] = new UrlCatItem("ab", 10, 101);
    //System.out.println(1+":"+urlArr[1]);
    urlArr[2] = new UrlCatItem("ab", 10, 102);
    //System.out.println(2+":"+urlArr[2]);
    urlArr[3] = new UrlCatItem("ab", 10, 103);
    //System.out.println(3+":"+urlArr[3]);
    urlArr[4] = new UrlCatItem("ab", 10, 104);
    //System.out.println(4+":"+urlArr[4]);
    test1 = getLowestCatRep(urlArr);
    System.out.println(test1.first);
    System.out.println(test1.second);
  }*/
}
