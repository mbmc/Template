package com.mbmc.template.feature.search.domain.usecase

import com.mbmc.template.feature.search.di.scope.SearchScope
import com.mbmc.template.feature.search.domain.entity.RepoDomain
import com.mbmc.template.feature.search.domain.repository.RepoRepository
import io.reactivex.Single

import javax.inject.Inject

@SearchScope
class RepoUseCase @Inject constructor(private val repoRepository: RepoRepository) {
    fun getRepos(handle: String): Single<List<RepoDomain>> = repoRepository.getRepos(handle)
}
