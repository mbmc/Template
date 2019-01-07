package com.mbmc.template.domain.usecase

import com.mbmc.template.domain.entity.RepoDomain
import com.mbmc.template.domain.repository.RepoRepository
import io.reactivex.Single

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RepoUseCase @Inject constructor(private val repoRepository: RepoRepository) {
    fun getRepos(handle: String): Single<List<RepoDomain>> = repoRepository.getRepos(handle)
}
