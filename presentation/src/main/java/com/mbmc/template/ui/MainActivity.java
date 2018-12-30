package com.mbmc.template.ui;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.mbmc.template.R;
import com.mbmc.template.databinding.ActivityMainBinding;
import com.mbmc.template.event.UserEventHandler;
import dagger.android.AndroidInjection;
import io.reactivex.disposables.CompositeDisposable;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements UserEventHandler {

    @Inject ViewModelProvider.Factory viewModelFactory;
    private final CompositeDisposable disposables = new CompositeDisposable();
    private final UiSate uiSate = new UiSate();
    private final RepoAdapter repoAdapter = new RepoAdapter();
    private RepoViewModel repoViewModel;
    private ActivityMainBinding binding;
    private String handle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidInjection.inject(this);
        setupUi();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        disposables.dispose();
    }

    @Override
    public void onClicked() {
        uiSate.setIsLoading();
        getRepos(handle);
    }

    @Override
    public void onRetryClicked() {
        onClicked();
    }

    @Override
    public void onTextChanged(CharSequence charSequence) {
        handle = charSequence.toString();
        uiSate.setHasText(!TextUtils.isEmpty(handle));
    }

    private void setupUi() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        repoViewModel = ViewModelProviders
                .of(this, viewModelFactory).get(RepoViewModel.class);

        binding.setUserEventHandler(this);
        binding.setUiState(uiSate);
        binding.setAdapter(repoAdapter);

        repoViewModel.observeRepos()
                .observe(this, result -> {
                    uiSate.setIsIdle();
                    if (result.throwable == null) {
                        repoAdapter.setContent(result.data);
                    } else {
                        uiSate.setHasError();
                    }
                });
    }

    private void getRepos(String handle) {
        repoViewModel.getRepos(handle);
    }

}
