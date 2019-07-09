package com.mbmc.template.feature.search.data.repository

import com.mbmc.template.feature.search.data.api.ApiService
import com.mbmc.template.feature.search.data.entity.Mapper
import com.mbmc.template.feature.search.domain.entity.RepoDomain
import com.mbmc.template.feature.search.domain.repository.RepoRepository
import io.reactivex.Single

class RepoDataRepository(
    private val apiService: ApiService,
    private val mapper: Mapper
) : RepoRepository {
    override fun getRepos(handle: String): Single<List<RepoDomain>> =
        apiService.getRepos(handle).map { result -> result.map { mapper.dataToDomain(it) } }
}
