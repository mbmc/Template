package com.mbmc.template.data.entity

import com.mbmc.template.domain.entity.RepoDomain
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Mapper @Inject constructor() {
    fun dataToDomain(repoData: RepoData): RepoDomain = RepoDomain(repoData.name)
}

