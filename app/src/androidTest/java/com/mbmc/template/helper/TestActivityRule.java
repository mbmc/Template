package com.mbmc.template.helper;

import android.app.Activity;
import android.support.test.rule.ActivityTestRule;

import com.mbmc.template.ui.component.ProgressBar;


public class TestActivityRule<T extends Activity> extends ActivityTestRule<T> {

    public TestActivityRule(Class<T> activityClass, boolean initialTouchMode, boolean launchActivity) {
        super(activityClass, initialTouchMode, launchActivity);
    }

    public TestActivityRule(Class<T> activityClass, boolean initialTouchMode) {
        super(activityClass, initialTouchMode);
    }

    public TestActivityRule(Class<T> activityClass) {
        super(activityClass);
    }

    @Override
    public void beforeActivityLaunched() {
        ProgressBar.isIndeterminate = false;
    }

    @Override
    protected void afterActivityFinished() {
        ResponseHandler.reset();
    }

}
