package com.webroothackathon.app;
import com.webroothackathon.app.problem0.*;
import com.webroothackathon.app.problem1.*;
import com.webroothackathon.app.problem2.*;
import com.webroothackathon.app.problem3.*;
import com.webroothackathon.app.problem4.*;
import com.webroothackathon.app.problem5.*;
import com.webroothackathon.app.problem6.*;
import com.webroothackathon.app.problem8.*;
import com.webroothackathon.app.problem9.*;
import com.webroothackathon.app.problem10.*;
import com.webroothackathon.app.problem11.*;
import com.webroothackathon.app.problem12.*;
import com.webroothackathon.app.problem13.*;
import com.webroothackathon.app.problem15.*;
import com.webroothackathon.app.problem16.*;

import static spark.Spark.*;

import java.util.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Webroot 2017 Hackathon API
 * 
 * This is the main entry point for your API. Most have been properly 
 * implemented for you. The few problems that you have to modify or 
 * implement yourself are the following:
 *
 * Problem 16
 * Problem 17
 * Problem 18
 * Problem 20
 */
public class App 
{
    // Application entry point
    public static void main( String[] args )
    {
        get("/", (req, res) -> {
            return "Hello from Webroot Hackathon 2017!\n";
        });

        post("/problem0", (req, res) -> {
        
            String body = req.body();

            // Leverage Gson to easily convert Json strings to objects and back
            Gson gson = new Gson(); 
            com.webroothackathon.app.problem0.Request request = 
                gson.fromJson(body, com.webroothackathon.app.problem0.Request.class);
            
            long sum = Problem0.Add(request.first, request.second);

            com.webroothackathon.app.problem0.Response response =
                new com.webroothackathon.app.problem0.Response();
            response.sum = sum;
            return gson.toJson(response);
        });

        post("/problem1", (req, res) -> {
        
            String body = req.body();

            // Leverage Gson to easily convert Json strings to objects and back
            Gson gson = new Gson(); 
            com.webroothackathon.app.problem1.Request request = 
                gson.fromJson(body, com.webroothackathon.app.problem1.Request.class);
            
            ArrayList<UrlCatItem> urls = new ArrayList<UrlCatItem>();
            urls.addAll(request.urlItems);
            ArrayList<UrlCatItem> matchingUrls = new ArrayList<UrlCatItem>();

            UrlCatItem[] urlsArr = new UrlCatItem[urls.size()];
            urlsArr = urls.toArray(urlsArr);
            IntPair catRep = Problem1.getLowestCatRep(urlsArr);

            com.webroothackathon.app.problem1.Response response =
                new com.webroothackathon.app.problem1.Response();
            response.category = catRep.first;
            response.reputation = catRep.second;
            return gson.toJson(response);
        });

        post("/problem2", (req, res) -> {

            String body = req.body();

            // Leverage Gson to easily convert Json strings to objects and back
            Gson gson = new Gson(); 
            com.webroothackathon.app.problem2.Request request = 
                gson.fromJson(body, com.webroothackathon.app.problem2.Request.class);
            
            ArrayList<UrlCatItem> urls = new ArrayList<UrlCatItem>();
            urls.addAll(request.urlItems);
            ArrayList<UrlCatItem> matchingUrls = new ArrayList<UrlCatItem>();
            String s = request.stringToFind;

            Problem2 p2 = new Problem2();
            p2.getMatchingUrls(urls, s, matchingUrls);

            com.webroothackathon.app.problem2.Response response =
                new com.webroothackathon.app.problem2.Response();
            response.urlItems = new ArrayList<UrlCatItem>(matchingUrls);
            return gson.toJson(response);
        });

        // Request
        // {
        //  "set" : [],
        //  "startInt" : 1,
        //  "endInt" : 8
        // }
        post("/problem3", (req, res) -> {

            String body = req.body();

            // Leverage Gson to easily convert Json strings to objects and back
            Gson gson = new Gson(); 
            com.webroothackathon.app.problem3.Request request = 
                gson.fromJson(body, com.webroothackathon.app.problem3.Request.class);
           
            int missingInt = -1; 
            if (request.startInt == 1) {
                missingInt = Problem3.findMissingInteger(request.set, 
                    request.endInt);
            }
            else {
                missingInt = Problem3.findMissingInteger(request.set, 
                    request.startInt, 
                    request.endInt);
            }

            com.webroothackathon.app.problem3.Response response =
                new com.webroothackathon.app.problem3.Response();
            response.missingInt = missingInt;
            return gson.toJson(response);
        });

        get("/problem4", (req, res) -> {
        
            int size = Integer.parseInt(req.queryParams("snakeSize"));
            
            String snake = Problem4.getSleepingSnake(size);

            com.webroothackathon.app.problem4.Response response =
                new com.webroothackathon.app.problem4.Response();
            response.snake = snake;
            GsonBuilder builder = new GsonBuilder();
            builder.disableHtmlEscaping();
            Gson gson = builder.create();
            return gson.toJson(response);
        });

        post("/problem5", (req, res) -> {
        
            String body = req.body();
            // Leverage Gson to easily convert Json strings to objects and back
            Gson gson = new Gson(); 
            com.webroothackathon.app.problem5.Request request = 
                gson.fromJson(body, com.webroothackathon.app.problem5.Request.class);
            
            ArrayList<String> ips = new ArrayList<String>();
            ips.addAll(request.ips);

            Problem5 p5 = new Problem5();
            p5.initializeIpRanges("./src/main/java/com/webroothackathon/app/problem5/200.txt");

            HashSet<String> matches = new HashSet<String>();
            for (int i = 0; i < ips.size(); i++) {
                ArrayList<String> ranges = p5.getIpRanges(ips.get(i));
                for (int j = 0; j < ranges.size(); j++) {
                    matches.add(ranges.get(j));
                }
            }

            com.webroothackathon.app.problem5.Response response =
                new com.webroothackathon.app.problem5.Response();
            response.ranges = new ArrayList<String>(matches);
            return gson.toJson(response);
        });

	//problem 6
	get("/problem6", (req, res) -> {
        
            com.webroothackathon.app.problem6.Response response =
                new com.webroothackathon.app.problem6.Response();

            response.topUrlsPerCat = Problem6.getTopUrlPerCat();
            GsonBuilder builder = new GsonBuilder();
            builder.disableHtmlEscaping();
            Gson gson = builder.create();
            return gson.toJson(response);
        });

	//	problem 8
	post("/problem8", (req, res) -> {
            String body = req.body();
            Gson gson = new Gson();

            com.webroothackathon.app.problem8.Request request =
                gson.fromJson(body, com.webroothackathon.app.problem8.Request.class);
            com.webroothackathon.app.problem8.Response response =
                new com.webroothackathon.app.problem8.Response();
            response.circlesToCross = 
                Problem8.CrossCountry(request.x_coords, request.y_coords, request.radii,
			request.start_x, request.start_y, request.end_x, request.end_y);
            
            return gson.toJson(response);
        });

	//	problem 9
	get("/problem9", (req, res) -> {
        
            com.webroothackathon.app.problem9.Response response =
                new com.webroothackathon.app.problem9.Response();
            response.maximumCounter = Problem9.maximumCounter();

            GsonBuilder builder = new GsonBuilder();
            builder.disableHtmlEscaping();
            Gson gson = builder.create();
            return gson.toJson(response);
        });

	//	problem 10
        post("/problem10", (req, res) -> {
            String body = req.body();
            Gson gson = new Gson();

            com.webroothackathon.app.problem10.Request request =
                gson.fromJson(body, com.webroothackathon.app.problem10.Request.class);
            com.webroothackathon.app.problem10.Response response =
                new com.webroothackathon.app.problem10.Response();
            response.attemptedPins = 
                Problem10.GetPins(request.observedPin);
            
            return gson.toJson(response);
        });

        //	problem 11
        get("/problem11", (req, res) -> {
            
                com.webroothackathon.app.problem11.Response response =
                    new com.webroothackathon.app.problem11.Response();
                response.synchronizedOrder = Problem11.checkSynchronized();

                GsonBuilder builder = new GsonBuilder();
                builder.disableHtmlEscaping();
                Gson gson = builder.create();
                return gson.toJson(response);
            });

        // problem 12
        post("/problem12", (req, res) -> {

            String body = req.body();

            Gson gson = new Gson();
            com.webroothackathon.app.problem12.Request request =
                    gson.fromJson(body, com.webroothackathon.app.problem12.Request.class);

            com.webroothackathon.app.problem12.Response response =
                    new com.webroothackathon.app.problem12.Response();
            response.urls = Problem12.ValidateUrls(request.urls);;
            return gson.toJson(response);
        });

        //	problem 13
        get("/problem13", (req, res) -> {
            
                com.webroothackathon.app.problem13.Response response =
                    new com.webroothackathon.app.problem13.Response();
                response.name = Problem13.getName();

                GsonBuilder builder = new GsonBuilder();
                builder.disableHtmlEscaping();
                Gson gson = builder.create();
                return gson.toJson(response);
            });

        //	problem 15
        get("/problem15", (req, res) -> {
            
                com.webroothackathon.app.problem15.Response response =
                    new com.webroothackathon.app.problem15.Response();
                response.time = Problem15.produceAndConsume();

                GsonBuilder builder = new GsonBuilder();
                builder.disableHtmlEscaping();
                Gson gson = builder.create();
                return gson.toJson(response);
        });

        /*
         * Problem 16
         *
         * Expect requests to come in the following JSON format:
         *
         * {
         *      "urlItems" : [
         *          {
         *              "url" : "yoursampleurl.com",
         *              "reputation" : 16,
         *              "category" : "unknown"
         *          },
         *          {
         *              "url" : "yourothersampleurl.com",
         *              "reputation" : 42,
         *              "category" : "shopping"
         *          }
         *      ]
         * }
         *
         * You will get a variable number of url items. Use the UrlCatItem 
         * object from problem 1.
         *
         * Return "";
         */
        post("/problem16", (req, res) -> {
            return "";    
        });

        /*
         * Problem 17
         *
         * Expect requests to come in the following JSON format:
         *
         * {
         *      "urls" : [
         *          "http://www.yoursampleurl.com",
         *          "http://www.yourothersampleurl.com",
         *          "http://www.andanothersampleurl.com",
         *          "http://www.andagainsampleurl.com",
         *          "http://www.lastonesampleurl.com",
         *      ]
         * }
         *
         * You will get a variable number of urls.  
         *
         * Return "";
         */
        post("/problem17", (req, res) -> {

            // Iterate over your urls and call Problem17.parseUrl here.

            return ""; 
        }); 

        /*
         * There is no input for problem 18. Return "".
         *
         */
        get("/problem18", (req, res) -> {
            return "";
        });
    }
}
