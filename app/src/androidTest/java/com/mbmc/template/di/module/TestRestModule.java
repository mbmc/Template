package com.mbmc.template.di.module;

import com.mbmc.template.di.scope.ApplicationScope;
import com.mbmc.template.rest.GithubApi;
import com.mbmc.template.rest.IpApi;
import com.mbmc.template.rest.TestGithubApi;
import com.mbmc.template.rest.TestIpApi;

import dagger.Module;
import dagger.Provides;


@Module
public class TestRestModule {

    @Provides
    @ApplicationScope
    public GithubApi githubApi() {
        return new TestGithubApi();
    }

    @Provides
    @ApplicationScope
    public IpApi ipApi() {
        return new TestIpApi();
    }

}
