package com.mbmc.template.di.module;

import com.mbmc.template.BuildConfig;
import com.mbmc.template.constant.Url;
import com.mbmc.template.di.scope.ApplicationScope;
import com.mbmc.template.rest.GithubApi;
import com.mbmc.template.rest.Interceptor;
import com.mbmc.template.rest.IpApi;

import java.util.concurrent.TimeUnit;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


@Module
public class RestModule {

    private static final int TIMEOUT = 10;
    private static final TimeUnit TIME_UNIT = TimeUnit.SECONDS;


    @Provides
    @ApplicationScope
    public Retrofit.Builder builder(OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient);
    }

    @Provides
    @ApplicationScope
    public OkHttpClient okHttpClient(Interceptor interceptor) {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(BuildConfig.LOG?
                HttpLoggingInterceptor.Level.BODY :
                HttpLoggingInterceptor.Level.NONE);

        return new OkHttpClient.Builder()
                .writeTimeout(TIMEOUT, TIME_UNIT)
                .connectTimeout(TIMEOUT, TIME_UNIT)
                .readTimeout(TIMEOUT, TIME_UNIT)
                .addInterceptor(loggingInterceptor)
                .addInterceptor(interceptor)
                .build();
    }

    @Provides
    @ApplicationScope
    public GithubApi githubApi(@Named("Github") Retrofit retrofit) {
        return retrofit.create(GithubApi.class);
    }

    @Provides
    @ApplicationScope
    @Named("Github")
    public Retrofit githubRetrofit(Retrofit.Builder builder) {
        return builder.baseUrl(Url.GITHUB).build();
    }

    @Provides
    @ApplicationScope
    public IpApi ipApi(@Named("Ip") Retrofit retrofit) {
        return retrofit.create(IpApi.class);
    }

    @Provides
    @ApplicationScope
    @Named("Ip")
    public Retrofit ipRetrofit(Retrofit.Builder builder) {
        return builder.baseUrl(Url.IP).build();
    }

}
