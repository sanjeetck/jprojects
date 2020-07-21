package com.db.validator;

import com.db.model.DBDate;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Unit test for Validator.
 */
public class ValidatorTest {
    Validator validate = new Validator();

    @Test
    public void testInvalidDate() {
        String strDate = "23-01-190 06:05:49 am";
        assertTrue("Invalid", validate.validateDate(strDate) == false);
    }

    @Test
    public void testValidDate() {
        String strDate = "23-01-1900 06:05:49 am";
        assertTrue("Valid", validate.validateDate(strDate) == true);
    }
}
