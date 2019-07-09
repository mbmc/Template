package com.mbmc.template.feature.search.domain.test

import com.mbmc.template.feature.search.domain.Data
import com.mbmc.template.feature.search.domain.repository.RepoRepository
import com.mbmc.template.feature.search.domain.usecase.RepoUseCase
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

class RepoUseCaseTest {
    @Mock
    private lateinit var repoRepository: RepoRepository
    private lateinit var repoUseCase: RepoUseCase

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        repoUseCase = RepoUseCase(repoRepository)
    }

    @Test
    fun testGetRepos() {
        `when`(repoRepository.getRepos("mbmc"))
            .thenReturn(Single.just(Data.REPOS))
        repoUseCase.getRepos("mbmc")
            .test()
            .assertComplete()
            .assertValue { result -> result.size == 9 }
    }
}