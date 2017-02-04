package com.webroothackathon.app.problem16;

import com.webroothackathon.app.problem1.UrlCatItem;

import java.util.ArrayList;
import org.json.JSONObject;
import org.json.JSONArray;

/*
To answer the questions, please replace the string "********YOUR QUERY STRING" 
in functions with your own query strings. 
    Note: 
    1). You can add your own functions 
    2). Please do NOT change the function signatures.


QUESTION #1 Create Table analysis_queue
    in member function: void createTable(DbInterface dbop)
    schema
    +-------------+--------------+------+-----+-------------------+-------+
    | Field       | Type         | Null | Key | Default           | Extra |
    +-------------+--------------+------+-----+-------------------+-------+
    | url         | varchar(700) | NO   | PRI | NULL              |       |
    | category    | int(11)      | YES  |     | -1                |       |
    | reputation  | int(11)      | YES  |     | 0                 |       |
    | insert_date | timestamp    | NO   |     | CURRENT_TIMESTAMP |       |
    +-------------+--------------+------+-----+-------------------+-------+


QUESTION #2 Add Records into analysis_queue
    in member function: void insertRecords(DbInterface dbop)
    add following records:
    {"url": "http://www.microsoft.com",   "category": 4, "reputation": 30}
    {"url": "http://www.paypal.com",      "category": 3, "reputation": 40}
    {"url": "http://www.yahoo.com",       "category": 1, "reputation": 30}
    {"url": "http://www.ucsd.edu",        "category": 2, "reputation": 10}
    {"url": "http://www.google.com",      "category": 1, "reputation": 20}
    {"url": "http://www.facebook.com",    "category": 1, "reputation": 15}
    {"url": "http://www.amazon.com",      "category": 4, "reputation": 20}
    {"url": "http://www.webroot.com",     "category": 5, "reputation": 20}
    {"url": "http://www.ebay.com",        "category": 3, "reputation": 45}
    {"url": "http://www.brightcloud.com", "category": 5, "reputation": 20}
    {"url": "http://www.uber.com",        "category": 6, "reputation": 25}
    {"url": "http://www.airbnb.com",      "category": 6, "reputation": 35}
    {"url": "http://www.apple.com",       "category": 3, "reputation": 30}


QUESTION #3 Update Records in analysis_queue
    in member function: void updateTable(DbInterface dbop)
    change the reputation of "http://www.webroot.com", 
    "http://www.brightcloud.com" and "http://www.ucsd.edu" to 0.


QUESTION #4 Delete Record in analysis_queue
    in member function: void deleteRecords(DbInterface dbop)
    delete the record with url: "http://www.yahoo.com".


QUESTION #5 Query Table analysis_queue
    in member function: void queryTable(DbInterface dbop)
    find all the urls with reputation > 10 order by url.
*/


public class Problem16 {
    private DbInterface dbop = new DbInterface();

//Create Table
    public static void createTable(DbInterface dbop) throws Exception{
        String sql_str = "********YOUR QUERY STRING";
        JSONArray jsonArray =  dbop.executeSQL(sql_str);
        boolean success = jsonArray.getJSONObject(0).getBoolean("Success");

        if (success){
            System.out.println("Table Created");
        } else {
            System.out.println(jsonArray.getJSONObject(1).getString("Error"));
        }
    }


//Insert Records
    public static void insertRecords(DbInterface dbop) throws Exception{
        ArrayList<String> sql_arr = new ArrayList<String>();
        sql_arr.add("********YOUR QUERY STRING");

        for (String sql_str: sql_arr){
            JSONArray jsonArray = dbop.executeSQL(sql_str);
            boolean success = jsonArray.getJSONObject(0).getBoolean("Success");
            if (success){
                System.out.println("Records Inserted");
            } else {
                System.out.println(jsonArray.getJSONObject(1).getString("Error"));
            }
        }
    }


//Update Table
    public static void updateTable(DbInterface dbop) throws Exception{
        String sql_str = "********YOUR QUERY STRING";
        JSONArray jsonArray = dbop.executeSQL(sql_str);
        boolean success = jsonArray.getJSONObject(0).getBoolean("Success");

        if (success){
            System.out.println("Table Updated");
        } else {
            System.out.println(jsonArray.getJSONObject(1).getString("Error"));
        }
    }


//Delete Records
    public static void deleteRecords(DbInterface dbop) throws Exception{
        String sql_str = "********YOUR QUERY STRING";
        JSONArray jsonArray = dbop.executeSQL(sql_str);
        boolean success = jsonArray.getJSONObject(0).getBoolean("Success");

        if (success){
            System.out.println("Record Deleted");
        } else {
            System.out.println(jsonArray.getJSONObject(1).getString("Error"));
        }
    }


//Query Table
    public static JSONArray queryTable(DbInterface dbop) throws Exception{
        String sql_str = "********YOUR QUERY STRING";
        JSONArray jsonArray = dbop.executeSQL(sql_str);
        boolean success = jsonArray.getJSONObject(0).getBoolean("Success");

        if (success){
            System.out.println("Query Success");
            for (int i = 2; i < jsonArray.length(); i++){
                System.out.println("---------------------------------------------------");
                System.out.println(jsonArray.getJSONObject(i).toString());
            }
        } else {
            System.out.println(jsonArray.getJSONObject(1).getString("Error"));
        }
        return jsonArray;
    }
}
