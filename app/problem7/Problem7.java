package com.webroothackathon.app.problem7;

/*
 * Add an Api call getRepFromFile(String filePath) that takes in a file path as its parameter. 
 * For each newline seperated url from the file, retrieve the url's reputation by calling 
 * Classifications.getRep(String url, boolean refresh).
 *
 * getRepFromFile() should return a HashMap<String,Integer> populated with
 * the last requested reputation of the url in the file.
 *  
 * Classifications is a class provided by us and packaged up in Problem7Helper.
 * Before using the Classifications class you need to call the initializer for it
 *	Method signature: public static void init()
 * The first call to init() will initialize the class, all subsequent calls to init() are accepted
 * but do nothing.
 *
 * To recieve the reputations of a url call Classifications.getRep().
 *	Method signature: public static int getRep(String url, boolean refresh)
 *
 * 
 * getRep() returns the same reputation for a url 5 times before updating to a new reputation.
 *
 * example:
 *
 * 1.  getRep(test.com,false) = 65
 * 2.  getRep(test.com,false) = 65
 * 3.  getRep(test.com,false) = 65
 * 4.  getRep(test.com,false) = 65
 * 5.  getRep(test.com,false) = 65
 * 6.  getRep(test.com,false) = 70
 * 7.  getRep(test.com,false) = 70
 * 8.  getRep(test.com,false) = 70
 * 9.  getRep(test.com,false) = 70
 * 10. getRep(test.com,false) = 70
 * 11. getRep(test.com,false) = 86
 * ...
 *
 * If refresh is set to true it will let getRep() know that you want it to start
 * returning the new reputation
 *
 * 1. getRep(test.com,false) = 65
 * 2. getRep(test.com,false) = 65
 * 3. getRep(test.com,true) = 80
 * 4. getRep(test.com,false) = 80
 * 5. getRep(test.com,false) = 80
 * 6. getRep(test.com,false) = 80
 * 7. getRep(test.com,false) = 80
 * 8. getRep(test.com,false) = 90
 * 9. getRep(test.com,false) = 90
 * ...
 *
 * If a url is not found the reputation is -1.
 * If a reputation was not found for a url it will never be found.
 *
 * The top 20000 urls (domains) in the DB table url_rep will return a reputation when called with getRep().
 *
 * Also add a routing call in for this call with extension /problem7?filePath=
 * The result (String[]) should be stored into a variable named urlReps.
 * The whole response should be a json string.
 *
 * Note: Classifications getRep() is implemented to run slowly.
 *
 */

import java.util.*;

public class Problem7
{
	public static HashMap<String,Integer> getRepFromFile(String filePath)
	{
		return new HashMap<String,Integer>();
	}
}
