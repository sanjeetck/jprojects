package com.db.view;

import com.db.model.DBDate;
import com.db.util.DateUtil;
import com.db.util.DayOfWeekUtil;

/*
https://cs.uwaterloo.ca/~alopez-o/math-faq/node73.html
Here is a standard method suitable for mental computation:

lowerHalfYear : Take the last two digits of the year.
temp1 = Divide by 4, discarding any fraction.
temp1 = Add the day of the month.
Add the month's key value: JFM AMJ JAS OND 144 025 036 146
Subtract 1 for January or February of a leap year.
For a Gregorian date, add 0 for 1900's, 6 for 2000's, 4 for 1700's, 2 for 1800's;
for other years, add or subtract multiples of 400.
For a Julian date, add 1 for 1700's, and 1 for every additional century you go back.
Add the last two digits of the year.
Divide by 7 and take the remainder.
Now 1 is Sunday, the first day of the week, 2 is Monday, and so on.

OR
 */
public class DayOfWeekPresentation {
    DBDate dbDate;

   public String getDayOfWeek(DBDate dbDate) {
        int lowerHalfYear = dbDate.getYear() % 100;
        int temp1 = lowerHalfYear / 4;
        temp1 += dbDate.getDay();
        temp1 += DayOfWeekUtil.getMonthKeyValue().get(dbDate.getMonth());

        if (dbDate.getMonth() == 1 || (dbDate.getMonth() == 2 && dbDate.getYear() / 4 == 0)) {
            temp1 -= 1;
        }
        temp1 += DayOfWeekUtil.getYearOffset().getOrDefault(dbDate.getYear() / 100, 400);
        temp1 += lowerHalfYear;
        return DayOfWeekUtil.getDayOfWeekMap().get(temp1 % 7);
    }

    public String displayDayOfWeek(DBDate dbDate) {
        return getDayOfWeek(dbDate);
    }
}
