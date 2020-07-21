package com.db.view;

import com.db.model.DBDate;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TimePresentationTest {
    TimePresentation app;

    @Before
    public void setUp() throws Exception {
        app  = new TimePresentation();
    }

    @Test
    public void testHourLessThan10() {
        DBDate date = new DBDate("23-05-2011 06:05:49 am");
        assertTrue("Equals", (app.getHours(date)).equals("Six Hours"));
    }

    @Test
    public void testHourGreaterThan9() {
        DBDate date = new DBDate("23-05-2011 11:05:49 am");
        assertTrue("Equals", (app.getHours(date)).equals("Eleven Hours"));
    }

    @Test
    public void testMinutesLessThan10() {
        DBDate date = new DBDate("23-05-2011 06:05:49 am");
        assertTrue("Equals", (app.getMinutes(date)).equals("Five Minutes"));
    }

    @Test
    public void testMinutesLessThan15() {
        DBDate date = new DBDate("23-05-2011 06:13:49 am");
        assertTrue("Equals", (app.getMinutes(date)).equals("Thirteen Minutes"));
    }

    @Test
    public void testMinutesGreaterThan20() {
        DBDate date = new DBDate("23-05-2011 06:23:49 am");
        assertTrue("Equals", (app.getMinutes(date)).equals("Twenty Three Minutes"));
    }

    @Test
    public void testSecondsGreaterThan20() {
        DBDate date = new DBDate("23-05-2011 06:05:49 am");
        assertTrue("Equals", (app.getSeconds(date)).equals("Forty Nine Seconds"));
    }

    @Test
    public void testAM() {
        DBDate date = new DBDate("23-05-2011 06:05:49 am");
        assertTrue("Equals", (app.getAMPM(date)).equals("Morning"));
    }

    @Test
    public void testTime() {
        DBDate date = new DBDate("23-05-1911 06:05:49 am");
        assertTrue("Equals", (app.displayTime(date)).equals("Six Hours Five Minutes Forty Nine Seconds Morning"));
    }
}
