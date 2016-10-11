package com.example.javier.whatanimalareyou;

import android.content.Intent;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.javier.whatanimalareyou.ui.ActivityExtras;
import com.example.javier.whatanimalareyou.ui.ResultsActivity.ResultsActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by Javi on 10/11/2016.
 */

@RunWith(AndroidJUnit4.class)
public class ResultsActivityUITest {

    @Rule
    public ActivityTestRule<ResultsActivity> activityRule =
            new ActivityTestRule<>(ResultsActivity.class, true, false);

    @Test
    public void startOverButtonLaunchesMainActivity() throws Exception {

        // Assert
        Intent intent = new Intent();
        intent.putExtra(ActivityExtras.ANIMAL_NAME_KEY, "Tiger");
        intent.putExtra(ActivityExtras.ANIMAL_IMAGE_ID_KEY, R.drawable.tiger);
        intent.putExtra(ActivityExtras.ANIMAL_CAPTION_KEY, "RAWR");

        // Act
        activityRule.launchActivity(intent);
        onView(withId(R.id.startOverButton)).perform(click());

        // Arrange
        onView(withId(R.id.choiceSpinnerView)).check(matches(isDisplayed()));
    }
}
