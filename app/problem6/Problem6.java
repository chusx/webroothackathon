package com.webroothackathon.app.problem6;

/*
 * Complete the api call getTopUrlPerCat()
 *
 * This api gets the urls with the highest reputation for each category by
 * querying categories, url_rep, and url_cat tables.
 * If two urls have the same reputation then the one with the lower url_rep id
 * should be returned
 * The api should return the data in an ArrayList<StringPair> ordered in ascending
 * cateogry id. 
 * StringPair.first is the category's description.
 * StringPair.second is the domain with the highest reputation
 *
 * The schema of categories is:
 * id	description
 *
 * The schema of url_rep is:
 * id	domain	reputation
 *
 * The schema of url_cat is:
 * u_id (id from url_rep)	cat_id (id from categories)
 *
 * Note: If a category has no urls associated with it, the category should not be
 *       returned.
 *
 *       getTopUrlPerCat() should return the result within 30 secs
 */

import java.util.*;

public class Problem6 
{
	public static ArrayList<StringPair> getTopUrlPerCat()
	{
		return new ArrayList<StringPair>();
	}
}
