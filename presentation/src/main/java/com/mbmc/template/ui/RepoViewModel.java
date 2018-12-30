package com.mbmc.template.ui;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.mbmc.template.domain.entity.Repo;
import com.mbmc.template.domain.usecase.RepoUseCase;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

import javax.inject.Inject;
import java.util.List;

public class RepoViewModel extends ViewModel {

    private static final String TAG = "REPO_VIEW_MODEL";

    private final MutableLiveData<DataWrapper<List<Repo>>> data = new MutableLiveData<>();
    private final CompositeDisposable disposables = new CompositeDisposable();
    private final RepoUseCase repoUseCase;

    @Inject
    public RepoViewModel(RepoUseCase repoUseCase) {
        this.repoUseCase = repoUseCase;
    }

    public LiveData<DataWrapper<List<Repo>>> observeRepos() {
        return data;
    }

    public void getRepos(String handle) {
        disposables.add(repoUseCase.getRepos(handle)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        repos -> data.setValue(new DataWrapper<>(repos)),
                        throwable -> data.setValue(new DataWrapper<>(throwable))
                ));
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposables.dispose();
    }

}
