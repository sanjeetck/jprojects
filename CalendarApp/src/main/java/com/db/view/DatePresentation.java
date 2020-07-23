package com.db.view;

import com.db.model.DBDate;
import com.db.util.DateUtil;

public class DatePresentation {
    DBDate dbDate;

    public String getDay(DBDate dbDate) {
        return dbDate.getDay() + DateUtil.getDayMap().getOrDefault(dbDate.getDay()%10, "th");
    }

    public String getMonth(DBDate dbDate) {
        return DateUtil.getMonthMap().get(dbDate.getMonth());
    }

    public String getYear(DBDate dbDate) {
        int upperHalf = dbDate.getYear() / 100;
        int lowerHalf = dbDate.getYear() % 100;

        String lowerHalfString = decade(lowerHalf);
        return decade(upperHalf) + " " +  (lowerHalfString == null ? "Hundred" : lowerHalfString);
    }

    private String decade(int value) {
        String strPresentation;

        if (value < 20) {
            if (value < 10) {
                strPresentation = DateUtil.getUnitValues().get(value);
            }else {
                switch(value) {
                    case 10:
                        strPresentation = "Ten";
                        break;
                    case 11:
                        strPresentation = "Eleven";
                        break;
                    case 12:
                        strPresentation = "Twelve";
                        break;
                    default:  {
                        String partDecade = DateUtil.getTensValues().get(value % 10);
                        strPresentation = partDecade.substring(0, partDecade.length()-1) + "een";
                        break;
                    }
                }
            }
        } else {
            if (value % 10 == 0) {
                strPresentation = DateUtil.getTensValues().get(value / 10);
            } else {
                String yearTop = DateUtil.getTensValues().get(value / 10);
                String yearBottom = DateUtil.getUnitValues().get(value % 10);
                strPresentation = yearTop + " " + yearBottom;
            }
        }

        return strPresentation;
    }

    public String displayDate(DBDate dbDate) {
        String day = getDay(dbDate);
        String month = getMonth(dbDate);
        String year = getYear(dbDate);
        return day + " " + month + " " + year;
    }
}
