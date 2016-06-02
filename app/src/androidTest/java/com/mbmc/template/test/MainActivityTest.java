package com.mbmc.template.test;

import android.app.Activity;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import com.mbmc.template.R;
import com.mbmc.template.helper.ErrorHandler;
import com.mbmc.template.helper.Matchers;
import com.mbmc.template.helper.ResponseHandler;
import com.mbmc.template.helper.TestActivityRule;
import com.mbmc.template.ui.activity.MainActivity;
import com.squareup.spoon.Spoon;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.not;


@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule =
            new TestActivityRule<>(MainActivity.class, false, false);


    @Test
    public void fields() {
        activityTestRule.launchActivity(null);

        Context context = InstrumentationRegistry.getTargetContext();
        onView(withId(R.id.main_token)).check(matches(not(
                withText(context.getString(R.string.token, R.string.some_token)))));
        onView(withId(R.id.main_token)).check(matches(
                withText(context.getString(R.string.token, "TestToken"))));
        onView(withId(R.id.main_scope)).check(matches(
                withText(context.getString(R.string.scope, "TestUiScope"))));
        onView(withId(R.id.main_ip)).check(matches(
                withText(context.getString(R.string.ip, "123.456.789.000"))));
    }

    @Test
    public void ui() {
        Activity activity = activityTestRule.launchActivity(null);
        Spoon.screenshot(activity, "MainActivity");
    }

    @Test
    public void timeout() {
        ResponseHandler.setError(ErrorHandler.Type.TIMEOUT);
        activityTestRule.launchActivity(null);
        onView(withId(R.id.main_ip)).check(matches(Matchers.isEmpty()));
    }

    @Test
    public void unauthorized() {
        ResponseHandler.setError(ErrorHandler.Type.UNAUTHORIZED);
        activityTestRule.launchActivity(null);
        onView(withId(R.id.main_ip)).check(matches(Matchers.isEmpty()));
    }

}
