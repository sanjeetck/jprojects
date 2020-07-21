package com.db.view;

import com.db.model.DBDate;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class DayOfTheWeekPresentationTest {
    DayOfWeekPresentation app;

    @Before
    public void setUp() throws Exception {
        app  = new DayOfWeekPresentation();
    }

    @Test
    public void testDay() {
        DBDate date = new DBDate("21-07-2020 06:05:49 am");
        assertTrue("Equals", (app.getDayOfWeek(date)).equals("Tuesday"));
    }

    @Test
    public void testDay2() {
        DBDate date = new DBDate("23-05-1980 06:05:49 am");
        assertTrue("Equals", (app.getDayOfWeek(date)).equals("Friday"));
    }


}
