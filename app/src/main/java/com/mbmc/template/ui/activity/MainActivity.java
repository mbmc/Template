package com.mbmc.template.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.mbmc.template.BuildConfig;
import com.mbmc.template.R;
import com.mbmc.template.constant.Url;
import com.mbmc.template.model.Ip;
import com.mbmc.template.model.Repo;
import com.mbmc.template.ui.adapter.RepoAdapter;
import com.mbmc.template.ui.fragment.DialogFragment;
import com.mbmc.template.ui.fragment.RepoFragment;
import com.mbmc.template.util.Bundles;
import com.jakewharton.rxbinding.widget.RxTextView;

import org.parceler.Parcels;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import butterknife.BindView;
import butterknife.OnClick;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;


public class MainActivity extends BaseActivity {

    private static final String TAG = "MainActivity";
    private static final String DATA = "repo_data";

    @BindView(R.id.main_endpoint) TextView endPointView;
    @BindView(R.id.main_token) TextView tokenView;
    @BindView(R.id.main_scope) TextView scopeView;
    @BindView(R.id.main_ip) TextView ipView;
    @BindView(R.id.main_logo) ImageView logoView;

    @BindView(R.id.main_repos) RecyclerView reposView;
    @BindView(R.id.loading) View loadingView;
    @BindView(R.id.main_github_handle)EditText githubHandleView;
    @BindView(R.id.main_submit) View submitView;

    @Inject @Named("SomeToken") String token;
    @Inject @Named("UiScope") String scope;

    private RepoAdapter repoAdapter = new RepoAdapter();
    private List<Repo> repos;


    // @TODO: show debug view only when needed
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bind();
        getUiComponent().inject(this);
        setupUi(savedInstanceState);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putParcelable(DATA, Parcels.wrap(repos));
        super.onSaveInstanceState(outState);
    }

    public void showRepo(Repo repo) {
        showFragment(RepoFragment.class, repo);
    }

    @OnClick(R.id.main_submit)
    void sumbit() {
        getRepos();
        hideKeyboard();
    }

    @OnClick(R.id.main_info)
    void info() {
        startActivity(new Intent(this, AnotherActivity.class));
    }


    private void showFragment(Class fragment, Object object) {
        try {
            DialogFragment dialogFragment = (DialogFragment) fragment.newInstance();
            dialogFragment.setArguments(Bundles.parcelableBundle(object));
            dialogFragment.show(getFragmentManager(), fragment.getSimpleName());
        } catch (Exception exception) {

        }
    }

    private void setupUi(Bundle savedInstanceState) {
        imageLoader.get(this, Url.ANDROID, logoView);

        endPointView.setText(getString(R.string.end_point, BuildConfig.END_POINT));
        scopeView.setText(getString(R.string.scope, scope));
        tokenView.setText(getString(R.string.token, token));

        reposView.setAdapter(repoAdapter);
        if (savedInstanceState != null) {
            setContent((List<Repo>) Parcels.unwrap(savedInstanceState.getParcelable(DATA)));
        }

        subscription = ipApi.getIp()
                .subscribeOn(scheduler)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Ip>() {
                    @Override
                    public void onCompleted() {
                        loadingView.setVisibility(View.GONE);
                    }

                    @Override
                    public void onError(Throwable e) {
                        handleApiError(e);
                        onCompleted();
                    }

                    @Override
                    public void onNext(Ip ip) {
                        ipView.setText(getString(R.string.ip, ip.ip));
                    }
                });

        RxTextView.textChanges(githubHandleView)
                .subscribe(new Action1<CharSequence>() {
                    @Override
                    public void call(CharSequence charSequence) {
                        submitView.setEnabled(charSequence.length() > 0);
                    }
                });
    }

    private void setContent(List<Repo> repos) {
        this.repos = repos;
        if (repos != null) {
            repoAdapter.setContent(repos);
        }
    }

    private void getRepos() {
        loadingView.setVisibility(View.VISIBLE);
        subscription = githubApi.getRepos(githubHandleView.getText().toString())
                .subscribeOn(scheduler)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<Repo>>() {
                    @Override
                    public void onCompleted() {
                        loadingView.setVisibility(View.GONE);
                    }

                    @Override
                    public void onError(Throwable e) {
                        handleApiError(e);
                        onCompleted();
                    }

                    @Override
                    public void onNext(List<Repo> repos) {
                        setContent(repos);
                    }
                });
    }

}
