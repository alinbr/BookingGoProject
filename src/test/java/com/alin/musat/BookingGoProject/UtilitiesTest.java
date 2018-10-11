package com.alin.musat.BookingGoProject;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class UtilitiesTest {


    @Test
    public void testIsDoubleValid() {
        assertTrue(Utilities.isDouble("2.2"));
    }

    @Test
    public void testIsDoubleValidInteger() {
        assertTrue(Utilities.isDouble("2"));
    }

    @Test
    public void testIsDoubleValidDoubleEndsIn0() {
        assertTrue(Utilities.isDouble("2.0"));
    }

    @Test
    public void testIsDoubleEmptyText() {
        assertFalse(Utilities.isDouble(""));
    }

    @Test
    public void testIsDoubleText() {
        assertFalse(Utilities.isDouble("dfds"));
    }

    @Test
    public void testIsPositiveIntegerValid() {
        assertTrue(Utilities.isPositiveInteger("2"));
    }

    @Test
    public void testIsPositiveIntegerEmptyText() {
        assertFalse(Utilities.isPositiveInteger(""));
    }

    @Test
    public void testIsPositiveIntegerText() {
        assertFalse(Utilities.isPositiveInteger("asdas"));
    }

    @Test
    public void testIsPositiveIntegerNegativeInteger() {
        assertFalse(Utilities.isPositiveInteger("-2"));
    }

    @Test
    public void testValidateArgumentsValid() {
        String[] arguments = new String[] { "dave", "3.4",  "2" , "5", "2.3", "4" };
        assertTrue(Utilities.validateArguments(arguments));
    }


    @Test
    public void testValidateArgumentsNotEnoughArguments() {
        String[] arguments = new String[] { "dave", "3.4",  "2" , "5", "2.3"};
        assertFalse(Utilities.validateArguments(arguments));
    }

    @Test
    public void testValidateArgumentsTooManyArguments() {
        String[] arguments = new String[] { "dave", "3.4",  "2" , "5", "2.3", "4", "45" };
        assertFalse(Utilities.validateArguments(arguments));
    }

    @Test
    public void testValidateArgumentsInvalidCommand() {
        String[] arguments = new String[] { "SomeRandomString", "3.4",  "2" , "5", "2.3", "4", "45" };
        assertFalse(Utilities.validateArguments(arguments));
    }



}
