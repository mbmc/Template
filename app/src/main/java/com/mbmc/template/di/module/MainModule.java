package com.mbmc.template.di.module;

import android.content.Context;

import com.mbmc.template.R;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import rx.Scheduler;
import rx.schedulers.Schedulers;


@Module
public class MainModule {

    private final Context context;


    public MainModule(Context context) {
        this.context = context;
    }

    @Provides
    public Scheduler scheduler() {
        return Schedulers.newThread();
    }

    @Provides
    @Named("SomeToken")
    public String someToken() {
        return context.getString(R.string.some_token);
    }

}
