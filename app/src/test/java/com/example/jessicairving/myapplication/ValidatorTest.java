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
    static String testString4 = "white spaCe111";
    static String testString5 = "ALLCAPITALLETTERS";

    static Validator val, val2, val3, val4, val5, val6;

    // Setting up all the validators/passwords
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        val = new Validator();
        val2 = new Validator();
        val3 = new Validator();
        val4 = new Validator();
        val5 = new Validator();
        val6 = new Validator();
        val.setPassword(testString);
        val2.setPassword(testString1);
        val3.setPassword(testString2);
        val4.setPassword(testString3);
        val5.setPassword(testString4);
        val6.setPassword(testString5);
    }

    // Tests that the name is correct
    @Test
    public void correctStringName() {
        assertEquals(testString, val.getPassword(), "example12345");
        assertEquals(testString1, val2.getPassword(), "ex");
        assertEquals(testString2, val3.getPassword(), "password");
        assertNotEquals(val3.getPassword(), "PAssWord");
        assertEquals(testString2, val4.getPassword(), "PAssWord");
        assertEquals(testString4, val5.getPassword(), "white spaCe111");
        assertEquals(testString5, val6.getPassword(), "ALLCAPITALLETTERS");
    }

    // Testing that there are at least 8 characters
    @Test
    public void minEightChars() {
        assertEquals(1, val.passwordLength());
        assertEquals(0, val2.passwordLength());
        assertEquals(1, val3.passwordLength());
        assertEquals(1, val4.passwordLength());
        assertEquals(1, val5.passwordLength());
        assertEquals(1, val6.passwordLength());
    }

    // Testing that the password is not the word password, regardless of case
    @Test
    public void notPassword() {
        assertEquals(1, val.passwordText());
        assertEquals(1, val2.passwordText());
        assertEquals(0, val3.passwordText());
        assertEquals(0, val4.passwordText());
        assertEquals(1, val5.passwordText());
        assertEquals(1, val6.passwordText());
    }

    // Testing that the password contains a number
    @Test
    public void containsNumber() {
        assertEquals(1, val.passwordNumber());
        assertEquals(0, val2.passwordNumber());
        assertEquals(0, val3.passwordNumber());
        assertEquals(0, val4.passwordNumber());
        assertEquals(1, val5.passwordNumber());
        assertEquals(0, val6.passwordNumber());
    }

    // Testing that the password contains an upper case letter
    @Test
    public void containsUpperCase() {
        assertEquals(0, val.passwordUpperCase());
        assertEquals(0, val2.passwordUpperCase());
        assertEquals(0, val3.passwordUpperCase());
        assertEquals(1, val4.passwordUpperCase());
        assertEquals(1, val5.passwordUpperCase());
        assertEquals(1, val6.passwordUpperCase());
    }

    // Testing that the password contains a lower case number
    @Test
    public void containsLowerCase() {
        assertEquals(1, val.passwordLowerCase());
        assertEquals(1, val2.passwordLowerCase());
        assertEquals(1, val3.passwordLowerCase());
        assertEquals(1, val4.passwordLowerCase());
        assertEquals(1, val5.passwordLowerCase());
        assertEquals(0, val6.passwordLowerCase());
    }

    // Testing that the password does not contain any whitespace characters
    @Test
    public void doesNotContainWhiteSpace() {
        assertEquals(1, val.passwordWhitespace());
        assertEquals(1, val2.passwordWhitespace());
        assertEquals(1, val3.passwordWhitespace());
        assertEquals(1, val4.passwordWhitespace());
        assertEquals(0, val5.passwordWhitespace());
        assertEquals(1, val6.passwordWhitespace());
    }

    // Testing that the Validator correctly adds up the number of rules passed
    @Test
    public void testValidate() {
        assertEquals(5, val.validate());
        assertEquals(3, val2.validate());
        assertEquals(3, val3.validate());
        assertEquals(4, val4.validate());
        assertEquals(5, val5.validate());
        assertEquals(4, val6.validate());
    }

}