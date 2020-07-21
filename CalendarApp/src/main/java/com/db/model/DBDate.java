package com.db.model;

import com.db.util.DateUtil;

public class DBDate {
    private int year, month, day;
    private int hour, minute, second;
    private boolean morning;


    public DBDate(String strDate) {
        this.day = Integer.valueOf(strDate.substring(0,2));
        this.month = Integer.valueOf(strDate.substring(3,5));
        this.year = Integer.valueOf(strDate.substring(6,10));

        this.hour = Integer.valueOf(strDate.substring(11,13));
        this.minute = Integer.valueOf(strDate.substring(14,16));
        this.second = Integer.valueOf(strDate.substring(17,19));

        this.morning = strDate.substring(19,strDate.length())
                            .trim().equalsIgnoreCase("am") ? true : false;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }

    public boolean isMorning() {
        return morning;
    }
}
