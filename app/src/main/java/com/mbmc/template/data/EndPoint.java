package com.mbmc.template.data;


public enum EndPoint {

    STAGING("http://staging-api.myapp.com"),
    PRODUCTION("http://api.myapp.com");

    public String url;


    EndPoint(String url) {
        this.url = url;
    }

}
