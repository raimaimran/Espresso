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
import static androidx.test.espresso.matcher.ViewMatchers.isChecked;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class signUpTest {


    @Rule
    public ActivityTestRule<signUp> activityRule = new ActivityTestRule<>(signUp.class);

    @Test
    public void name_entered() {
        onView(withId(R.id.nameField))
                .perform(typeText("Raima Imran"));
    }

    @Test
    public void email_entered() {
        onView(withId(R.id.emailField))
                .perform(typeText("raima.imran@gmail.com"));
    }

    @Test
    public void password_entered() {
        onView(withId(R.id.passwordField))
                .perform(typeText("password"));
    }

    @Test
    public void confirm_password_entered() {
        onView(withId(R.id.confirmPasswordField))
                .perform(typeText("password"));
    }

    @Test
    public void confirm_male_gender_checked() {
        onView(withId(R.id.MaleButton))
                .perform(click());
        onView(withId(R.id.MaleButton))
                .check(matches(isChecked()));
    }

    @Test
    public void confirm_female_gender_checked() {
        onView(withId(R.id.FemaleButton))
                .perform(click());
        onView(withId(R.id.FemaleButton))
                .check(matches(isChecked()));
    }

    @Test
    public void link_redirects_to_signin(){
        onView(withId(R.id.redirectsignin))
                .perform(click());

        onView(withId(R.id.signInScreen)) //text view
                .check(matches(isDisplayed()));
    }

    @Test
    public void button_redirects_to_homepage(){

        onView(withId(R.id.nameField))
                .perform(typeText("Raima Imran"));
        closeSoftKeyboard();
        onView(withId(R.id.emailField))
                .perform(typeText("raima.imran@gmail.com"));
        closeSoftKeyboard();
        onView(withId(R.id.passwordField))
                .perform(typeText("password"));
        closeSoftKeyboard();
        onView(withId(R.id.confirmPasswordField))
                .perform(typeText("password"));
        closeSoftKeyboard();
        onView(withId(R.id.FemaleButton))
                .perform(click());

        onView(withId(R.id.signupButton))
                .perform(click());

        onView(withId(R.id.homePage)) //second find the view displayed and checks whether it is displayed or not
                .check(matches(withText("Welcome to your HomePage raima.imran@gmail.com" )));

    }

    @Test
    public void error_displayed_when_name_not_entered(){

        onView(withId(R.id.emailField))
                .perform(typeText("raima.imran@gmail.com"));
        closeSoftKeyboard();
        onView(withId(R.id.passwordField))
                .perform(typeText("password"));
        closeSoftKeyboard();
        onView(withId(R.id.confirmPasswordField))
                .perform(typeText("password"));
        closeSoftKeyboard();
        onView(withId(R.id.MaleButton))
                .perform(click());

        onView(withId(R.id.signupButton))
                .perform(click());

        onView((withId(R.id.incorrectmail))).check(matches(withText("You must enter your name")));

    }

    @Test
    public void error_displayed_when_email_not_entered(){

        onView(withId(R.id.nameField))
                .perform(typeText("Raima Imran"));
        closeSoftKeyboard();
        onView(withId(R.id.passwordField))
                .perform(typeText("password"));
        closeSoftKeyboard();
        onView(withId(R.id.confirmPasswordField))
                .perform(typeText("password"));
        closeSoftKeyboard();
        onView(withId(R.id.FemaleButton))
                .perform(click());

        onView(withId(R.id.signupButton))
                .perform(click());

        onView((withId(R.id.incorrectmail))).check(matches(withText("You must enter your email")));

    }

    @Test
    public void error_displayed_when_password_not_entered(){

        onView(withId(R.id.nameField))
                .perform(typeText("Noorish Hassan"));
        closeSoftKeyboard();
        onView(withId(R.id.emailField))
                .perform(typeText("noorish.hassan@gmail.com"));
        closeSoftKeyboard();
        onView(withId(R.id.confirmPasswordField))
                .perform(typeText("password"));
        closeSoftKeyboard();
        onView(withId(R.id.MaleButton))
                .perform(click());

        onView(withId(R.id.signupButton))
                .perform(click());

        onView((withId(R.id.incorrectmail))).check(matches(withText("You must enter your password")));

    }

    @Test
    public void error_displayed_when_confirm_password_not_entered(){

        onView(withId(R.id.nameField))
                .perform(typeText("Noorish Hassan"));
        closeSoftKeyboard();
        onView(withId(R.id.emailField))
                .perform(typeText("noorish.hassan@gmail.com"));
        closeSoftKeyboard();
        onView(withId(R.id.confirmPasswordField))
                .perform(typeText("password"));
        closeSoftKeyboard();
        onView(withId(R.id.FemaleButton))
                .perform(click());

        onView(withId(R.id.signupButton))
                .perform(click());

        onView((withId(R.id.incorrectmail)))
                .check(matches(withText("You must enter your password")));

    }

    @Test
    public void error_displayed_when_gender_not_checked(){

        onView(withId(R.id.nameField))
                .perform(typeText("Noorish Hassan"));
        closeSoftKeyboard();
        onView(withId(R.id.emailField))
                .perform(typeText("noorish.hassan@gmail.com"));
        closeSoftKeyboard();
        onView(withId(R.id.passwordField))
                .perform(typeText("password"));
        closeSoftKeyboard();
        onView(withId(R.id.confirmPasswordField))
                .perform(typeText("password"));
        closeSoftKeyboard();

        onView(withId(R.id.signupButton))
                .perform(click());

        onView((withId(R.id.incorrectmail)))
                .check(matches(withText("You must select a gender")));

    }

    @Test
    public void error_displayed_when_incorrect_email_entered(){

        onView(withId(R.id.nameField))
                .perform(typeText("Noorish Hassan"));
        closeSoftKeyboard();
        onView(withId(R.id.emailField))
                .perform(typeText("noorish.hassangmail.com"));
        closeSoftKeyboard();
        onView(withId(R.id.passwordField))
                .perform(typeText("password"));
        closeSoftKeyboard();
        onView(withId(R.id.confirmPasswordField))
                .perform(typeText("password"));
        closeSoftKeyboard();
        onView(withId(R.id.MaleButton))
                .perform(click());

        onView(withId(R.id.signupButton))
                .perform(click());

        onView((withId(R.id.incorrectmail)))
                .check(matches(withText("You must enter a valid email.")));

    }

    @Test
    public void verify_correct_details_entered(){

        onView(withId(R.id.nameField))
                .perform(typeText("Noorish Hassan"));
        closeSoftKeyboard();
        onView(withId(R.id.emailField))
                .perform(typeText("noorish.hassan@gmail.com"));
        closeSoftKeyboard();
        onView(withId(R.id.passwordField))
                .perform(typeText("password"));
        closeSoftKeyboard();
        onView(withId(R.id.confirmPasswordField))
                .perform(typeText("password"));
        closeSoftKeyboard();
        onView(withId(R.id.FemaleButton))
                .perform(click());

        onView(withId(R.id.signupButton))
                .perform(click());

        onView(withId(R.id.homePage)) //text view
                .check(matches(withText("Welcome to your HomePage noorish.hassan@gmail.com" )));

    }
}
