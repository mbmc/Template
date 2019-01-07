package com.mbmc.template.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mbmc.template.domain.usecase.RepoUseCase
import com.mbmc.template.entity.Mapper
import com.mbmc.template.entity.Repo
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class RepoViewModel @Inject constructor(private val repoUseCase: RepoUseCase,
                                        private val mapper: Mapper) : ViewModel() {
    companion object {
        private const val TAG = "REPO_VIEW_MODEL"
    }

    private val data = MutableLiveData<DataWrapper<List<Repo>>>()
    private val disposables = CompositeDisposable()

    fun observeRepos(): LiveData<DataWrapper<List<Repo>>> = data

    fun getRepos(handle: String) {
        disposables.add(repoUseCase.getRepos(handle)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { result -> data.setValue(DataWrapper(result.map { data -> mapper.domainToPresentation(data) })) },
                    { error -> data.setValue(DataWrapper(error as Throwable)) }
                ))
    }

    override fun onCleared() {
        super.onCleared()
        disposables.dispose()
    }
}
