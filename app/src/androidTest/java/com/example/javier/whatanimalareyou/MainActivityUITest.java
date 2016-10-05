package com.example.javier.whatanimalareyou;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.Spinner;

import com.example.javier.whatanimalareyou.ui.MainActivity;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withSpinnerText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;

/**
 * Created by Javier on 10/4/2016.
 */

@RunWith(AndroidJUnit4.class)
public class MainActivityUITest {

    @Rule
    public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<MainActivity>(MainActivity.class);

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
}
