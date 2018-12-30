package com.mbmc.template.di;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.mbmc.template.data.api.ApiService;
import com.mbmc.template.data.Constants;
import com.mbmc.template.data.api.NetworkInterceptor;
import com.mbmc.template.data.session.SessionManager;
import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import javax.inject.Singleton;
import java.util.concurrent.TimeUnit;

@Module
public class ApiModule {

    private static final int TIMEOUT = 10; // 10s

    @Provides
    @Singleton
    Retrofit retrofit(OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(Constants.GITHUB_API)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    ApiService apiService(Retrofit retrofit) {
        return retrofit.create(ApiService.class);
    }

    @Provides
    @Singleton
    OkHttpClient okHttpClient(Interceptor interceptor) {
        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();
        okHttpClientBuilder.connectTimeout(TIMEOUT, TimeUnit.SECONDS);
        okHttpClientBuilder.readTimeout(TIMEOUT, TimeUnit.SECONDS);
        okHttpClientBuilder.writeTimeout(TIMEOUT, TimeUnit.SECONDS);
        okHttpClientBuilder.addInterceptor(interceptor);
        return okHttpClientBuilder.build();
    }

    @Provides
    @Singleton
    Interceptor interceptor(SessionManager sessionManager) {
        return new NetworkInterceptor(sessionManager);
    }

}
