package com.mbmc.template.helper;

import android.content.Context;

import com.mbmc.template.R;
import com.mbmc.template.data.UnauthorizedException;

import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import retrofit2.adapter.rxjava.HttpException;


public final class ErrorHandler {

    public enum Type {
        GENERIC,
        NOT_FOUND,
        NO_INTERNET,
        TIMEOUT,
        UNAUTHORIZED
    }

    public static String get(Context context, Throwable throwable) throws UnauthorizedException {
        int resId = R.string.error;

        if (throwable instanceof HttpException) {
            HttpException exception = (HttpException) throwable;
            if (exception.code() == HttpURLConnection.HTTP_UNAUTHORIZED) {
                //throw new UnauthorizedException();
                resId = R.string.error_unauthorized;
            } else if (exception.code() == HttpURLConnection.HTTP_NOT_FOUND) {
                resId = R.string.error_not_found;
            }
        }
        if (throwable instanceof UnknownHostException) {
            resId = R.string.error_internet;
        } else if (throwable instanceof SocketTimeoutException) {
            resId = R.string.error_timeout;
        } else if (throwable instanceof InterruptedIOException) {
            resId = R.string.error_timeout;
        }

        return context.getString(resId);
    }


    private ErrorHandler() {

    }

}
