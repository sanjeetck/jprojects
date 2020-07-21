package com.db.util;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateUtil {

    public static Map<Integer, String> getMonthMap() {
        return monthMap;
    }

    private static Map<Integer, String> monthMap = new HashMap<>();
    static {
        monthMap.put(1, "Jan");
        monthMap.put(2, "Feb");
        monthMap.put(3, "Mar");
        monthMap.put(4, "Apr");
        monthMap.put(5, "May");
        monthMap.put(6, "Jun");
        monthMap.put(7, "Jul");
        monthMap.put(8, "Aug");
        monthMap.put(9, "Sept");
        monthMap.put(10, "Oct");
        monthMap.put(11, "Nov");
        monthMap.put(12, "Dec");
    };

    public static Map<Integer, String> getDayMap() {
        return dayMap;
    }

    private static Map<Integer, String> dayMap = new HashMap<>();
    static{
        dayMap.put(1, "st");
        dayMap.put(2, "nd");
        dayMap.put(3, "rd");
    }



    public static Map<Integer, String> getUnitValues() {
        return unitValues;
    }

    private static Map<Integer, String> unitValues = new HashMap<>();
    static {
        unitValues.put(1, "One");
        unitValues.put(2, "Two");
        unitValues.put(3, "Three");
        unitValues.put(4, "Four");
        unitValues.put(5, "Five");
        unitValues.put(6, "Six");
        unitValues.put(7, "Seven");
        unitValues.put(8, "Eight");
        unitValues.put(9, "Nine");
    };

    public static Map<Integer, String> getTensValues() {
        return tensValues;
    }

    private static Map<Integer, String> tensValues = new HashMap<>();
    static {
        tensValues.put(1, "Ten");
        tensValues.put(2, "Twenty");
        tensValues.put(3, "Thirty");
        tensValues.put(4, "Forty");
        tensValues.put(5, "Fifty");
        tensValues.put(6, "Sixty");
        tensValues.put(7, "Seventy");
        tensValues.put(8, "Eighty");
        tensValues.put(9, "Ninety");
    };
}
