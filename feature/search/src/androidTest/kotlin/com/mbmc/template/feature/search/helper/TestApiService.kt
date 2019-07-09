package com.mbmc.template.feature.search.helper

import com.mbmc.template.feature.search.data.api.ApiService
import com.mbmc.template.feature.search.data.entity.RepoData
import io.reactivex.Single

class TestApiService : ApiService {
    override fun getRepos(handle: String): Single<List<RepoData>> =
        Single.just(listOf(RepoData("Repo 1"), RepoData("Repo 2"), RepoData("Repo 3")))
}