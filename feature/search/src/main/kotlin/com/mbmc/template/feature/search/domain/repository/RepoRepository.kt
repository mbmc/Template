package com.mbmc.template.feature.search.domain.repository

import com.mbmc.template.feature.search.domain.entity.RepoDomain
import io.reactivex.Single

interface RepoRepository {
    fun getRepos(handle: String): Single<List<RepoDomain>>
}
