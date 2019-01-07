package com.mbmc.template.entity

import com.mbmc.template.domain.entity.RepoDomain
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Mapper @Inject constructor() {
    fun domainToPresentation(repoDomain: RepoDomain): Repo = Repo(repoDomain.name)
}
