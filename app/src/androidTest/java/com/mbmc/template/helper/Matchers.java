package com.mbmc.template.helper;

import android.support.test.espresso.matcher.BoundedMatcher;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import org.hamcrest.Description;
import org.hamcrest.Matcher;


public final class Matchers {

    public static Matcher<View> isEmpty() {
        return new BoundedMatcher<View, TextView>(TextView.class) {
            @Override
            public boolean matchesSafely(TextView view) {
                return TextUtils.isEmpty(view.getText());
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("TextView text is empty");
            }
        };
    }


    private Matchers() {

    }

}
