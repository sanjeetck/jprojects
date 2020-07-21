package com.db;

import com.db.model.DBDate;
import com.db.validator.Validator;
import com.db.view.DatePresentation;
import com.db.view.DayOfWeekPresentation;
import com.db.view.TimePresentation;

/**
 * App validates the string based date and displays
 *
 */
public class DBDateApp
{
    /*
    should be autowired if used with spring
    * */
    Validator validator;
    DatePresentation datePresentation;
    TimePresentation timePresentation;
    DayOfWeekPresentation dayOfWeekPresentation;

    public DBDateApp(Validator validator, DatePresentation datePresentation,
                     TimePresentation timePresentation, DayOfWeekPresentation dayOfWeekPresentation) {
        this.validator = validator;
        this.datePresentation = datePresentation;
        this.timePresentation = timePresentation;
        this.dayOfWeekPresentation = dayOfWeekPresentation;
    }

    public void parse(String strDate) {
        boolean validStatus = validator.validateDate(strDate);
        if (validStatus) {
            DBDate dbDate = new DBDate(strDate);
            System.out.println("Valid Date: " + datePresentation.displayDate(dbDate));
            System.out.println("Valid Time: " + timePresentation.displayTime(dbDate));
            System.out.println("Day of Week: " + dayOfWeekPresentation.displayDayOfWeek(dbDate));
        }else {
            System.out.println("Invalid Date format");
        }
    }


    public static void main(String args[]) {
        Validator validator = new Validator();
        DatePresentation dp = new DatePresentation();
        TimePresentation tp = new TimePresentation();
        DayOfWeekPresentation dwp = new DayOfWeekPresentation();

        DBDateApp app = new DBDateApp(validator, dp,tp, dwp);
        app.parse("21-07-2020 11:35:49 Pm");
    }
}
