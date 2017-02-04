package com.webroothackathon.app.problem5;

import java.util.*;
import java.io.*;

/*
 * Helper class
 */
public class FileReader {

    private String fileName;

    public FileReader(String fileName) {
        this.fileName = fileName;
    }

    public ArrayList<String> getAllIpRanges() {

        ArrayList<String> ranges = new ArrayList<String>();
        try (FileInputStream fis = new FileInputStream(fileName);
            BufferedReader br = 
                new BufferedReader(new InputStreamReader(fis))) {

            String line;
            while ((line = br.readLine()) != null) {
            
                ranges.add(line);
            }
        }
        catch (Exception ex) {
            System.out.println(ex.toString()); 
        }

        return ranges;
    }
}
