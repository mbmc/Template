package com.mbmc.template.feature.search.data.entity

import com.mbmc.template.feature.search.di.scope.SearchScope
import com.mbmc.template.feature.search.domain.entity.RepoDomain
import javax.inject.Inject

@SearchScope
class Mapper @Inject constructor() {
    fun dataToDomain(repoData: RepoData): RepoDomain = RepoDomain(repoData.name)
}

