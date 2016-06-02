package com.mbmc.template.rest;

import com.mbmc.template.constant.Constants;

import java.io.IOException;

import javax.inject.Inject;
import javax.inject.Named;

import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;


public class Interceptor implements okhttp3.Interceptor {

    private String someToken;


    @Inject
    public Interceptor(@Named("SomeToken") String someToken) {
        this.someToken = someToken;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        HttpUrl httpUrl = chain.request().url()
                .newBuilder()
                .addQueryParameter("some_token", someToken)
                .build();

        Request request = chain.request().newBuilder()
                .addHeader("some_header", Constants.SOME_CONSTANT)
                .url(httpUrl)
                .build();

        return chain.proceed(request);
    }

}
