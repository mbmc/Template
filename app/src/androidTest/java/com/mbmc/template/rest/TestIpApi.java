package com.mbmc.template.rest;

import com.mbmc.template.constant.TestConstants;
import com.mbmc.template.helper.ResponseHandler;
import com.mbmc.template.model.Ip;
import com.google.gson.Gson;

import rx.Observable;


public class TestIpApi implements IpApi {

    @Override
    public Observable<Ip> getIp() {
        Ip ip = new Gson().fromJson(TestConstants.IP, Ip.class);
        return ResponseHandler.getResponse(ip);
    }

}
