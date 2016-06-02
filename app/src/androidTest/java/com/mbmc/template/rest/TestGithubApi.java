package com.mbmc.template.rest;

import com.mbmc.template.model.Repo;

import java.util.List;

import retrofit2.http.Path;
import rx.Observable;


public class TestGithubApi implements GithubApi {

    @Override
    public Observable<List<Repo>> getRepos(@Path("users") String users) {
        return null; // @TODO: finish this
    }

}
