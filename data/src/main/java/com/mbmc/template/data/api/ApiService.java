package com.mbmc.template.data.api;

import com.mbmc.template.data.entity.RepoData;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

public interface ApiService {

    @GET("users/{handle}/repos")
    Observable<List<RepoData>> getRepos(@Path("handle") String handle);

}
