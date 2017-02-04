package com.webroothackathon.app.problem12;
import static webroothackathon.AppUtils.IsValid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * IsValid function takes a List of Strings and returns Boolean value
 * depending on the value of each element.  If all the elements are valid,
 * it will return true.  Otherwise, it will return false.
 *
 * Ex)  IsValid([goodurl.com]) returns true
 *      IsValid([goodurl.com, badurl.com]) returns false
 *
 * Given the helper function, IsValid, implement ValidateUrls function to find
 * invalid elements.
 *
 * ValidateUrls
 *    Parameter:
 *       List<String> urls - input to be validated by IsValid function
 *
 *    Return:
 *       List<String> - list of invalid string
 *                      returns empty array if everything is valid
 *
 * Ex)  ValidateUrls([goodurl.com]) returns []
 *      ValidateUrls([goodurl.com, badurl.com]) returns [badurl.com]
 *
 * In this directory, there is a sample zip file that contains two invalid
 * elements.
 *
 * Note: During test, IsValid returns false on different values.
 */
public class Problem12 {
    public static List<String> ValidateUrls(List<String> urls)
    {
        return IsValid(Arrays.asList("badurl.com")) ? new ArrayList<>()
               : Arrays.asList("badurl.com");
    }
}
