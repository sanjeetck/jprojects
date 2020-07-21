package com.db.util;

import java.util.HashMap;
import java.util.Map;

public class TimeUtil {

    public static Map<Integer, String> getHours() {
        return hours;
    }

    private static Map<Integer, String> hours = new HashMap<>();
    static {
        hours.put(1, "One");
        hours.put(2, "Two");
        hours.put(3, "Three");
        hours.put(4, "Four");
        hours.put(5, "Five");
        hours.put(6, "Six");
        hours.put(7, "Seven");
        hours.put(8, "Eight");
        hours.put(9, "Nine");
        hours.put(10, "Ten");
        hours.put(11, "Eleven");
        hours.put(12, "Twelve");
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
        //tensValues.put(10, "Hundred");
    };

    public static Map<Integer, String> getUnitValues() {
        return unitValues;
    }

    private static Map<Integer, String> unitValues  = new HashMap<>();
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


}
