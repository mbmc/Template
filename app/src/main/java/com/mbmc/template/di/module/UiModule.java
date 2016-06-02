package com.mbmc.template.di.module;

import com.mbmc.template.di.scope.UiScope;
import com.mbmc.template.helper.GlideImageLoader;
import com.mbmc.template.helper.ImageLoader;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;


@Module
public class UiModule {

    @Provides
    @UiScope
    ImageLoader imageLoader() {
        return new GlideImageLoader();
    }

    @Provides
    @Named("UiScope")
    public String getString() {
        return "UiScope";
    }

}
