package com.jumia.phone.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author GhofranAbdelwahab
 * @Date 23th Sep 2021
 **/
public class StringUtils {

    public static List<String> getStringListFromString(String str) {
        try {
            var values = str.split(",");
            return Arrays.asList(values);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ArrayList<>();
        }
    }

    public static List<Integer> getIntegerListFromString(String str) {
        try {
            var values = str.split(",");
            var ans = new ArrayList<Integer>();
            for (String value : values) {
                ans.add(Integer.valueOf(value));
            }
            return ans;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ArrayList<>();
        }
    }

    public static List<Double> getDoubleListFromString(String str) {
        try {
            var values = str.split(",");
            var ans = new ArrayList<Double>();
            for (String value : values) {
                ans.add(Double.valueOf(value));
            }
            return ans;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ArrayList<>();
        }
    }
    public static boolean isNotBlank(String str) {
        return  str != null && !str.isEmpty();
    }

    public static boolean isBlank(String str) {
        return  str == null || str.isEmpty();
    }
}
