package com.webroothackathon.app.problem1;

public class UrlCatItem 
{
  public UrlCatItem(String url, int category, int reputation)
  {
    this.url = url.toLowerCase();
    this.category = category;
    this.reputation = reputation;
  }

  public boolean isGreater(UrlCatItem urlCatItem)
  {	
    if (this.url.charAt(0) > urlCatItem.url.charAt(0))
      return true;
    else if (this.url.charAt(0) == urlCatItem.url.charAt(0))
    {
      if(this.reputation >= urlCatItem.reputation)
        return true;
    }

    return false;
  }

  @Override
    public String toString()
    {
      return "Url: " + this.url + ", Rep: " + this.reputation + ", Cat: " + this.category; 
    }

  @Override
    public boolean equals(Object obj) {

      if (this == obj) {
        return true;
      }

      if (!(obj instanceof UrlCatItem)) {
        return false;
      }

      UrlCatItem other = (UrlCatItem) obj;

      return url == other.url && 
        category == other.category && 
        reputation == other.reputation;
    }

  public String url;
  public int category;
  public static int reputation;
}
