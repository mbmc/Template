package com.mbmc.template.test

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.mbmc.template.domain.entity.Repo
import com.mbmc.template.domain.repository.RepoRepository
import com.mbmc.template.domain.usecase.RepoUseCase
import com.mbmc.template.helper.RepoMatcher
import com.mbmc.template.helper.SchedulerRule
import com.mbmc.template.ui.DataWrapper
import com.mbmc.template.ui.RepoViewModel
import io.reactivex.Observable
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.*
import org.mockito.Mockito.*

class RepoViewModelTest {

    @get:Rule val instantTaskExecutorRule = InstantTaskExecutorRule()
    @get:Rule val schedulerRule = SchedulerRule()
    @Mock private lateinit var observer: Observer<DataWrapper<List<Repo>>>
    @Mock private lateinit var repoRepository: RepoRepository
    private lateinit var repoViewModel: RepoViewModel

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        repoViewModel = RepoViewModel(RepoUseCase(repoRepository))
    }

    @Test
    fun testError() {
        `when`(repoRepository.getRepos("mbmc"))
            .thenReturn(Observable.error(Exception("No internet")))
        repoViewModel.observeRepos().observeForever(observer)
        repoViewModel.getRepos("mbmc")
        verify(observer).onChanged(argThat(RepoMatcher(DataWrapper(Exception("No internet")))))
    }

    @Test
    fun testRepoList() {
        val listIn = listOf(Repo("Repo1"), Repo("Repo2"))
        `when`(repoRepository.getRepos("mbmc"))
            .thenReturn(Observable.just(listIn))
        repoViewModel.observeRepos().observeForever(observer)
        repoViewModel.getRepos("mbmc")
        val listOut = listOf(Repo("Repo1"), Repo("Repo2"))
        verify(observer).onChanged(argThat(RepoMatcher(DataWrapper(listOut))))
    }

}