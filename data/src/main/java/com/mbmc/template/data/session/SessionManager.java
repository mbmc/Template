package com.mbmc.template.data.session;

import android.text.TextUtils;

public class SessionManager {

    private String token;

    public SessionManager(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public boolean isLoggedIn() {
        return false;//!TextUtils.isEmpty(token);
    }

}
