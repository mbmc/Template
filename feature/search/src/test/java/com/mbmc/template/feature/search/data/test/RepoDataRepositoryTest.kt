package com.mbmc.template.feature.search.data.test

import com.mbmc.template.feature.search.data.Data
import com.mbmc.template.feature.search.data.api.ApiService
import com.mbmc.template.feature.search.data.entity.Mapper
import com.mbmc.template.feature.search.data.entity.RepoData
import com.mbmc.template.feature.search.data.repository.RepoDataRepository
import com.mbmc.template.feature.search.domain.repository.RepoRepository
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

class RepoDataRepositoryTest {
    @Mock
    private lateinit var apiService: ApiService
    private lateinit var repoRepository: RepoRepository
    private val moshi = Moshi.Builder().build()

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        repoRepository = RepoDataRepository(apiService, Mapper())
    }

    @Test
    fun testGetRepos() {
        val type = Types.newParameterizedType(List::class.java, RepoData::class.java)
        val adapter: JsonAdapter<List<RepoData>> = moshi.adapter(type)

        `when`(apiService.getRepos("mbmc"))
            .thenReturn(Single.just(adapter.fromJson(Data.REPOS)))
        repoRepository.getRepos("mbmc")
            .test()
            .assertComplete()
            .assertValue { result -> result.size == 9 }
    }
}