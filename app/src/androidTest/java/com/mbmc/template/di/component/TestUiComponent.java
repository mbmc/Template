package com.mbmc.template.di.component;

import com.mbmc.template.di.module.TestUiModule;
import com.mbmc.template.di.scope.UiScope;

import dagger.Subcomponent;


@Subcomponent(modules = TestUiModule.class)
@UiScope
public interface TestUiComponent extends UiComponent {

}
