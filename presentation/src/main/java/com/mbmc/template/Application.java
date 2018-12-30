package com.mbmc.template;

import android.app.Activity;
import com.mbmc.template.di.ApplicationComponent;
import com.mbmc.template.di.DaggerApplicationComponent;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

import javax.inject.Inject;

public class Application extends android.app.Application implements HasActivityInjector {

    @Inject DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;

    @Override
    public void onCreate() {
        super.onCreate();
        getComponent().inject(this);
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidInjector;
    }

    protected ApplicationComponent getComponent() {
        return DaggerApplicationComponent.create();
    }

}
