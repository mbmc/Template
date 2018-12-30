package com.mbmc.template.di;

import com.mbmc.template.Application;
import dagger.Component;
import dagger.android.AndroidInjector;

import javax.inject.Singleton;

@Component (modules = {ActivityModule.class, ApiModule.class, MainModule.class, ViewModelModule.class})
@Singleton
public interface ApplicationComponent extends AndroidInjector<Application> {

}
