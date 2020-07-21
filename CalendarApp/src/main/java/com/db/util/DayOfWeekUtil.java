package com.db.util;

import java.util.HashMap;
import java.util.Map;

public class DayOfWeekUtil {

    public static Map<Integer, String> getDayOfWeekMap() {
        return dayOfWeekMap;
    }

    private static Map<Integer, String> dayOfWeekMap = new HashMap<>();
    static {
        dayOfWeekMap.put(1, "Sunday");
        dayOfWeekMap.put(2, "Monday");
        dayOfWeekMap.put(3, "Tuesday");
        dayOfWeekMap.put(4, "Wednesday");
        dayOfWeekMap.put(5, "Thursday");
        dayOfWeekMap.put(6, "Friday");
        dayOfWeekMap.put(7, "Saturday");
    }

    public static Map<Integer, Integer> getMonthKeyValue() {
        return monthKeyValue;
    }

    private static Map<Integer, Integer> monthKeyValue = new HashMap<>();
    static {
        monthKeyValue.put(1, 1);
        monthKeyValue.put(2, 4);
        monthKeyValue.put(3, 4);
        monthKeyValue.put(4, 0);
        monthKeyValue.put(5, 2);
        monthKeyValue.put(6, 5);
        monthKeyValue.put(7, 0);
        monthKeyValue.put(8, 3);
        monthKeyValue.put(9, 6);
        monthKeyValue.put(10, 1);
        monthKeyValue.put(11, 4);
        monthKeyValue.put(12, 6);
    };

    public static Map<Integer, Integer> getYearOffset() {
        return yearOffset;
    }
    private static Map<Integer, Integer> yearOffset = new HashMap<>();
    static {
        yearOffset.put(19, 0);
        yearOffset.put(20, 6);
        yearOffset.put(17, 4);
        yearOffset.put(18, 2);
    };
}
