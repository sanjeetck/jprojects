package com.db.view;

import com.db.model.DBDate;
import com.db.util.DateUtil;
import com.db.util.TimeUtil;

public class TimePresentation {
    DBDate dbDate;

    public String getHours(DBDate dbDate) {
        //TODO:: Should 1 and 0 be Hour?
        return TimeUtil.getHours().get(dbDate.getHour()) + " Hours";
    }

    public String getMinutes(DBDate dbDate) {
        return digitsToStrDisplay(dbDate.getMinute()) + " Minutes";
    }

    public String getSeconds(DBDate dbDate) {
        return digitsToStrDisplay(dbDate.getSecond()) + " Seconds";
    }

    public String getAMPM(DBDate dbDate) {
        return dbDate.isMorning() ? "Morning" : "Evening";
    }

    private String digitsToStrDisplay(int value) {
        String strValue = null;
        if (value < 20) {
            if (value < 10) {
                strValue = TimeUtil.getUnitValues().get(value);
            }else {
                switch(value) {
                    case 10:
                        strValue = "Ten";
                        break;
                    case 11:
                        strValue = "Eleven";
                        break;
                    case 12:
                        strValue = "Twelve";
                        break;
                    default:  {
                        String partDecade = DateUtil.getTensValues().get(value % 10);
                        strValue = partDecade.substring(0, partDecade.length()-1) + "een";
                        break;
                    }
                }
            }
        } else {
            if (value % 10 == 0) {
                strValue = TimeUtil.getTensValues().get(value / 10);
            } else {
                String topValue = TimeUtil.getTensValues().get(value / 10);
                String bottomValue = TimeUtil.getUnitValues().get(value % 10);
                strValue = topValue + " " + bottomValue;
            }
        }

        return strValue;
    }

    public String displayTime(DBDate dbDate) {
        String hours = getHours(dbDate);
        String minutes = getMinutes(dbDate);
        String seconds = getSeconds(dbDate);
        return hours + " " + minutes + " " + seconds + " " + getAMPM(dbDate);
    }
}
