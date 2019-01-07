package com.mbmc.template.domain.repository

import com.mbmc.template.domain.entity.RepoDomain
import io.reactivex.Single

interface RepoRepository {
    fun getRepos(handle: String): Single<List<RepoDomain>>
}

