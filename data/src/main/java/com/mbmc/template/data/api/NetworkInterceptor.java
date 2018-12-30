package com.mbmc.template.data.api;

import com.mbmc.template.data.session.SessionManager;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class NetworkInterceptor implements Interceptor {

    private final SessionManager sessionManager;

    public NetworkInterceptor(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request;
        if (sessionManager.isLoggedIn()) {
            request = new Request.Builder()
                    .addHeader("Authorization", sessionManager.getToken())
                    .build();
        } else {
            request = chain.request();
        }

        return chain.proceed(request);
    }

}
