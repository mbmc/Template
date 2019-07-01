package com.mbmc.template.di

import com.mbmc.template.data.api.ApiService
import com.mbmc.template.data.entity.RepoData
import io.reactivex.Single

class TestApiService : ApiService {
    override fun getRepos(handle: String): Single<List<RepoData>> =
        Single.just(listOf(RepoData("Repo 1"), RepoData("Repo 2"), RepoData("Repo 3")))
}