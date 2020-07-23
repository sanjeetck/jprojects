package com.db.view;

import com.db.model.DBDate;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DatePresentationTest {
    DatePresentation app;

    @Before
    public void setUp() throws Exception {
        app  = new DatePresentation();
    }

    @Test
    public void testDay() {
        DBDate date = new DBDate("23-05-2011 06:05:49 am");
        assertTrue("Equals", (app.getDay(date)).equals("23rd"));
    }

    @Test
    public void testMonth() {
        DBDate date = new DBDate("23-05-2011 06:05:49 am");
        assertTrue("Equals", (app.getMonth(date)).equals("May"));
    }

    @Test
    public void testYearGreaterThan2020() {
        DBDate date = new DBDate("23-05-2021 06:05:49 am");
        assertTrue("Equals", (app.getYear(date)).equals("Twenty Twenty One"));
    }

    @Test
    public void testYearGreaterThan2010() {
        DBDate date = new DBDate("23-05-2019 06:05:49 am");
        assertTrue("Equals", (app.getYear(date)).equals("Twenty Nineteen"));
    }

    @Test
    public void testYearLessThan2010() {
        DBDate date = new DBDate("23-05-2009 06:05:49 am");
        assertTrue("Equals", (app.getYear(date)).equals("Twenty Nine"));
    }

    @Test
    public void testYearLessThan2000() {
        DBDate date = new DBDate("23-05-1991 06:05:49 am");
        assertTrue("Equals", (app.getYear(date)).equals("Nineteen Ninety One"));
    }

    @Test
    public void testYearLessThan1915() {
        DBDate date = new DBDate("23-05-1911 06:05:49 am");
        assertTrue("Equals", (app.getYear(date)).equals("Nineteen Eleven"));
    }
    
    @Test
    public void testYearWithTwoZero() {
        DBDate date = new DBDate("23-05-2000 06:05:49 am");
        assertTrue("Equals", (app.getYear(date)).equals("Twenty Hundred"));
    }

    @Test
    public void testDate() {
        DBDate date = new DBDate("23-05-1911 06:05:49 am");
        assertTrue("Equals", (app.displayDate(date)).equals("23rd May Nineteen Eleven"));
    }

}
