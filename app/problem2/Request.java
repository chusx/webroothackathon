package com.webroothackathon.app.problem2;

import com.webroothackathon.app.problem1.UrlCatItem;
import java.util.*;

/*
 * Helper class
 */
public class Request {

    public String stringToFind;
    public List<UrlCatItem> urlItems; 

    public Request() {
        urlItems = new ArrayList<UrlCatItem>();
    }
}
