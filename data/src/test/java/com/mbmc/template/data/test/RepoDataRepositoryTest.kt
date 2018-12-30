package com.mbmc.template.data.test

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.mbmc.template.data.*
import com.mbmc.template.data.api.ApiService
import com.mbmc.template.data.entity.RepoData
import com.mbmc.template.data.repository.RepoDataRepository
import com.mbmc.template.domain.repository.RepoRepository
import io.reactivex.Observable
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

class RepoDataRepositoryTest {

    @Mock private lateinit var apiService: ApiService
    private lateinit var repoRepository: RepoRepository
    private val gson = Gson()

    private inline fun <reified T> genericType() = object: TypeToken<T>() {}.type

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        repoRepository = RepoDataRepository(apiService)
    }

    @Test
    fun testGetRepos() {
        `when`(apiService.getRepos("mbmc"))
            .thenReturn(Observable.just(gson.fromJson(Data.REPOS, genericType<List<RepoData>>())))
        repoRepository.getRepos("mbmc")
            .test()
            .assertComplete()
            .assertValue { result -> result.size == 9 }
    }

}