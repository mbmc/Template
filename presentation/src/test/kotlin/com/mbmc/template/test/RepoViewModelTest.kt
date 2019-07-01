package com.mbmc.template.test

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.mbmc.template.domain.entity.RepoDomain
import com.mbmc.template.domain.repository.RepoRepository
import com.mbmc.template.domain.usecase.RepoUseCase
import com.mbmc.template.entity.Mapper
import com.mbmc.template.entity.Repo
import com.mbmc.template.helper.RepoMatcher
import com.mbmc.template.helper.Schedulers
import com.mbmc.template.ui.DataWrapper
import com.mbmc.template.ui.RepoViewModel
import io.reactivex.Single
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.*
import org.mockito.Mockito.*
import org.mockito.ArgumentCaptor
import org.mockito.Captor

class RepoViewModelTest {
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()
    @Mock
    private lateinit var observer: Observer<DataWrapper<List<Repo>>>
    @Mock
    private lateinit var repoRepository: RepoRepository
    @Captor
    private lateinit var captor: ArgumentCaptor<DataWrapper<List<Repo>>>
    private lateinit var repoViewModel: RepoViewModel

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        repoViewModel = RepoViewModel(RepoUseCase(repoRepository), Mapper(), Schedulers.test())
    }

    @Test
    fun testError() {
        `when`(repoRepository.getRepos("mbmc"))
            .thenReturn(Single.error(Exception("No internet")))
        repoViewModel.observeRepos.observeForever(observer)
        repoViewModel.getRepos("mbmc")

        // 3 updates: loading, success/error, init
        verify(observer, times(3)).onChanged(captor.capture())
        var data = captor.allValues[0]
        assert(data.state == DataWrapper.State.LOADING)

        data = captor.allValues[1]
        assert(data.state == DataWrapper.State.ERROR)
        assert(data.throwable?.message == "No internet")

        data = captor.allValues[2]
        assert(data.state == DataWrapper.State.INIT)
    }

    @Test
    fun testRepoList() {
        val listIn = listOf(RepoDomain("Repo1"), RepoDomain("Repo2"))
        `when`(repoRepository.getRepos("mbmc"))
            .thenReturn(Single.just(listIn))
        repoViewModel.observeRepos.observeForever(observer)
        repoViewModel.getRepos("mbmc")

        verify(observer, times(3)).onChanged(captor.capture())
        var data = captor.allValues[0]
        assert(data.state == DataWrapper.State.LOADING)

        data = captor.allValues[1]
        assert(data.state == DataWrapper.State.SUCCESS)
        val listOut = listOf(Repo("Repo1"), Repo("Repo2"))
        assert(RepoMatcher(data.data!!).matches(listOut))

        data = captor.allValues[2]
        assert(data.state == DataWrapper.State.INIT)
    }
}