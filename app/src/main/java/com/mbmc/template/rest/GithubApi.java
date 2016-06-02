package com.mbmc.template.rest;

import com.mbmc.template.model.Repo;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;


public interface GithubApi {

    @GET("users/{users}/repos")
    Observable<List<Repo>> getRepos(@Path("users") String users);

}
