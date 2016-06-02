package com.mbmc.template.di.module;

import android.os.AsyncTask;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import rx.Scheduler;
import rx.schedulers.Schedulers;


@Module
public class TestMainModule {

    @Provides
    public Scheduler scheduler() {
        return Schedulers.from(AsyncTask.THREAD_POOL_EXECUTOR);
    }

    @Provides
    @Named("SomeToken")
    public String someToken() {
        return "TestToken";
    }

}
