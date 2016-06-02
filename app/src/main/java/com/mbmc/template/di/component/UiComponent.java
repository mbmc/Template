package com.mbmc.template.di.component;

import com.mbmc.template.di.module.UiModule;
import com.mbmc.template.di.scope.UiScope;
import com.mbmc.template.helper.ImageLoader;
import com.mbmc.template.ui.activity.BaseActivity;
import com.mbmc.template.ui.activity.MainActivity;

import dagger.Subcomponent;


@Subcomponent(modules = UiModule.class)
@UiScope
public interface UiComponent {

    ImageLoader imageLoader();
    void inject(BaseActivity object);
    void inject(MainActivity object);

}
