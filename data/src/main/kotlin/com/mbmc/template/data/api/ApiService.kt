package com.mbmc.template.data.api

import com.mbmc.template.data.entity.RepoData
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("users/{handle}/repos")
    fun getRepos(@Path("handle") handle: String): Single<List<RepoData>>
}
