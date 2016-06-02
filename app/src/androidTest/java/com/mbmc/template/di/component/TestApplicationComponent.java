package com.mbmc.template.di.component;

import com.mbmc.template.di.module.TestMainModule;
import com.mbmc.template.di.module.TestRestModule;
import com.mbmc.template.di.scope.ApplicationScope;

import dagger.Component;


@Component(
        modules = { TestMainModule.class, TestRestModule.class }
)
@ApplicationScope
public interface TestApplicationComponent extends ApplicationComponent {

    TestUiComponent testUiComponent();

}
