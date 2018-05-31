package com.example.jessicairving.myapplication;

import org.junit.Test;
import org.junit.BeforeClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


public class ValidatorTest {
    static String testString = "example12345";
    static String testString1 = "ex";
    static String testString2 = "password";
    static String testString3 = "PAssWord";

    static Validator val, val2, val3, val4;

    // Setting up all the validators/passwords
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        val = new Validator();
        val2 = new Validator();
        val3 = new Validator();
        val4 = new Validator();
        val.setPassword(testString);
        val2.setPassword(testString1);
        val3.setPassword(testString2);
        val4.setPassword(testString3);;
    }

    // Tests that the name is correct
    @Test
    public void correctStringName() {
        assertEquals(testString, val.getPassword(), "example12345");
        assertEquals(testString1, val2.getPassword(), "ex");
        assertEquals(testString2, val3.getPassword(), "password");
        assertNotEquals(val3.getPassword(), "PAssWord");
        assertEquals(testString2, val4.getPassword(), "PAssWord");
    }

    // Testing that there are at least 8 characters
    @Test
    public void minEightChars() {
        assertEquals(1, val.passwordLength());
        assertEquals(0, val2.passwordLength());
        assertEquals(1, val3.passwordLength());
        assertEquals(1, val4.passwordLength());
    }

    // Testing that the password is not the word password, regardless of case
    @Test
    public void notPassword() {
        assertEquals(1, val.passwordText());
        assertEquals(1, val2.passwordText());
        assertEquals(0, val3.passwordText());
        assertEquals(0, val4.passwordText());
    }

    // Testing that the Validator correctly adds up the number of rules passed
    @Test
    public void testValidate() {
        assertEquals(2, val.validate());
        assertEquals(1, val2.validate());
        assertEquals(1, val3.validate());
        assertEquals(1, val4.validate());
    }

}