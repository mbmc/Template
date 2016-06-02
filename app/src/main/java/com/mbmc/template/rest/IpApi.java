package com.mbmc.template.rest;

import com.mbmc.template.model.Ip;

import retrofit2.http.GET;
import rx.Observable;


public interface IpApi {

    @GET("./")
    Observable<Ip> getIp();

}
