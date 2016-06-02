package com.mbmc.template;

import com.mbmc.template.di.component.DaggerTestApplicationComponent;
import com.mbmc.template.di.component.TestApplicationComponent;
import com.mbmc.template.di.component.UiComponent;


public class TestApplication extends Application {

    private TestApplicationComponent applicationComponent;


    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerTestApplicationComponent.create();
    }

    @Override
    public UiComponent getUiComponent() {
        return applicationComponent.testUiComponent();
    }

}
