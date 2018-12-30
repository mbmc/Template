package com.mbmc.template.di;

import com.mbmc.template.data.api.ApiService;
import com.mbmc.template.data.Constants;
import com.mbmc.template.data.repository.RepoDataRepository;
import com.mbmc.template.data.session.SessionManager;
import com.mbmc.template.domain.repository.RepoRepository;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

@Module
public class MainModule {

    @Provides
    @Singleton
    SessionManager sessionManager() {
        return new SessionManager(Constants.TOKEN);
    }

    @Provides
    @Singleton
    RepoRepository repoRepository(ApiService apiService) {
        return new RepoDataRepository(apiService);
    }

}
