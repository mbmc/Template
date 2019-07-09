package com.mbmc.template.feature.search.presentation.entity

import com.mbmc.template.feature.search.di.scope.SearchScope
import com.mbmc.template.feature.search.domain.entity.RepoDomain
import javax.inject.Inject

@SearchScope
class Mapper @Inject constructor() {
    fun domainToPresentation(repoDomain: RepoDomain): Repo = Repo(repoDomain.name)
}
