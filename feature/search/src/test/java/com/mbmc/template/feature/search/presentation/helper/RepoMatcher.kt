package com.mbmc.template.feature.search.presentation.helper

import com.mbmc.template.feature.search.presentation.entity.Repo

class RepoMatcher(private val listA: List<Repo>) {
    fun matches(listB: List<Repo>): Boolean {
        listA.forEachIndexed { index, repo ->
            if (repo.name != listB[index].name) {
                return false
            }
        }
        return true
    }
}
