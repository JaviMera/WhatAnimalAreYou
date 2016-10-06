package com.example.javier.whatanimalareyou;

import android.content.Context;
import android.graphics.Color;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatButton;
import android.widget.Spinner;

import com.example.javier.whatanimalareyou.ui.MainActivity;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.actionWithAssertions;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isEnabled;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withSpinnerText;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

/**
 * Created by Javier on 10/4/2016.
 */

@RunWith(AndroidJUnit4.class)
public class MainActivityUITest {

    @Rule
    public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    @Test
    public void activityCreateFirstStatementIsDisplayed() throws Exception {

        // Arrange
        String[] statements = activityRule.getActivity().getResources().getStringArray(R.array.statements_array);

        //  Act

        // Assert
        onView(withId(R.id.statementTextView)).check(matches(isDisplayed()));
        onView(withId(R.id.statementTextView)).check(matches(withText(statements[0])));
    }

    @Test
    public void activityCreateSpinnerIsVisible() throws Exception {

        // Assert
        onView(withId(R.id.choiceSpinnerView)).check(matches(isDisplayed()));

    }

    @Test
    public void activityCreateSpinnerHasCorrectChoice() throws Exception {

        // Arrange
        String[] choices = activityRule.getActivity().getResources().getStringArray(R.array.choices_array);

        // Act
        onView(withId(R.id.choiceSpinnerView)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is(choices[0]))).perform(click());

        // Assert
        onView(withId(R.id.choiceSpinnerView)).check(matches(withSpinnerText(choices[0])));
    }

    @Test
    public void activityCreateNavigationButtons() throws Exception {

        // Assert
        onView(withId(R.id.previousButtonView)).check(matches(isDisplayed()));
        onView(withId(R.id.previousButtonView)).check(matches(not(isEnabled())));
        onView(withId(R.id.nextButtonView)).check(matches(isDisplayed()));
    }

    @Test
    public void nextButtonPress() throws Exception {

        // Arrange
        String[] statements = activityRule.getActivity().getResources().getStringArray(R.array.statements_array);
        int enabledColor = ContextCompat.getColor(activityRule.getActivity(), R.color.plain_white);

        //  Act
        onView(withId(R.id.nextButtonView)).perform(click());

        // Assert
        onView(withId(R.id.statementTextView)).check(matches(withText(statements[1])));
        onView(withId(R.id.previousButtonView)).check(matches(isEnabled()));
        onView(withId(R.id.previousButtonView)).check(matches(new ButtonTextColorMatcher(enabledColor)));
    }

    private class ButtonTextColorMatcher extends BaseMatcher {

        private int mExpectedColor;

        public ButtonTextColorMatcher(int color) {
            mExpectedColor = color;
        }

        @Override
        public boolean matches(Object item) {
            AppCompatButton button = (AppCompatButton)item;
            int actualColor = button.getCurrentTextColor();

            return mExpectedColor == actualColor;
        }

        @Override
        public void describeTo(Description description) {
            description.appendText("Text color must be " + mExpectedColor);
        }
    }
}
