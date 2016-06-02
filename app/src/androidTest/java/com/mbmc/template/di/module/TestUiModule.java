package com.mbmc.template.di.module;

import com.mbmc.template.di.scope.UiScope;
import com.mbmc.template.helper.ImageLoader;
import com.mbmc.template.helper.TestImageLoader;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;


@Module
public class TestUiModule {

    @Provides
    @UiScope
    ImageLoader imageLoader() {
        return new TestImageLoader();
    }

    @Provides
    @Named("UiScope")
    public String getString() {
        return "TestUiScope";
    }

}
