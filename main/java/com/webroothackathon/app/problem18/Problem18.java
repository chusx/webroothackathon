package com.webroothackathon.app.problem18;

import com.webroothackathon.app.problem17.Problem17;
import com.webroothackathon.app.problem16.DbInterface;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;
import org.json.JSONObject;
import org.json.JSONArray;

/*
Purpose: read ~100K phishing urls from 100K_url_list.txt file, 
         the file has 1 url per line. Analyze these urls, 
         and store features into analysis_data database.
    Note: 
    1). This problem follows problem17, you need to finish problem17 first.
    2). You can add your own functions.
    3). Please do NOT changethe function signatures.
    4). This problem is evaluated by both accuracy and running time.
   

same table analysis_data created in problem 17 to use.
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
    | insert_date | timestamp    | NO   |     | CURRENT_TIMESTAMP |       |
    +-------------+--------------+------+-----+-------------------+-------+


QUESTION#1: fix bugs in the problem, to make sure all the urls are correct processed.

QUESTION#2: if your data is correct, can you work out effective ways to improve the running performance?
*/


public class Problem18 {
    private ExecutorService threadPool = null;
    private DbInterface dbop = null;
    private Problem17 parser = new Problem17();

    //Constructor
    public Problem18(int nThreads, DbInterface dbop){
        this.threadPool = Executors.newFixedThreadPool(nThreads);
        this.dbop = dbop;
    }

    //Read Urls from file, submit to thread pool for analysis.
    public void analyzeUrls(){
        BufferedReader inFile = null;
        try{
            inFile = new BufferedReader(new FileReader("./100K_url_list.txt"));
            String url = null;
            while ((url = inFile.readLine()) != null){
                Future future = threadPool.submit(new Analyzer(url));
            }

            inFile.close();
            threadPool.shutdownNow();
        } catch (IOException e){
            try {
                inFile.close();
            } catch (IOException err){
                err.printStackTrace();
            }
            threadPool.shutdownNow();
        }
    }

    //Worker of each Thread
    private class Analyzer implements Runnable{
        private String url;

        //Constructor
        public Analyzer(String url){
            this.url = url;
        }

        public void run(){
            try{
                parser.parseUrl(url);           
            } catch (Exception err){
                err.printStackTrace();
            }
        }
    }

    public static void ProcessUrls() throws Exception{
        final int NUM_OF_THREADS = 2;

        DbInterface dbop = new DbInterface();
        JSONArray jsonArray = dbop.executeSQL("DELETE FROM analysis_data");
        Problem18 processUrls = new Problem18(NUM_OF_THREADS, dbop);
        processUrls.analyzeUrls();
    }
}
