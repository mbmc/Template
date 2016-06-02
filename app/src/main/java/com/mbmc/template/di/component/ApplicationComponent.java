package com.mbmc.template.di.component;

import com.mbmc.template.di.module.MainModule;
import com.mbmc.template.di.module.RestModule;
import com.mbmc.template.di.scope.ApplicationScope;
import com.mbmc.template.rest.GithubApi;
import com.mbmc.template.rest.IpApi;

import dagger.Component;


@Component(
        modules = { MainModule.class, RestModule.class }
)
@ApplicationScope
public interface ApplicationComponent {

    GithubApi githupApi();
    IpApi ipApi();
    UiComponent uiComponent();

}
