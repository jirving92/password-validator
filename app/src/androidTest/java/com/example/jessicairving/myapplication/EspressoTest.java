package com.example.jessicairving.myapplication;

import org.junit.runner.RunWith;
import org.junit.Rule;
import org.junit.Test;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.*;
import static android.support.test.espresso.matcher.ViewMatchers.*;
import static android.support.test.espresso.assertion.ViewAssertions.*;

@RunWith(AndroidJUnit4.class)

public class EspressoTest {

    public static String testString = "Example123";
    public static String testString2 = "password";
    public static String testString3 = "example1";

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    //Enters a password, submits, and looks for a display that says t is a strong password
    @Test
    public void strongPasswordTest() {
        //Write the password in the input field
        onView(withId(R.id.userInputField)).perform(typeText(testString));

        //Check the text matches what the user typed in
        onView(withId(R.id.userInputField)).check(matches(withText(testString)));

        //Click the button
        onView(withId(R.id.button)).perform(click());

        onView(withId(R.id.strengthDisplay)).check(matches(withText("Your password is strong")));

    }

    //Enters a password, submits, and looks for a display that says t is a weak password
    @Test
    public void weakPasswordTest() {
        //Write the password in the input field
        onView(withId(R.id.userInputField)).perform(typeText(testString2));

        //Check the text matches what the user typed in
        onView(withId(R.id.userInputField)).check(matches(withText(testString2)));

        //Click the button
        onView(withId(R.id.button)).perform(click());

        onView(withId(R.id.strengthDisplay)).check(matches(withText("Your password is weak")));

    }

    //Enters a password, submits, and looks for a display that says t is an okay password
    @Test
    public void okayPasswordTest() {
        //Write the password in the input field
        onView(withId(R.id.userInputField)).perform(typeText(testString3));

        //Check the text matches what the user typed in
        onView(withId(R.id.userInputField)).check(matches(withText(testString3)));

        //Click the button
        onView(withId(R.id.button)).perform(click());

        onView(withId(R.id.strengthDisplay)).check(matches(withText("Your password is okay")));

    }

}
