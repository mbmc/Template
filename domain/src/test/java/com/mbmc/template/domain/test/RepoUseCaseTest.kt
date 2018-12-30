package com.mbmc.template.domain.test

import com.mbmc.template.domain.Data
import com.mbmc.template.domain.repository.RepoRepository
import com.mbmc.template.domain.usecase.RepoUseCase
import io.reactivex.Observable
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

class RepoUseCaseTest {

    @Mock private lateinit var repoRepository: RepoRepository
    private lateinit var repoUseCase: RepoUseCase

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        repoUseCase = RepoUseCase(repoRepository)
    }

    @Test
    fun testGetRepos() {
        `when`(repoRepository.getRepos("mbmc"))
            .thenReturn(Observable.just(Data.REPOS))
        repoUseCase.getRepos("mbmc")
            .test()
            .assertComplete()
            .assertValue { result -> result.size == 9 }
    }

}