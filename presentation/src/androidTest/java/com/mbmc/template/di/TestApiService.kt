package com.mbmc.template.di

import com.mbmc.template.data.api.ApiService
import com.mbmc.template.data.entity.RepoData
import io.reactivex.Observable

class TestApiService : ApiService {

    override fun getRepos(handle: String?): Observable<List<RepoData>> {
        return Observable.just(listOf(RepoData("Repo 1"), RepoData("Repo 2"), RepoData("Repo 3")))
    }

}