package com.webroothackathon.app.problem5;

import java.util.*;

/**
 * Given an ArrayList of IP ranges in the form of a String object, retrieve
 * all unique IP ranges (with the ranges being inclusive) containing an IP 
 * passed in the getIpRanges function.
 *
 * For example: 
 * If my ArrayList ipRanges contains the following Strings:
 * ["0.0.0.1-0.0.0.5", "0.0.0.3-0.0.0.6","0.0.0.1-0.0.0.5","0.0.0.7-0.0.0.10"]
 * If I call getIpRanges with the String "0.0.0.5", you should return:
 * ["0.0.0.1-0.0.0.5", "0.0.0.3-0.0.0.6"]
 * since those ranges contain "0.0.0.5". We omitted one of the 
 * "0.0.0.1-0.0.0.5" Strings because the description specified to only return
 * unique IP ranges.
 *
 *
 * Return null if the passed IP String is null or empty ("").
 * Return an empty ArrayList if there are no IP ranges that contain the 
 * requested IP.
 *
 * You will be evaluated based on accuracy as well as look up time using a large
 * volume of IP ranges.
 *
 * Reference 200.txt file in this directory to see a sample of 200 IP ranges. 
 * The data set that your logic will be tested on is not the same file.
 *
 */
public class Problem5
{
    ArrayList<String> ipRanges;

    public void initializeIpRanges(String fileName) {
        FileReader fr = new FileReader(fileName);
        ipRanges = fr.getAllIpRanges();
    }
    

    /*
     * Return all IP ranges that contain given the IP.
     */
    public ArrayList<String> getIpRanges(String ip) {
        /*
        String s = new String("200.txt");
        initializeIpRanges(s);
        */
        System.out.println(ipRanges);
        return null; 
    }
    /*
    public static void main(String[] argv) {
    }*/

}
