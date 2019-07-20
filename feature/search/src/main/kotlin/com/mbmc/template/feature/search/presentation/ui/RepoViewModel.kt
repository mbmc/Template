package com.mbmc.template.feature.search.presentation.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mbmc.template.common.core.util.Schedulers
import com.mbmc.template.feature.search.domain.usecase.RepoUseCase
import com.mbmc.template.feature.search.presentation.entity.Mapper
import com.mbmc.template.feature.search.presentation.entity.Repo
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class RepoViewModel @Inject constructor(
    private val repoUseCase: RepoUseCase,
    private val mapper: Mapper,
    private val schedulers: Schedulers
) : ViewModel() {
    companion object {
        private const val TAG = "REPO_VIEW_MODEL"
    }

    private val _data = MutableLiveData<DataWrapper<List<Repo>>>()
    private val disposables = CompositeDisposable()

    val observeRepos: LiveData<DataWrapper<List<Repo>>>
        get() = _data

    fun getRepos(handle: String) {
        disposables.add(repoUseCase.getRepos(handle)
            .compose(schedulers.ioToMain())
            .doOnSubscribe {
                _data.value = DataWrapper(DataWrapper.State.LOADING)
            }
            .doFinally {
                _data.value = DataWrapper(DataWrapper.State.INIT)
            }
            .subscribe(
                { result -> _data.value = DataWrapper(result.map { data -> mapper.domainToPresentation(data) }) },
                { error -> _data.value = DataWrapper(error) }
            ))
    }

    override fun onCleared() {
        super.onCleared()
        disposables.dispose()
    }
}
