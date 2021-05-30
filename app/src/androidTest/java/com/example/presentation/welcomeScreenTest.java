package com.example.presentation;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.closeSoftKeyboard;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class welcomeScreenTest {

    @Rule
    public ActivityTestRule<welcome_screen> activityRule = new ActivityTestRule<>(welcome_screen.class);

    @Test
    public void button_redirects_to_signUp(){

        onView(withId(R.id.signupButton)) //this checks whether button can be pressed, matches the button with id and clicks it
                .perform(click());

        onView(withId(R.id.signupScreen))
                .check(matches(isDisplayed()));

    }

    @Test
    public void button_redirects_to_signIn(){

        onView(withId(R.id.signinButton)) //this checks whether button can be pressed, matches the button with id and clicks it
                .perform(click());

        onView(withId(R.id.signInScreen))
                .check(matches(isDisplayed()));

    }
}
