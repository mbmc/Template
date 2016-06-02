package com.mbmc.template.helper;

import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import okhttp3.MediaType;
import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.adapter.rxjava.HttpException;
import rx.Observable;


public final class ResponseHandler {

    private static Throwable throwable;


    public static Observable getResponse(Object object) {
        if (throwable != null) {
            return Observable.error(throwable);
        }
        return Observable.just(object);
    }

    public static void setError(ErrorHandler.Type type) {
        switch (type) {
            case GENERIC: throwable = new Exception(); break;
            case NO_INTERNET: throwable = new UnknownHostException(); break;
            case TIMEOUT: throwable = new SocketTimeoutException(); break;
            case NOT_FOUND:
                throwable = new HttpException(Response.error(404,
                    ResponseBody.create(MediaType.parse(""), "")));
                break;
            case UNAUTHORIZED:
                throwable = new HttpException(Response.error(401,
                        ResponseBody.create(MediaType.parse(""), "")));
                break;
        }
    }

    public static void reset() {
        throwable = null;
    }


    private ResponseHandler() {

    }

}
