package com.db.model;

import com.db.model.DBDate;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit test for Model class DbDate.
 */
public class DbDateTest {
    DBDate date;

    @Test(expected = java.lang.NumberFormatException.class)
    public void testInvalidDate() {
        date = new DBDate("23-01-190 06:05:49 am");
    }

    @Test
    public void testValidDate() {
        date = new DBDate("23-01-1900 06:05:49 am");
        assertTrue("Equals", date != null);
    }

    @Test
    public void testValidDay() {
        date = new DBDate("23-01-1900 06:05:49 am");
        assertTrue("Equals", date.getDay() == 23);
    }

    @Test
    public void testValidMonth() {
        date = new DBDate("23-01-1900 06:05:49 am");
        assertTrue("Equals", date.getMonth() == 1);
    }


    @Test
    public void testValidYear() {
        date = new DBDate("23-01-1900 06:05:49 am");
        assertTrue("Equals", date.getYear() == 1900);
    }

    @Test
    public void testValidHour() {
        date = new DBDate("23-01-1900 06:05:49 am");
        assertTrue("Equals", date.getHour() == 6);
    }

    @Test
    public void testValidMin() {
        date = new DBDate("23-01-1900 06:05:49 am");
        assertTrue("Equals", date.getMinute() == 5);
    }

    @Test
    public void testValidSec() {
        date = new DBDate("23-01-1900 06:05:49 am");
        assertTrue("Equals", date.getSecond() == 49);
    }

    @Test
    public void testValidAM() {
        date = new DBDate("23-01-1900 06:05:49 am");
        assertTrue("Equals", date.isMorning() == true);
    }

    @Test
    public void testValidPM() {
        date = new DBDate("23-01-1900 06:05:49 Pm");
        assertTrue("Equals", date.isMorning() == false);
    }

}
