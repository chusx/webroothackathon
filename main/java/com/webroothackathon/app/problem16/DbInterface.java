package com.webroothackathon.app.problem16;

import java.sql.*; 
import java.io.*;
import org.json.JSONObject;
import org.json.JSONArray;

/*
   * Class DbInterface provides JDBC interface for MySQL database operations.
   * Please do NOT change the existing function signatures.
   * You can add your own functions.
   * public member function executeSQL:
     input: sql query strings
     output: JSONArray Object in the following format 
             [{"Success": "true/false"}, {"Error": error_info}, {data1 if any}, {data2 if any}...]
*/

public class DbInterface{
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String db_url = "jdbc:mysql://localhost/hackathon?useSSL=false";
    static final String username = "hackathonuser";
    static final String password = "]D4mYzsu?Yz5t+u4AP";

    //Conduct query operations
    public static JSONArray executeSQL(String sql_str) throws Exception{
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        JSONArray jsonArray = new JSONArray();
        JSONObject statusJSON = new JSONObject();
        JSONObject errorJSON = new JSONObject();
        statusJSON.put("Success", "true");
        errorJSON.put("Error", "");
        jsonArray.put(statusJSON);
        jsonArray.put(errorJSON);
        String errorInfo = "";

        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(db_url, username, password);
            stmt = conn.createStatement();
            String query_str = sql_str.trim().toLowerCase();
            if (query_str.startsWith("select") && query_str.contains("into outfile")){
                stmt.execute(sql_str);
            } else if (query_str.startsWith("select") || query_str.startsWith("show") || query_str.startsWith("desc")){
                rs = stmt.executeQuery(sql_str);
                while(rs.next()){
                    int num_rows = rs.getMetaData().getColumnCount();
                    JSONObject obj = new JSONObject();
                    for (int i = 1; i <= num_rows; i++){
                        obj.put(rs.getMetaData().getColumnLabel(i).toLowerCase(), rs.getObject(i));
                    }
                    jsonArray.put(obj);
                }
            } else {
                stmt.executeUpdate(sql_str);
            }
        } catch (SQLException se){
            jsonArray.getJSONObject(0).put("Success", "false");
            StringWriter sw = new StringWriter();
            se.printStackTrace(new PrintWriter(sw));
            errorInfo += "\n\n====================SQL Exception====================\n\n" + sw.toString(); 
        } catch (Exception e){
            jsonArray.getJSONObject(0).put("Success", "false");
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            errorInfo += "\n\n====================Exception====================\n\n" + sw.toString(); 
        } finally {
            try{
                if (conn != null){
                    conn.close();
                }
            } catch(SQLException se){
                jsonArray.getJSONObject(0).put("Success", "false");
                StringWriter sw = new StringWriter();
                se.printStackTrace(new PrintWriter(sw));
                errorInfo += "\n\n====================SQL Exception====================\n\n" + sw.toString(); 
            }
            jsonArray.getJSONObject(1).put("Error", errorInfo);
            return jsonArray;
        }
    }
}
