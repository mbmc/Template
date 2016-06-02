package com.mbmc.template;

import com.mbmc.template.di.component.ApplicationComponent;
import com.mbmc.template.di.component.DaggerApplicationComponent;
import com.mbmc.template.di.component.UiComponent;
import com.mbmc.template.di.module.MainModule;


public class Application extends android.app.Application {

    private ApplicationComponent applicationComponent;


    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent.builder()
                .mainModule(new MainModule(this)).build();
    }

    public UiComponent getUiComponent() {
        return applicationComponent.uiComponent();
    }

}
