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
    public static String testString3 = "example123";

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

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


}
