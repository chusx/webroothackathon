package com.webroothackathon.app.problem17;

import com.webroothackathon.app.problem16.DbInterface;

import java.net.*;
import java.io.*;
import java.security.*;
import org.json.JSONObject;
import org.json.JSONArray;

/*
Purpose: analyze phishing urls, extract features and store information into database.
    Note:
    1). This problem follows problem16, you need to finish problem16 first.
    2). You can add your own functions.
    3). Please do NOT change the function signatures.


QUESTION#1: create table analysis_data in main function
    schema
    +-------------+--------------+------+-----+-------------------+-------+
    | Field       | Type         | Null | Key | Default           | Extra |
    +-------------+--------------+------+-----+-------------------+-------+
    | url         | varchar(700) | NO   | PRI | NULL              |       |
    | md5         | char(32)     | NO   |     | NULL              |       |
    | b_ip        | tinyint(1)   | YES  |     | 0                 |       |
    | n_at        | int(11)      | YES  |     | 0                 |       |
    | n_dash      | int(11)      | YES  |     | 0                 |       |
    | n_dot       | int(11)      | YES  |     | 0                 |       |
    | n_slash     | int(11)      | YES  |     | 0                 |       |
    | insert_time | timestamp    | NO   |     | CURRENT_TIMESTAMP |       |
    +-------------+--------------+------+-----+-------------------+-------+


QUESTION#2: Implement the code to parse the URL, and extract features from it
    example: http://www.subdomain.example.com/path1/path2/tmp.html?key1=val1&key2=val2#ref1
    --------------------------------------------
    protocal: http
    host: www.subdomain.example.com
    file: /path1/path2/tmp.html?key1=val1&key2=val2
    path: /path1/path2/tmp.html
    query: key1=val1&key2=val2
    ref: ref1

    1). md5(String): signature of the URL, hash it to MD5 string (already implemented).
    2). b_ip(boolean): the hostname is just an IP address?
    3). n_at(int): how many '@' in the query string?
    4). n_dash(int): how many '-' in the hostname?
    5). n_dot(int): how many '.' in the hostname?
    6). n_slash(int): how many '/' in the path?


QUESTION#3: Store analysized info into analysis_data
    in member function void parseUrl(String url)
    insert the record of analysized info.
*/

public class Problem17{

    public static void createTable() throws Exception{
        DbInterface dbop = new DbInterface();
        JSONArray jsonArray = dbop.executeSQL("********YOUR QUERY STRING");
        boolean success = jsonArray.getJSONObject(0).getBoolean("Success");
        if (!success){
            System.out.println(jsonArray.getJSONObject(1).getString("Error"));
        }
    }


    public static String hashMD5(String url) throws Exception{
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] byteStr = md.digest(url.getBytes());
        StringBuffer hexStr = new StringBuffer();
        for (int i = 0; i <= byteStr.length; i++){
            hexStr.append(Integer.toString((byteStr[i] & 0xff) + 0x100, 16).substring(1));
        }
        String md5 = hexStr.toString();

        return md5; 
    }


    public static void parseUrl(String url) throws Exception{
        DbInterface dbop = new DbInterface();

        URL urlObj = new URL(url);
        String md5 = hashMD5(url);
        boolean b_ip = false;
        int n_at = -1;
        int n_dash = -1;
        int n_dot = -1;
        int n_slash = -1;
        
        JSONArray jsonArray = dbop.executeSQL("********YOUR QUERY STRING");
        if (!jsonArray.getJSONObject(0).getBoolean("Success")){
            System.out.println(jsonArray.getJSONObject(1).getString("Error"));
        }
    }

    public static void readUrls(){
        BufferedReader inFile = null;
        try{
            inFile = new BufferedReader(new FileReader("./500_url_list.txt"));
            String line = null;
            while ((line = inFile.readLine()) != null){
                parseUrl(line);
            }
            inFile.close();
        } catch (Exception err){
            err.printStackTrace();
        }
    }
}
