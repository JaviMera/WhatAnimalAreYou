package com.example.javier.whatanimalareyou;

import android.content.Context;
import android.graphics.Color;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatButton;
import android.widget.Spinner;

import com.example.javier.whatanimalareyou.model.Statement;
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
    public void statementCountTextViewDisplaysCorrectCount() throws Exception {

        // Arrange
        String[] statements = activityRule.getActivity().getResources().getStringArray(R.array.statements_array);
        String expectedStatementCountText = "1 of " + statements.length;

        // Assert
        onView(withId(R.id.statementTextView)).check(matches(isDisplayed()));
        onView(withId(R.id.statementTextView)).check(matches(withText(statements[0])));
        onView(withId(R.id.statementCountTextView)).check(matches(isDisplayed()));
        onView(withId(R.id.statementCountTextView)).check(matches(withText(expectedStatementCountText)));
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

    @Test
    public void nextButtonDisabledAtLastStatement() throws Exception {

        // Arrange
        String[] statements = activityRule.getActivity().getResources().getStringArray(R.array.statements_array);
        int disabledColor = ContextCompat.getColor(activityRule.getActivity(), R.color.disabled_text_color);

        // Act
        for(int i = 0 ; i < statements.length - 1 ; i++)
            onView(withId(R.id.nextButtonView)).perform(click());

        // Assert
        onView(withId(R.id.nextButtonView)).check(matches(not(isEnabled())));
        onView(withId(R.id.nextButtonView)).check(matches(new ButtonTextColorMatcher(disabledColor)));
    }

    @Test
    public void previousButtonEnablesNextButton() throws Exception {

        // Arrange
        String[] statements = activityRule.getActivity().getResources().getStringArray(R.array.statements_array);
        int enabledColor = ContextCompat.getColor(activityRule.getActivity(), R.color.plain_white);

        // Act
        for(int i = 0 ; i < statements.length - 1 ; i++)
            onView(withId(R.id.nextButtonView)).perform(click());

        onView(withId(R.id.previousButtonView)).perform(click());

        // Assert
        onView(withId(R.id.nextButtonView)).check(matches(isEnabled()));
        onView(withId(R.id.nextButtonView)).check(matches(new ButtonTextColorMatcher(enabledColor)));
    }

    @Test
    public void previousButtonShowsPreviousStatement() throws Exception {

        // Arrange
        String[] statements = activityRule.getActivity().getResources().getStringArray(R.array.statements_array);

        // Act
        for(int i = 0 ; i < statements.length - 1 ; i++)
            onView(withId(R.id.nextButtonView)).perform(click());

        onView(withId(R.id.previousButtonView)).perform(click());

        // Assert
        onView(withId(R.id.statementTextView)).check(matches(withText(statements[3])));
    }

    @Test
    public void previousButtonDisabledAtFirstStatement() throws Exception {

        // Arrange
        int disabledColor = ContextCompat.getColor(activityRule.getActivity(), R.color.disabled_text_color);

        // Act
        onView(withId(R.id.nextButtonView)).perform(click());
        onView(withId(R.id.previousButtonView)).perform(click());

        // Assert
        onView(withId(R.id.previousButtonView)).check(matches(not(isEnabled())));
        onView(withId(R.id.previousButtonView)).check(matches(new ButtonTextColorMatcher(disabledColor)));
    }

    @Test
    public void nextButtonUpdatesStatementCounterTextView() throws Exception {

        // Arrange
        String expectedText = "2 of 5";

        // Act
        onView(withId(R.id.nextButtonView)).perform(click());

        // Assert
        onView(withId(R.id.statementCountTextView)).check(matches(withText(expectedText)));
    }

    @Test
    public void previousButtonUpdatesStatementCounterTextView() throws Exception {

        // Arrange
        String expectedText = "1 of 5";

        // Act
        onView(withId(R.id.nextButtonView)).perform(click());
        onView(withId(R.id.previousButtonView)).perform(click());

        // Assert
        onView(withId(R.id.statementCountTextView)).check(matches(withText(expectedText)));
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
